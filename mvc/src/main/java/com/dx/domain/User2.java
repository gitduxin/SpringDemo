package com.dx.domain;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
public class User2 extends Base{
    private int a;
    private double b;
    private  String c;
}
