package com.bupt.eights.response;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Data
public class HttpResponse<T> implements Serializable {
    private String status;  //success,failed
    private int code; // 0 success;-1 failed
    private String message;
    private T data;

}