package com.thenoiseteam.filedemo.payload;

public class Data {

    private int id;
    private String name, value;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "[id=" + id + ", name=" + name + ", value=" + value + "]";
    }

}
