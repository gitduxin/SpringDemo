package com.dx.domain;

import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 测试spring bean属性注入
 */
@Data
public class User2 {
    private int p1;
    private String p2;
    private Date p3;
    private List<String> p4;
    private Map<String,String> p5;
}
