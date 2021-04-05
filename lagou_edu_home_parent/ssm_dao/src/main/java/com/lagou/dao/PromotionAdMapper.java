package com.lagou.dao;

import com.lagou.domain.PromotionAd;

import java.util.List;

/**
 * @author lkjl_java
 * @Description:
 * @date 2021/4/2 - 13:18
 */
public interface PromotionAdMapper {
    /*
        分页查询广告信息
     */
    public List<PromotionAd> findAllPromotionAdByPage();

    /*
        广告动态上下线
     */
    public void updatePromotionAdStatus(PromotionAd promotionAd);
}
