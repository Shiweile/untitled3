package com.shiweile.pojo;

import java.util.List;

public class goodsBean<T> {
    private int totalCount;
    private List<T> rows;

    @Override
    public String toString() {
        return "goodsBean{" +
                "totalCount=" + totalCount +
                ", rows=" + rows +
                '}';
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public goodsBean() {
    }

    public goodsBean(int totalCount, List<T> rows) {
        this.totalCount = totalCount;
        this.rows = rows;
    }
}
