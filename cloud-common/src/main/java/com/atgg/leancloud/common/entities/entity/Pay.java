package com.atgg.leancloud.common.entities.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pay implements Serializable {

    private Long id;

    private String serial;

}
