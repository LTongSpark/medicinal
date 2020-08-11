package com.ltong.medicinal.util.common;


/**
 * @Created by LTong
 * @since 2020-06-17 上午 11:30
 */
public class GlobalConstant {
    /**
     * 状态码  正常 200  错误  -1
     */
    public static final Integer OK = 200;
    public static final Integer ERROR = -1;

    /**
     * 未完善用户资料
     */
    public static final Integer KEY_CODE_NOT_GET_USERINFO = -3;

    /**
     * 用户默认密码
     */
    public static final String USER_DEFAULT_PWD = "tong0614";

    /**
     * 菜单可用状态  0不可用   1可用
     */
    public static final Object AVAILABLE_TRUE = 1;
    public static final Object AVAILABLE_FALSE = 0;

    /**
     * 菜单和权限类型   menu  菜单   permission  权限
     */
    public static final String TYPE_MENU = "menu";
    public static final String TYPE_PERMISSION = "permission";

    /**
     * 用户类型   0 超级管理员   1 系统用户
     */
    public static final Integer USER_TYPE_SUPER = 0;
    public static final Integer USER_TYPE_NORMAL = 1;

    /**
     * 菜单是否展开 0不展开  1展开
     */
    public static final Integer OPEN_TRUE = 1;
    public static final Integer OPEN_FALSE = 0;

    /**
     * 商品默认图片
     */
    public static final String DEFAULT_IMG_GOODS = "/images/noDefaultImage.jpg";

    /**
     * hash散列次数
     */
    public static final Integer HASHITERATIONS = 2;

    /**
     * 用户默认图片
     */
    public static final String DEFAULT_IMG_USER = "/images/defaultUserTitle.jpg";


    //微信相关
    /**
     * 小程序唯一标识 (在微信小程序管理后台获取)
     */
    public static final String WX_APPID = "wxf1995a49a0b70e86";
    /**
     * 小程序的 app secret (在微信小程序管理后台获取)
     */
    public static final String WX_APPSECRET = "cbbcb2c2f3dd6bfbec377c1f5afa028f";
    /**
     * 授权类型-登录认证（必填）
     */
    public static final String GRANT_TYPE_AUTHORIZATION_CODE = "authorization_code";
    /**
     * 授权类型-access_token认证（必填）
     */
    public static final String GRANT_TYPE_ACCESS_TOKEN = "access_token";

    public static final String GET_SESSION_BY_CODE = "https://api.weixin.qq.com/sns/jscode2session";
    public static final String GET_ACCESS_TOKEN = "https://api.weixin.qq.com/cgi-bin/token";

    public static final String GET_WEIXIN_USER_URL = "https://api.weixin.qq.com/cgi-bin/user/info?";
}
