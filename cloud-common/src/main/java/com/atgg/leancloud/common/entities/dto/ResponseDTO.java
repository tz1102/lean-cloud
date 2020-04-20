package com.atgg.leancloud.common.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO<T> {

    private Integer code;

    private String msg;

    private T data;

    public ResponseDTO(Integer code, String msg){
        this(code,msg,null);
    }


}
