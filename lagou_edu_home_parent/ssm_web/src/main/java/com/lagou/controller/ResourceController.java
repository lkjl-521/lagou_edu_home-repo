package com.lagou.controller;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.Resource;
import com.lagou.domain.ResourceVO;
import com.lagou.domain.ResponseResult;
import com.lagou.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lkjl_java
 * @Description:
 * @date 2021/4/3 - 10:36
 */
@RestController
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    /*
        资源分类和多条件查询
    */
    @RequestMapping("/findAllResource")
    public ResponseResult findAllResource(@RequestBody ResourceVO resourceVO) {
        PageInfo<Resource> allResourceByPage = resourceService.findAllResourceByPage(resourceVO);

        return  new ResponseResult(true, 200, "查询资源信息成功", allResourceByPage);
    }

    /*
        添加或修改资源
     */
    @RequestMapping("/saveOrUpdateResource")
    public ResponseResult saveResource(@RequestBody Resource resource) {
        if (resource.getId() == null) {
            resourceService.saveResource(resource);
            return new ResponseResult(true, 200, "新增成功", null);
        } else {
            resourceService.updateResource(resource);
            return new ResponseResult(true, 200, "修改成功", null);
        }
    }

    /*
        删除资源
     */
    @RequestMapping("/deleteResource")
    public ResponseResult deleteResource(Integer id) {
        resourceService.deleteResource(id);
        return new ResponseResult(true, 200, "删除成功", null);
    }
}
