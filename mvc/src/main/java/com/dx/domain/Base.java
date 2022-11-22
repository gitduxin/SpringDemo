package com.dx.domain;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

@Data
public class Base {

    @JSONField(format = "yyyy-MM-dd")
    private Date creatTime;

    @JSONField(format = "yyyy-MM-dd")
    private Date updateTime;
}
