package com.example.warehousemanage.entity;

import javax.annotation.sql.DataSourceDefinition;
import java.util.HashMap;
import java.util.Objects;

//用于封装前端分页请求传来的分页信息与查询信息
public class QueryPageAndParams {
    public static Integer PAGE_SIZE = 10;
    public static Integer PAGE_NUM = 1;

    private Integer pageSize = PAGE_SIZE;
    private Integer pageNum = PAGE_NUM;

    //通过map查询存储信息(Springboot会将前端的JSON数据自动转化为map)
    private HashMap params;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public HashMap getParams() {
        return params;
    }

    public void setParas(HashMap params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "QueryPageAndParams{" +
                "pageSize=" + pageSize +
                ", pageNum=" + pageNum +
                ", params=" + params +
                '}';
    }
}