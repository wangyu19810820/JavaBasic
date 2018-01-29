package com.beanutils;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 模型类
 */
@Data
public class Employee {

    private String firstName;
    private String lastName;
    private Employee[] subordinate = new Employee[100];
    private Map<String, Employee> employeeMap = new HashMap<>();
    private Map<String, Address> addressMap = new HashMap<>();

    public Employee() {
    }

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Address getAddress(String type) {
        return addressMap.get(type);
    }

    public void setAddress(String type, Address address) {
        addressMap.put(type, address);
    }

//    public Employee getSubordinate(int index) {
//        return subordinate[index];
//    }
//
//    public void setSubordinate(int index, Employee employee) {
//        subordinate[index] = employee;
//    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
