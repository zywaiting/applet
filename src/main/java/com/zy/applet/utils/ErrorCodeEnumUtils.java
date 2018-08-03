package com.zy.applet.utils;

/**
 * @author Han.Sun
 * @since 2017年07月28日
 */
public enum ErrorCodeEnumUtils {
    TOKEN_VALID(50008, "非法的token"),
    TOKEN_MULTI_LOGIN(50012, "其他客户端登录了"),

    TOKEN_EXPIRED(50014, "Token 过期了"),


    /**微信小程序从错误码*/
    SESSION_OVERDUE(40008,"用户身份已过期"),
    SESSION_VERIFY(40009,"用户检验失败"),
    SESSION_NOT_EXIST(40010,"SESSION不存在"),
    OPENID_NOT_EXIST(40011,"OPENID不存在"),
    USER_NOT_BIND(40012,"尚未绑定手机号"),

    ;


    private int code;
    private String message;

    ErrorCodeEnumUtils(int code, String message) {
        this.code = code;
        this.message = message;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
