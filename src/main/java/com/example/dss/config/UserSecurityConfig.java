package com.example.dss.config;

import com.example.dss.domain.User;
import com.example.dss.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserSecurityConfig implements UserDetailsService {

    private final static Logger logger = LoggerFactory.getLogger(UserDetailsService.class);
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final User user = userService.getUserByName(username);
        if (null == user) {
            throw new UsernameNotFoundException("用户不存在");
        }
        if (logger.isDebugEnabled()) {
            logger.debug("开始开始执行密码校验过程");
        }
        final UserDetails userDetails = new org.springframework.security.core.userdetails.User(username, user.getPassword(), AuthorityUtils.createAuthorityList());
        logger.info("userDetails = {}", userDetails);
        return userDetails;
    }
}
