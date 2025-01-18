package com.scst.result;

import lombok.Data;

@Data
//控制层返回结果的模型类，用于后端与前端进行数据格式统一
public class Result<T> {
    private Boolean flag;  //成功或异常标识
    private String msg;    //成功或异常信息
    private T data;   //数据内容（后端对象以JSON格式被传到前端后其成员变量属性名可能被转变为小写）


    public Result() {
    }

    public Result(Boolean flag) {
        this.flag = flag;
    }

    public Result(Boolean flag, T data) {
        this.flag = flag;
        this.data = data;
    }

    public Result(Boolean flag, String msg) {
        this.flag = flag;
        this.msg = msg;
    }

    public static <T> Result<T> success(T object) {
        Result<T> result = new Result<T>();
        result.data = object;
        result.flag = true;
        return result;
    }

    public static <T> Result<T> error(String msg) {
        Result result = new Result();
        result.msg = msg;
        result.flag = false;
        return result;
    }
}
