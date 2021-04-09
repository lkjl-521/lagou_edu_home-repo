package com.lagou.dao;

import com.lagou.domain.Resource;
import com.lagou.domain.ResourceVO;

import java.util.List;

/**
 * @author lkjl_java
 * @Description:
 * @date 2021/4/3 - 10:20
 */
public interface ResourceMapper {

    /*
        资源分类和多条件查询
    */
    public List<Resource> findAllResourceByPage(ResourceVO resourceVO);


    /*
        添加资源
     */
    void saveResource(Resource resource);

    /*
        修改资源
     */
    void updateResource(Resource resource);

    /*
        删除资源
     */
    void deleteResource(Integer id);

    /*
        删除资源角色关系
     */
    void deleteResourceContextRole(Integer resourceId);
}
