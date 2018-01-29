package com.beanutils;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class CustomConverterDemo {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        ConvertUtils.register(new StringConvert(), String.class);
        Map<String, Object> map = new HashMap<>();
        map.put("name", "001");
        map.put("id", "100");
        map.put("state", false);
        map.put("others", "others");

        User u = new User();
        BeanUtils.populate(u, map);
        System.out.println(u);
    }
}

class StringConvert implements Converter {
    @Override
    public <T> T convert(Class<T> type, Object value) {
        if (String.class.isInstance(value)) {
            return (T) ("###" + value);
        } else {
            return (T) value;
        }
    }
}
