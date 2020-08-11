package com.ltong.medicinal.util.realm;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ltong.medicinal.sys.entity.SysUser;
import com.ltong.medicinal.sys.service.SysUserService;
import com.ltong.medicinal.util.common.ActiverUser;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Created by LTong
 * @since 2020-06-17 下午 1:27
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private SysUserService sysUserService;

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    /**
     * 授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 认证的方法
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        //拿到用户名
        queryWrapper.eq("username", token.getPrincipal().toString());
        SysUser sysUser = sysUserService.getOne(queryWrapper);
        if (sysUser != null) {
            ActiverUser activerUser = new ActiverUser();
            activerUser.setSysUser(sysUser);
            //生成盐
            ByteSource credentialsSalt = ByteSource.Util.bytes(sysUser.getSalt());
            /**
             * 参数说明：
             * 参数1：活动的User
             * 参数2：从数据库里面查询出来的密码(已经通过MD5加密)
             * 参数3：从数据库里面查询出来的盐
             * 参数4：当前类名
             */
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(activerUser, sysUser.getPassword(), credentialsSalt, this.getName());
            return info;
        }
        return null;
    }
}
