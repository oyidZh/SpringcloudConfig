package com.activiti.pojo.exceptionDto;

import java.io.Serializable;

/**
 * 异常信息返回
 * Created by liulinhui on 2017/8/5.
 */
public class ApiErrorResponse implements Serializable {
    private static final long serialVersionUID = 2120869894112984147L;
    private String errorMessage;  //错误信息
    private int resCode;    //返回码
    private int errorCode;   //错误码

    public ApiErrorResponse(int resCode, int errorCode, String errorMessage) {
        this.errorMessage = errorMessage;
        this.resCode = resCode;
        this.errorCode = errorCode;
    }

    public ApiErrorResponse() {

    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getResCode() {
        return resCode;
    }

    public void setResCode(int resCode) {
        this.resCode = resCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
