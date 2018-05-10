package com.leogao.common.exception;

/**
 * 自建异常
 * 
 * @author leogao 2018年4月16日 下午5:41:42
 */
public class MyException extends Exception {

    private static final long serialVersionUID = 4652839945060084889L;

    private String            errorCode;

    public MyException(String errorCode, String msg, Throwable cause) {
        super(msg, cause);
        this.errorCode = errorCode;
    }

    public MyException(String errorCode, String msg) {
        super(msg);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

}
