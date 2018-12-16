package com.sh.base.controller;

import com.sh.entity.Result;
import com.sh.entity.StatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 麦客子
 * @desc
 * @email leeshuhua@163.com
 * @create 2018/12/14 7:35
 **/
@ControllerAdvice
//@RestControllerAdvice
public class BaseExceptionHandler{

    /**
     * 处理异常的方法
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e){
        return new Result(false, StatusCode.ERROR,"执行失败 ",e.getMessage());
    }
}
