package com.duol.shop.service;

import com.duol.shop.dto.BackStageResult;
import com.duol.shop.enums.ResultEnum;
import com.duol.shop.exception.ResultException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public BackStageResult<Throwable> handle(Exception e) {
        if (e instanceof MultipartException) {
            logger.error("MultipartException:{}", e.getMessage());
            return new BackStageResult<>(ResultEnum.FILE_TOO_LARGE, null);
        }
        if (e instanceof ResultException) {
            logger.error("ResultException:{}", e.getMessage());
            return new BackStageResult<>((ResultException) e, null);
        }
        logger.error("------Exception------");
        e.printStackTrace();
        return new BackStageResult<>(ResultEnum.OTHERS_EXCEPTION, e.getCause());

    }
}
