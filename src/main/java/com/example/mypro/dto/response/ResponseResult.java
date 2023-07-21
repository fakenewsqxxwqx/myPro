package com.example.mypro.dto.response;

import lombok.Data;

@Data
public class ResponseResult<T> {
    private int code;
    private String msg;
    private T data;

    public ResponseResult() {
    }

    public ResponseResult(String msg, T data) {
        this.code = 200;
        this.msg = msg;
        this.data = data;
    }

    public ResponseResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
