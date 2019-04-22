package com.liuzhe.shop.util;

public class MyException extends Exception {

    /**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */
    private static final long serialVersionUID = 1L;

    private String message;


    public MyException(final String message) {
        super();
        this.message = message;
    }

    public MyException() {
        super();
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }


}
