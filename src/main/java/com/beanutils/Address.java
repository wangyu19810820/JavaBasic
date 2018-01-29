package com.beanutils;

import lombok.Data;

/**
 * 模型类
 */
@Data
public class Address {
    private String city;

    public Address(){}

    public Address(String city) {
        this.city = city;
    }
}
