package com.ltong.medicinal.util.weixin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ltong.medicinal.util.common.AesCbcUtil;
import com.ltong.medicinal.util.common.GlobalConstant;
import com.ltong.medicinal.util.common.HttpClientUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName com.ltong.medicinal.util.weixin.WeiXinUtils
 * @Created by LTong
 * @since 2020-07-06 上午 11:02
 * 微信工具类
 */
@Slf4j
public class WeiXinUtils {
    /**
     * 获取accesstoken
     */
    public static String getAccessToken() {
        HashMap<String, String> param = new HashMap<>();
        param.put("grant_type", "client_credential");
        param.put("appid", GlobalConstant.WX_APPID);
        param.put("secret", GlobalConstant.WX_APPSECRET);
        //发送请求
        String result = HttpClientUtil.doGet(GlobalConstant.GET_ACCESS_TOKEN, param);
        //解析相应内容（转换成json对象）
        JSONObject jsonObject = JSON.parseObject(result);
        if (jsonObject == null) return "网络获取access_token失败";
        String access_token = jsonObject.get("access_token").toString();
        Integer expires_in = (Integer) jsonObject.get("expires_in");//凭证有效时间，单位：秒
        if (StringUtils.isEmpty(access_token) || expires_in == null || expires_in <= 10) {
            return "网络获取access_token错误";
        }
        return access_token;
    }

    /**
     * 获取用户信息
     *
     * @param code
     * @return
     */
    public static String getOpenId(String code) {
        Map<String, String> param = new HashMap<>();
        param.put("appid", GlobalConstant.WX_APPID);
        param.put("secret", GlobalConstant.WX_APPSECRET);
        param.put("js_code", code);
        param.put("grant_type", "authorization_code");
        String result = HttpClientUtil.doGet(GlobalConstant.GET_SESSION_BY_CODE, param);

        return result ;
    }

    public static String decipheringUser(String session_key,String encryptedData, String iv,String code){
        try {
            String decrypt= AesCbcUtil.decrypt(encryptedData.replace(" ", "+"), session_key, iv, "UTF-8");
            if(decrypt != null && decrypt.length() > 0){
                log.info("---------------->>>>>>>>>>>>>>>解密成功");
                return decrypt ;
            }else {
                log.info("---------------->>>>>>>>>>>>>>>解密失败");
                return null ;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null ;
    }

}
