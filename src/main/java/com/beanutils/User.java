package com.beanutils;

import lombok.Data;

import java.util.Date;

/**
 * 模型类
 */
@Data
public class User {

    private String id;
    private String name;
    private boolean state;
    private String others;
    private Date birthday;
}
