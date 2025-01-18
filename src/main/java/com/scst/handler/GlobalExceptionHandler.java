package com.scst.handler;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.scst.enumeration.FieldName;
import com.scst.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.validation.ObjectError;

//声明一个增强式控制器类
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
//    声明一个异常统一处理方法，用于拦截所有异常
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception ex) {
        //省略（记录日志，发送消息给运维，发送邮件给开发人员，ex对象发送给开发人员）
        log.error(ex.getMessage());
        return Result.error("服务器内部错误，请稍后再试");
    }


    @ExceptionHandler(BindException.class)
    public Result handleBindException(BindException ex) {
        log.error(ex.getMessage());
        return Result.error("输入数据错误，查询失败");
    }

    @ExceptionHandler(NullPointerException.class)
    public Result handleNullPointerException(NullPointerException ex) {
        // 返回一个自定义的错误消息，告知客户端出现了空指针异常
        log.error(ex.getMessage());
        return Result.error("请输入必填项");
    }

    // 处理 JSON 解析异常
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Result handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        log.error(ex.getMessage());
        Throwable cause = ex.getCause();
        if (cause instanceof InvalidFormatException) {
            InvalidFormatException invalidFormatException = (InvalidFormatException) cause;
            String fieldName = invalidFormatException.getPath().get(0).getFieldName();
            // 获取中文名称
            String chineseFieldName = FieldName.getChineseName(fieldName);
            if (chineseFieldName != null) {
                return Result.error(chineseFieldName + "的格式输入不正确，请重新输入！");
            }
        }
        return Result.error("请输入正确的数据");
    }


}
