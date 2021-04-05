package com.lagou.domain;

/**
 * @author lkjl_java
 * @Description:
 * @date 2021/4/2 - 13:34
 */
public class PromotionAdVO {
    // 当前页
    private Integer currentPage;
    // 每页显示的条数
    private Integer pageSize;

    @Override
    public String toString() {
        return "PromotionAdVo{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                '}';
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
