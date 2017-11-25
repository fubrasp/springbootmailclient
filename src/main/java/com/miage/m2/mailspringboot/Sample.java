package com.miage.m2.mailspringboot;
/**
 * Created by gkatzioura on 5/28/16.
 */
public class Sample {
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Sample{" +
                "name='" + name + '\'' +
                '}';
    }
}