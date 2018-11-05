package com.mzhotel.sm.pageUtil;

import java.io.Serializable;

public class PageBean implements Serializable {
    private static final long serialVersionUID = 1l;
    private int pageNum;        //当前页码
    private int pageSize;    //每页记录数
    private int startRow;    // 当前页第一条记录数
    private int endRow;    // 当前页最后一条记录数
    private long total;        // 总记录数
    private long totalCount;        //
    private int pages;//总页数

    public PageBean() {
    }

    public PageBean(int pageNum, int pageSize, long total) {
        super();
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.total = total;
        this.pages = ((int) total + pageSize - 1) / pageSize;
        this.startRow = pageNum > 0 ? (pageNum - 1) * pageSize : 0;
        if (this.pages == (int) total) {
            this.endRow = (int) total;
        } else {
            this.endRow = pageNum * pageSize;
        }
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStartRow() {
        return startRow;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public int getEndRow() {
        return endRow;
    }

    public void setEndRow(int endRow) {
        this.endRow = endRow;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
