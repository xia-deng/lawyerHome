package com.xia.lawyer.shiro;

import com.xia.lawyer.models.system.Permission;
import com.xia.lawyer.models.system.Role;
import com.xia.lawyer.models.system.User;
import com.xia.lawyer.service.system.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tingli2 on 2/21/2017.
 */
public class ShiroRealm extends AuthorizingRealm{

    @Autowired
    private UserService userService;

    /**
     * 获取权限
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
        User user= (User) principalCollection.getPrimaryPrincipal();
        //获取用户的角色名称以及各个角色对应的权限名称
        user.getRoles().forEach(role -> {authorizationInfo.addRole(role.getRole());
            role.getPermissions().forEach(permission -> authorizationInfo.addStringPermission(permission.getPermissionName()));});
        //加入用户的部门名
        authorizationInfo.addRole(user.getDepartment().getDepartment());
        //加入部门拥有的权限名称
        user.getDepartment().getPermissions().forEach(permission -> authorizationInfo.addStringPermission(permission.getPermissionName()));
        //返回角色对象
        return authorizationInfo;
    }


    /**
     * 认证信息(身份验证) Authentication 是用来验证用户身份
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 获取用户的输入帐号
        String username = (String) authenticationToken.getPrincipal();
        System.out.println(authenticationToken.getCredentials());
        // 通过username从数据库中查找 User对象，如果找到，没找到.
        // 实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        User user=userService.findByUsername(username);
        if(username.equals("xia_deng")){
            user=new User("xia_deng",
                    new Md5Hash("123456", "xia_deng", 2).toString(),"xia_deng",(byte) 1);
        }

        if(user==null){
            return null;
        }

        SimpleAuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(user,user.getPassword(),
                ByteSource.Util.bytes(user.getSalt()),getName());
        return authenticationInfo;
    }
}
