package com.sunpeihua.login.common;

import java.io.Serializable;

/**
 * @author: sunpeihua
 * @create: 2019/3/28 23:59
 **/
public class BaseMessageVO implements Serializable {
    private static final long serialVersionUID = -1837372409967842342L;
    private boolean success;
    private int code;
    private String message;

    public BaseMessageVO() {
        this.success = true;
    }

    public BaseMessageVO(int code, String message) {
        this.success = false;
        this.code = code;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
