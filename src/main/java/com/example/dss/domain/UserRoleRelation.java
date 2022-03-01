package com.example.dss.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRoleRelation {
    private Integer userId;

    private Integer[] roleIds;
}
