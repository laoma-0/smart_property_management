package org.xiaoguang.smartpropertymanagementsystemgb.entity;

import lombok.Data;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 统一API响应结果封装类
 * 遵循接口文档中定义的统一响应格式规范
 */
@Data
public class Result<T> {
    /**
     * 响应状态码
     */
    private Integer code;
    
    /**
     * 响应消息
     */
    private String message;
    
    /**
     * 响应数据
     */
    private T data;
    
    /**
     * 响应时间戳
     */
    private String timestamp;
    
    /**
     * 默认构造函数
     */
    public Result() {
        this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }
    
    /**
     * 带参数的构造函数
     * @param code 响应状态码
     * @param message 响应消息
     * @param data 响应数据
     */
    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }
    
    /**
     * 成功响应（无数据）
     * @param message 响应消息
     * @return Result<Void>
     */
    public static Result<Void> success(String message) {
        return new Result<>(200, message, null);
    }
    
    /**
     * 成功响应（带数据）
     * @param data 响应数据
     * @param message 响应消息
     * @return Result<T>
     */
    public static <T> Result<T> success(T data, String message) {
        return new Result<>(200, message, data);
    }
    
    /**
     * 成功响应（带数据，默认消息）
     * @param data 响应数据
     * @return Result<T>
     */
    public static <T> Result<T> success(T data) {
        return new Result<>(200, "success", data);
    }
    
    /**
     * 失败响应（默认错误码500）
     * @param message 错误消息
     * @return Result<Void>
     */
    public static Result<Void> error(String message) {
        return new Result<>(500, message, null);
    }
    
    /**
     * 失败响应（指定错误码）
     * @param code 错误码
     * @param message 错误消息
     * @return Result<Void>
     */
    public static Result<Void> error(Integer code, String message) {
        return new Result<>(code, message, null);
    }
    
    /**
     * 失败响应（指定错误码和类型）
     * @param code 错误码
     * @param message 错误消息
     * @param <T> 数据类型
     * @return Result<T>
     */
    public static <T> Result<T> errorWithGeneric(Integer code, String message) {
        return new Result<>(code, message, null);
    }
    
    /**
     * 参数验证失败响应
     * @param data 错误详情
     * @return Result<T>
     */
    public static <T> Result<T> validateFailed(T data) {
        return new Result<>(400, "参数验证失败", data);
    }
    
    /**
     * 未认证响应
     * @return Result<Void>
     */
    public static Result<Void> unauthorized() {
        return new Result<>(401, "未认证", null);
    }
    
    /**
     * 权限不足响应
     * @return Result<Void>
     */
    public static Result<Void> forbidden() {
        return new Result<>(403, "权限不足", null);
    }
    
    /**
     * 请求过于频繁响应
     * @return Result<Void>
     */
    public static Result<Void> tooManyRequests() {
        return new Result<>(429, "请求过于频繁，请稍后再试", null);
    }
}