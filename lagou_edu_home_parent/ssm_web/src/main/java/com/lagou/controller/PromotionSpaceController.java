package com.lagou.controller;

import com.lagou.domain.PromotionSpace;
import com.lagou.domain.ResponseResult;
import com.lagou.service.PromotionSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author lkjl_java
 * @Description:
 * @date 2021/4/2 - 11:32
 */
@RestController
@RequestMapping("/PromotionSpace")
public class PromotionSpaceController {

    @Autowired
    private PromotionSpaceService pss;

    @RequestMapping("/findAllPromotionSpace")
    public ResponseResult findAllPromotionSpace() {
        List<PromotionSpace> list = pss.findAllPromotionSpace();

        ResponseResult responseResult = new ResponseResult(true, 200, "查询所有广告位成功", list);

        return responseResult;
    }

    /*
       添加或修改广告位
    */
    @RequestMapping("/saveOrUpdatePromotionSpace")
    public ResponseResult saveOrUpdatePromotionSpace(@RequestBody PromotionSpace promotionSpace) {

        if (promotionSpace.getId() == null) {
            // 新增
            pss.savePromotionSpace(promotionSpace);
            return new ResponseResult(true, 200, "新增广告位成功", null);
        } else {
            pss.updatePromotionSpace(promotionSpace);
            return new ResponseResult(true, 200, "修改广告位成功", null);
        }

    }

    /*
        回显广告为信息
     */
    @RequestMapping("/findPromotionSpaceById")
    public ResponseResult findPromotionSpaceById(int id) {
        PromotionSpace promotionSpace = pss.findPromotionSpaceById(id);

        return new ResponseResult(true, 200, "回显广告位信息成功", promotionSpace);
    }

}
