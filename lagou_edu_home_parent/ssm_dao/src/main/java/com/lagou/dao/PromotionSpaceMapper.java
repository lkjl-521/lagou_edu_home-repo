package com.lagou.dao;

import com.lagou.domain.PromotionSpace;

import java.util.List;

/**
 * @author lkjl_java
 * @Description:
 * @date 2021/4/2 - 11:22
 */
public interface PromotionSpaceMapper {
    /*
        获取所有广告位
     */
    public List<PromotionSpace> findAllPromotionSpace();

    /*
        添加广告位
     */
    public void savePromotionSpace(PromotionSpace promotionSpace);

    /*
        回显广告位信息
     */
    public PromotionSpace findPromotionSpaceById(int id);

    /*
        修改广告位信息
     */
    public void updatePromotionSpace(PromotionSpace promotionSpace);
}
