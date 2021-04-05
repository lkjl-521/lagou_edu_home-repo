package com.lagou.domain;

import java.util.List;

/**
 * @author lkjl_java
 * @Description:
 * @date 2021/4/5 - 17:49
 */
public class RoleResourceVO {
    private Integer roleId;
    private List<Integer> resourceIdList;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public List<Integer> getResourceIdList() {
        return resourceIdList;
    }

    public void setResourceIdList(List<Integer> resourceIdList) {
        this.resourceIdList = resourceIdList;
    }
}
