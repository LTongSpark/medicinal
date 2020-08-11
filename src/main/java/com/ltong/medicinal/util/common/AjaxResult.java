package com.ltong.medicinal.util.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * @Created by LTong
 * @since 2020-06-17 上午 11:31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AjaxResult {

    private Integer code = 0 ;
    private  Object msg = "" ;
    private Long count = 0L ;
    private Object data ;
    private String token ;

    public AjaxResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public AjaxResult(Object data) {
        this.data = data;
    }

    public AjaxResult(Long count, Object data) {
        this.count = count;
        this.data = data;
    }

    public static AjaxResult fail(String msg) {
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setCode(GlobalConstant.ERROR);
        ajaxResult.setMsg(msg);
        return ajaxResult;
    }

    public static AjaxResult success(Object data) {
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setCode(GlobalConstant.OK);
        ajaxResult.setData(data);
        return ajaxResult;
    }
    public static AjaxResult success(Object data ,String token) {
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setCode(GlobalConstant.OK);
        ajaxResult.setMsg(data);
        ajaxResult.setToken(token);
        return ajaxResult;
    }

    public static AjaxResult success(String msg) {
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setMsg(msg);
        return ajaxResult;
    }

    public static AjaxResult notGetUserInfo(String token) {
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setCode(GlobalConstant.KEY_CODE_NOT_GET_USERINFO);
        ajaxResult.setMsg("用户信息不完善");
        ajaxResult.setData(token);
        return ajaxResult;
    }

    public static final AjaxResult LOGIN_SUCCESS=new AjaxResult(GlobalConstant.OK,"登陆成功");
    public static final AjaxResult LOGIN_ERROR_PASS=new AjaxResult(GlobalConstant.ERROR,"用户名或密码错误");
    public static final AjaxResult LOGIN_ERROR_CODE=new AjaxResult(GlobalConstant.ERROR,"验证码错误");

    public static final AjaxResult ADD_SUCCESS = new AjaxResult(GlobalConstant.OK,"添加成功");
    public static final AjaxResult ADD_ERROR = new AjaxResult(GlobalConstant.ERROR,"添加失败");

    public static final AjaxResult DELETE_SUCCESS = new AjaxResult(GlobalConstant.OK,"删除成功");
    public static final AjaxResult DELETE_ERROR = new AjaxResult(GlobalConstant.ERROR,"删除失败");

    public static final AjaxResult UPDATE_SUCCESS = new AjaxResult(GlobalConstant.OK,"修改成功");
    public static final AjaxResult UPDATE_ERROR = new AjaxResult(GlobalConstant.ERROR,"修改失败");

    public static final AjaxResult RESET_SUCCESS = new AjaxResult(GlobalConstant.OK,"重置成功");
    public static final AjaxResult RESET_ERROR = new AjaxResult(GlobalConstant.ERROR,"重置失败");

    public static final AjaxResult DISPATCH_SUCCESS = new AjaxResult(GlobalConstant.OK,"分配成功");
    public static final AjaxResult DISPATCH_ERROR = new AjaxResult(GlobalConstant.ERROR,"分配失败");

    public static final AjaxResult BACKINPORT_SUCCESS = new AjaxResult(GlobalConstant.OK,"退货成功");
    public static final AjaxResult BACKINPORT_ERROR = new AjaxResult(GlobalConstant.ERROR,"退货失败");
    public static final AjaxResult SYNCCACHE_SUCCESS = new AjaxResult(GlobalConstant.OK,"同步缓存成功");

    public static final AjaxResult DELETE_ERROR_NEWS = new AjaxResult(GlobalConstant.ERROR,"删除用户失败，该用户是其他用户的直属领导，请先修改该用户的下属的直属领导，再进行删除操作");
    public static final AjaxResult DELETE_QUERY = new AjaxResult();




}
