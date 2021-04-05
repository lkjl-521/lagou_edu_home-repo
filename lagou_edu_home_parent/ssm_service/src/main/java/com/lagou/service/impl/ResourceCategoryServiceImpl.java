package com.lagou.service.impl;

import com.lagou.dao.ResourceCategoryMapper;
import com.lagou.dao.ResourceMapper;
import com.lagou.domain.Resource;
import com.lagou.domain.ResourceCategory;
import com.lagou.domain.ResourceVO;
import com.lagou.domain.ResponseResult;
import com.lagou.service.ResourceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author lkjl_java
 * @Description:
 * @date 2021/4/3 - 11:40
 */
@Service
public class ResourceCategoryServiceImpl implements ResourceCategoryService {

    @Autowired
    private ResourceCategoryMapper resourceCategoryMapper;

    @Override
    public List<ResourceCategory> findAllResourceCategory() {
        return resourceCategoryMapper.findAllResourceCategory();
    }

    @Override
    public void saveResourceCategory(ResourceCategory resourceCategory) {
        // 补全信息
        Date date = new Date();
        resourceCategory.setCreatedTime(date);
        resourceCategory.setUpdatedTime(date);

        resourceCategory.setCreatedBy("system");
        resourceCategory.setUpdatedBy("system");

        // 保存
        resourceCategoryMapper.saveResourceCategory(resourceCategory);
    }

    @Override
    public void updateResourceCategory(ResourceCategory resourceCategory) {

        // 补全信息
        resourceCategory.setUpdatedTime(new Date());
        resourceCategory.setUpdatedBy("system");

        // 修改
        resourceCategoryMapper.updateResourceCategory(resourceCategory);
    }

    @Override
    public ResponseResult deleteResourceCategory(Integer id) {
        // 判断当前资源分类下是否关联着资源信息
        int count = resourceCategoryMapper.findResourceCategoryContainResource(id);
        // 判断
        if (count == 0) {
            resourceCategoryMapper.deleteResourceCategory(id);
            return new ResponseResult(true, 200, "资源分类信息删除成功", null);
        } else {
            return new ResponseResult(false, 400, "资源分类信息删除失败", null);
        }
    }
}
