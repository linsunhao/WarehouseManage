package com.example.warehousemanage.Utils;

public class Result {
    private Integer code;
    private String msg;
    private Object data;
    private Long total;
    private String token;


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public static Result suc(Integer code, String msg, Object data, Long total){
        return new Result(code,msg,data,total);
    }


    public static Result fail(Integer code,String msg,Object data, Long total){
        return new Result(code,msg,data,total);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Result token(String token){
        this.token = token;
        return this;
    }

    public Result() {
    }

    public Result(Integer code, String msg, Object data, Long total) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.total = total;
    }

}