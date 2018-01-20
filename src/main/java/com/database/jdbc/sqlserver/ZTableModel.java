package com.database.jdbc.sqlserver;

/**
 * 数据模型，对于数据库内的表结构
 */
public class ZTableModel {

    private int id;
    private String name;

    public ZTableModel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ZTableModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
