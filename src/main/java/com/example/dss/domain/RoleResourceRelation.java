package com.example.dss.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleResourceRelation {
    private Integer roleId;
    private Integer resourceId;
}
