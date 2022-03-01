package com.example.dss.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Role {

    private Integer roleId;

    private String roleName;

    private String[] resources;
}
