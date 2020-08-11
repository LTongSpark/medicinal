package com.ltong.medicinal.bus.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ltong.medicinal.bus.entity.Address;
import com.ltong.medicinal.bus.entity.User;
import com.ltong.medicinal.bus.service.AddresssService;
import com.ltong.medicinal.bus.service.UserService;
import com.ltong.medicinal.bus.vo.UserVo;
import com.ltong.medicinal.util.common.AjaxResult;
import com.ltong.medicinal.util.common.AppFileUtils;
import com.ltong.medicinal.util.weixin.WeiXinUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName com.ltong.medicinal.bus.controller.UserController
 * @Created by LTong
 * @since 2020-06-19 下午 3:44
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AddresssService addresssService;

    /**
     * 得到全部的微信用户
     *
     * @param userVo
     * @return
     */
    @RequestMapping("loadAllUser")
    public AjaxResult loadAllAddress(UserVo userVo) {

        IPage<User> page = new Page<>(userVo.getPage(), userVo.getLimit());
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //进行模糊查询
        queryWrapper.like(StringUtils.isNotBlank(userVo.getNickName()), "nickName", userVo.getNickName());
        //queryWrapper.eq(StringUtils.isNotBlank(addressVo.getPhone()), "phone", addressVo.getPhone());
        //时间进行比对
        queryWrapper.ge(userVo.getStartTime() != null, "logintime", userVo.getStartTime());
        queryWrapper.ge(userVo.getEndTime() != null, "logintime", userVo.getEndTime());
        //queryWrapper.orderByDesc("logintime");
        IPage<User> userIPage = userService.page(page, queryWrapper);
        userIPage.getRecords().forEach(v -> {
            Address addressId = addresssService.getById(v.getId());
            if (addressId != null) {
                v.setName(addressId.getName());
                v.setPhone(addressId.getPhone());
                v.setShdz(addressId.getCity() + addressId.getCountry() + addressId.getAddress());
                v.setState(addressId.getState());
            }
        });
        page.getTotal();
        return new AjaxResult(page.getTotal(), page.getRecords());
    }

    @RequestMapping("/getUserByCode")
    public AjaxResult getUserByCode(String rawData, String encryptedData, String iv, String code) {
        String openId = WeiXinUtils.getOpenId(code);
        //解析相应内容（转换成json对象）
        JSONObject json = JSONObject.parseObject(openId);
        //获取会话密钥（session_key）
        String session_key = json.get("session_key").toString();
        String openid = json.get("openid").toString();
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.eq("openid", openid);
        User serviceOne = userService.getOne(queryWrapper);
        HashMap<String, String> hashMap = new HashMap<>();
        if (serviceOne != null) {
            //用户已存在
            hashMap.put("user_id", serviceOne.getId().toString());
        } else {
            //第一次注册登录
            JSONObject result = JSON.parseObject(rawData);
            User user = new User();
            user.setCountry(result.getOrDefault("country", "").toString());
            user.setGender((Integer) result.getOrDefault("gender", 0));
            user.setOpenid(openid);
            user.setProvince(result.getOrDefault("province", "").toString());
            user.setCity(result.getOrDefault("city", "").toString());
            user.setNickName(result.getOrDefault("nickName", "").toString());
            //下载用户图像
            String avatarUrl = result.getOrDefault("avatarUrl", "").toString();
            if (StringUtils.isNotBlank(avatarUrl)) {
                Map picture = AppFileUtils.downloadPicture(avatarUrl);
                user.setAvatarUrl(picture.getOrDefault("path", "").toString());
            }
            userService.save(user);
            hashMap.put("user_id", user.getId().toString());
        }
        return AjaxResult.success(hashMap);
    }

    @RequestMapping("/listPage")
    public String listPage() {
        return "user/list";
    }

    @RequestMapping("/updateUser")
    public AjaxResult updateUser(HttpServletRequest request, Integer userId, UserVo userVo) {
        try {
            userVo.setId(userId);
            if (userVo.getId() == null) return AjaxResult.fail("参数有误，userid");
            //先保存用户的微信部分信息，不包括头像
            userService.updateById(userVo);
            return AjaxResult.success("保存成功");
        } catch (Exception e) {
            return AjaxResult.fail("用户信息保存失败");
        }
    }
}
