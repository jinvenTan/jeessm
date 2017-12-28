package com.jinve.jeessm.web.sys.security;

import com.jinve.jeessm.common.utils.Encodes;
import com.jinve.jeessm.web.sys.entity.User;
import com.jinve.jeessm.web.sys.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.config.ConfigurationException;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.JdbcUtils;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 系统安全认证实现类
 * @author jinven
 * @create 2017-12-19 11:27
 **/
@Service
public class SystemAuthorizingRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;
    private static Logger log = LogManager.getLogger(SystemAuthorizingRealm.class);

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String username = upToken.getUsername();

        // Null username is invalid
        if (username == null) {
            throw new AccountException("Null usernames are not allowed by this realm.");
        }

        SimpleAuthenticationInfo info = null;
        try {

            String password = null;
            User user = userService.getUserByUserName(upToken.getUsername());
            if (user == null) {
                throw new UnknownAccountException("No account found for user [" + username + "]");
            }
            return new SimpleAuthenticationInfo(username,user.getPassword(),ByteSource.Util.bytes(user.getLoginName()),getName());

        } catch (Exception e) {
            final String message = "There was a SQL error while authenticating user [" + username + "]";
            if (log.isErrorEnabled()) {
                log.error(message, e);
            }

            // Rethrow any SQL errors as an authentication exception
            throw new AuthenticationException(message, e);
        }
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Object principal = getAvailablePrincipal(principals);
        return null;
    }
    /**
     * 设定密码校验的Hash算法与迭代次数
     */
    @PostConstruct
    public void initCredentialsMatcher() {
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher("SHA-1");
        matcher.setHashIterations(1024);
        setCredentialsMatcher(matcher);
    }
}
