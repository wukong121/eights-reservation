package com.bupt.eights.dto.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class HttpResponse<T> implements Serializable {
    
    private String status;  // success,failed
    
    private int code; // 0 success;-1 failed
    
    private String message;
    
    public T data;
    
}