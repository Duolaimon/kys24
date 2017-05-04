package com.duol.shop.service;

import com.duol.shop.dto.BackStageResult;
import com.duol.shop.enums.ResultEnum;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartException;

/**
 * @author Duolaimon
 *         17-5-4 下午10:45
 */
@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public BackStageResult<String> handle(Exception e) {
        if (e instanceof MultipartException) {
            return new BackStageResult<>(ResultEnum.FILE_TOO_LARGE, null);
        } else return new BackStageResult<String>(ResultEnum.SUCCESS, null);
    }
}
