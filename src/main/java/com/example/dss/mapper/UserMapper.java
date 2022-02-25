package com.example.dss.mapper;

import com.example.dss.domain.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserMapper {

    private static Map<String, User> userMap;

    static {
        userMap = new HashMap<>();
        userMap.put("muyi-1",new User(1,"muyi-1","4c68cea7e58591b579fd074bcdaff740"));
        userMap.put("muyi-2",new User(2,"muyi-2","db7282901da891bea2fcd73840caad1c"));
        userMap.put("muyi-3",new User(3,"muyi-3","e08599ba76fe6afa2b5786d857b0f56e"));
        userMap.put("muyi-4",new User(4,"muyi-4","9cc16a0bb48e3e50c4fd9c79444b393b"));
        userMap.put("muyi-5",new User(5,"muyi-5","e72581f8614727a152dec6fcfc739ad2"));
    }

    public User getUserByName(String name) {
        return userMap.get(name);
    }
}
