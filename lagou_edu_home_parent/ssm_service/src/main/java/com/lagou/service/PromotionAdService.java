package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.PromotionAd;
import com.lagou.domain.PromotionAdVO;

import java.util.List;

/**
 * @author lkjl_java
 * @Description:
 * @date 2021/4/2 - 13:30
 */
public interface PromotionAdService {
    /*
        分页查询广告信息
     */
    public PageInfo<PromotionAd> findAllPromotionAdByPage(PromotionAdVO promotionAdVO);

    /*
        广告动态上下线
     */
    public void updatePromotionAdStatus(int id, int status);

    /*
        新增广告信息
     */
    void savePromotionAd(PromotionAd promotionAd);

    /*
        修改广告信息
     */
    void updatePromotionAd(PromotionAd promotionAd);

    /*
       根据id查找广告信息
    */
    PromotionAd findPromotionAdById(Integer id);
}
