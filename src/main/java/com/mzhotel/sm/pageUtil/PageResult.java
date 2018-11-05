package com.mzhotel.sm.pageUtil;

import com.github.pagehelper.Page;

import java.util.List;

public class PageResult<T> {
    private List<T> data;

    private PageBean pageBean;

    public PageResult() {
    }

    public PageResult(Page<T> page) {
        data = page;
        pageBean = new PageBean();
        pageBean.setEndRow(page.getEndRow());
        pageBean.setStartRow(page.getStartRow());
        pageBean.setPageNum(page.getPageNum());
        pageBean.setPageSize(page.getPageSize());
        pageBean.setPages(page.getPages());
        pageBean.setTotal(page.getTotal());
        pageBean.setTotalCount(page.getTotal());
    }

    public PageResult(List<T> data, PageBean pageBean) {
        this.data = data;
        this.pageBean = pageBean;
    }

    public static <T> PageResult<T> buildResult(Page<T> page) {
        return new PageResult<T>(page);
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public void setPageBean(PageBean pageBean) {
        this.pageBean = pageBean;
    }

    public List<T> getData() {
        return data;
    }

    public PageBean getPageBean() {
        return pageBean;
    }
}
