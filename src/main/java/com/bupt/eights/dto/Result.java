package com.bupt.eights.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private boolean success;
    private String errormsg;
    private Object data;
    public static Result ok(){
        return new Result(true,null,null);
    }
    public static Result ok(Object data){
        return new Result(true,null,data);
    }
    public static Result fail(String errormsg){
        return new Result(false,errormsg,null);
    }
}
