package com.cxzc.mycxzc.demo.config;

import com.cxzc.mycxzc.demo.bean.User;
import com.cxzc.mycxzc.demo.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class BookCricleRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * 获取用户角色和权限，用于权限认证
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo s = new SimpleAuthorizationInfo();
        return s;
    }

    /**
     * 获取认证信息，即根据 token 中的用户名从数据库中获取密码、盐等并返回
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取输入的用户账号，并通过账号获取相关信息
        String userName = token.getPrincipal().toString();
        User user = userService.getByName(userName);
        String passwordDB = user.getPassword();
        String salt = user.getSalt();
        //将查询到的用户账号和密码存放到 authenticationInfo用于后面的权限判断。第三个参数传入用户输入的用户名。
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userName, passwordDB, getName());
        System.out.println("user=="+user.toString());
        //设置盐，用来核对密码
        authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(salt));
        return authenticationInfo;
    }
}