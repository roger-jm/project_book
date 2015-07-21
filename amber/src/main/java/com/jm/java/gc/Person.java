package com.jm.java.gc;

import java.util.ArrayList;
import java.util.List;

/**
 * This is Project project_book
 * Created by jmwmj
 * On 2015/7/20
 * At 10:21
 */
public class Person {
    String name = "";
    int age = 20;

    public static void main(String[] args) {
        List<Person> list = new ArrayList<Person>();
        while (true){
            list.add(new Person());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
