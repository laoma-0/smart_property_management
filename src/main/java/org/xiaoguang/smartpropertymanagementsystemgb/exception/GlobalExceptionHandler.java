package org.xiaoguang.smartpropertymanagementsystemgb.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.xiaoguang.smartpropertymanagementsystemgb.entity.Result;
import java.util.Objects;

/**
 * 全局异常处理器
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理参数校验异常
     * @param e MethodArgumentNotValidException
     * @return Result
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<String> handleValidationException(MethodArgumentNotValidException e) {
        // 获取第一个校验错误信息
        String errorMessage = Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage();
        return Result.validateFailed(errorMessage);
    }
    
    /**
     * 处理其他异常
     * @param e Exception
     * @return Result
     */
    @ExceptionHandler(Exception.class)
    public Result<Void> handleException(Exception e) {
        return Result.error(e.getMessage());
    }
}