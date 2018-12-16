package com.sh.entity;

import java.util.List;

/**
 * @author 麦客子
 * @desc 分页结果类
 * @email leeshuhua@163.com
 * @create 2018/12/14 7:35
 **/
public class PageResult<T> {

    private long total;

    private List<T> rows;

    public PageResult() {
    }

    public PageResult(long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
