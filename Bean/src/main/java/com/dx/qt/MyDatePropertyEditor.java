package com.dx.qt;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 类型转换器
 */
public class MyDatePropertyEditor extends PropertyEditorSupport {

    private final String dateStr;

    public MyDatePropertyEditor(String dateStr) {
        this.dateStr = dateStr;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        SimpleDateFormat sdf = new SimpleDateFormat(dateStr);
        try {
            Date date = sdf.parse(text);
            setValue(date);
            System.out.println("调用了自定义的类型转换器");
        } catch (ParseException e) {
            System.out.println("日期格式不对");
            e.printStackTrace();
        }
    }
}
