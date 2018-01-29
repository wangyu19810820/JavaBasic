package com.beanutils;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.converters.AbstractConverter;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * BeanUtils学习demo
 * 将map转换成javabean，在javabean中复制属性，将javabean转成map
 */
public class BeanUtilsDemo {

    public static void main(String[] args)
            throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "001");
        map.put("id", "100");
        map.put("state", false);
        map.put("others", "others");

        ConvertUtils.register(new MyStringToDateConvert(), Date.class);
        map.put("birthday", "2017-11-05");

        // 将map转换成javabean
        User u1 = new User();
        BeanUtils.populate(u1, map);
        System.out.println(u1);

        // 在javabean中复制属性
        User u2 = new User();
        BeanUtils.copyProperties(u2, u1);
        System.out.println(u2);

        // 将javabean转成map
        u2.setBirthday(new Date());
        ConvertUtils.register(new MyDateToStringConvert(), String.class);
        Map<String, String> describe = BeanUtils.describe(u2);
        for (String prop : describe.keySet()) {
            System.out.println(prop + ":" + describe.get(prop));
        }
    }
}

/**
 * String转成Date的转换器
 */
class MyStringToDateConvert implements Converter {
    @Override
    public <T> T convert(Class<T> type, Object value) {
        if (String.class.isInstance(value)) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            try {
                return (T) (df.parse((String) value));
            } catch (ParseException e) {
                return null;
            }
        } else {
            return (T) value;
        }
    }
}

/**
 * Date转成String的转换器
 */
class MyDateToStringConvert implements Converter {
    @Override
    public <T> T convert(Class<T> type, Object value) {
        if (Date.class.isInstance(value)) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            return (T) (df.format((Date) value));
        } else {
            return (T) String.valueOf(value);
        }
    }
}
