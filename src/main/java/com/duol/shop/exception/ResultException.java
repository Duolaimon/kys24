package com.duol.shop.exception;

import com.duol.shop.enums.ResultEnum;

/**
 * @author Duolaimon
 *         17-5-2 上午10:53
 */
public class ResultException extends RuntimeException {
    private int code;

    public ResultException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public int getCode() {
        return code;
    }

}
