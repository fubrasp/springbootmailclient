package com.miage.m2.mailspringboot.loggers;

public class ConsoleLogger implements Logger {
    public ConsoleLogger() {
    }

    public void log(Object object) {
        System.out.println(object.toString());
    }
}
