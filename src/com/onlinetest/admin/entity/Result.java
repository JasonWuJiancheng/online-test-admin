package com.onlinetest.admin.entity;

/**
 * @author JasonWu
 * @create 2020-01-07-20:27
 */
public class Result {

    private Boolean status;// 状态
    private Integer code;// 状态码
    private String msg;// 消息
    private Object data;// 数据对象

    public Result() {
    }

    /**
     * 只返回状态，状态码，消息
     *
     * @param status
     * @param code
     * @param msg
     */
    public Result(Boolean status, Integer code, String msg) {
        super();
        this.status = status;
        this.code = code;
        this.msg = msg;
    }

    /**
     * 只返回状态，状态码，数据对象
     *
     * @param status
     * @param code
     * @param data
     */
    public Result(Boolean status, Integer code, Object data) {
        super();
        this.status = status;
        this.code = code;
        this.data = data;
    }

    /**
     * 只返回状态码，信息，数据对象
     *
     * @param msg
     * @param code
     * @param data
     */
    public Result(Integer code, String msg, Object data) {
        super();
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 返回全部信息即状态，状态码，消息，数据对象
     *
     * @param status
     * @param code
     * @param msg
     * @param data
     */
    public Result(Boolean status, Integer code, String msg, Object data) {
        super();
        this.status = status;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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

}
