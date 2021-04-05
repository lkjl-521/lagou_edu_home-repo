package com.lagou.domain;

/**
 * @author lkjl_java
 * @Description:
 * @date 2021/4/3 - 10:23
 */
public class ResourceVO {
    private Integer currentPage; // 当前页
    private Integer pageSize;  // 每页显示的数量
    private String name;  // 资源名称
    private Integer categoryId;   // 资源分类ID
    private String url;  // 资源路径

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
