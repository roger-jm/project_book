package com.jm.java.generics.connection;

/**
 * This is Project project_book
 * Created by jmwmj
 * On 2015/7/29
 * At 11:26
 */
public class Product {
    int num = 1;
    String name = "Product 1";

    public Product(int num,String name){
        this.name = name;
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "name: " + name + " && number: " + num;
    }
}
