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

    public User2(int p1, String p2, Date p3, List<String> p4, Map<String, String> p5) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        this.p5 = p5;
    }
}
