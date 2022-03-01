package com.example.dss.mapper;

import com.example.dss.domain.Role;
import com.example.dss.domain.User;
import com.example.dss.domain.UserRoleRelation;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserMapper {

    private static Map<String, User> userDatabase;
    private static Map<Integer, Role> roleDatabase;
    private static Map<Integer, UserRoleRelation> userRoleRelationDatabase;

    static {
        userDatabase = new HashMap<>();
        userDatabase.put("admin", new User(1, "admin", "21232f297a57a5a743894a0e4a801fc3"));
        userDatabase.put("guest", new User(2, "guest", "084e0343a0486ff05530df6c705c8bb4"));
        userDatabase.put("anonymous", new User(3, "anonymous", "294de3557d9d00b3d2d8a1e6aab028cf"));

        roleDatabase = new HashMap<>();
        roleDatabase.put(1, new Role(1, "admin_read", new String[]{"read"}));
        roleDatabase.put(2, new Role(2, "guest_read", new String[]{"read"}));
        roleDatabase.put(3, new Role(3, "anonymous_read", new String[]{"read"}));
        roleDatabase.put(4, new Role(4, "admin_write", new String[]{"read", "write"}));
        roleDatabase.put(5, new Role(5, "guest_write", new String[]{"read", "write"}));
        roleDatabase.put(6, new Role(6, "anonymous_write", new String[]{"read", "write"}));

        userRoleRelationDatabase = new HashMap<>();
        userRoleRelationDatabase.put(1, new UserRoleRelation(1, new Integer[]{1, 2, 3, 4, 5, 6}));
        userRoleRelationDatabase.put(2, new UserRoleRelation(2, new Integer[]{2, 3, 5, 6}));
        userRoleRelationDatabase.put(3, new UserRoleRelation(3, new Integer[]{3, 6}));
    }


    public User getUserByName(String name) {
        return userDatabase.get(name);
    }

    public List<String> getRoles(Integer userId) {
        final UserRoleRelation userRoleRelation = userRoleRelationDatabase.get(userId);
        return Arrays.stream(userRoleRelation.getRoleIds()).map(item -> roleDatabase.get(item).getRoleName()).collect(Collectors.toList());
    }



}
