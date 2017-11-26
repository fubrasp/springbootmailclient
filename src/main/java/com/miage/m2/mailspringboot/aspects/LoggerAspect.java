package com.miage.m2.mailspringboot.aspects;

import com.miage.m2.mailspringboot.loggers.Logger;

public class LoggerAspect {
    public static void log(String message) {
        try {
            Class loggerF = Class.forName("com.miage.m2.mailspringboot.loggers.FileLogger");
            Class loggerC = Class.forName("com.miage.m2.mailspringboot.loggers.ConsoleLogger");
            Logger loggerCC = (Logger) loggerC.newInstance();
            Logger loggerFF = (Logger) loggerF.newInstance();
            loggerCC.log(message);
            loggerFF.log(message);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    public void beforeSendMail() {
        log("A mail has been send: ");
    }

    public void beforeReadMails() {
        log("Reading mails... ");
    }
}