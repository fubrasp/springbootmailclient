package com.miage.m2.mailspringboot.aspects;

import com.miage.m2.mailspringboot.loggers.Logger;
import com.miage.m2.mailspringboot.mail.MailClient;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
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

    @Before("execution(* com.miage.m2.mailspringboot.mail.MailClient.send (java.lang.String, java.lang.String)) && args(subject, messageContent) ")
    public void beforeSendMail(String subject, String messageContent) {
        log("A mail has been send: \n "+subject+" \n "+messageContent+"\n");
    }

    @Before("execution(* com.miage.m2.mailspringboot.mail.MailClient.receive ()) && args() ")
    public void beforeReadMails() {
        log("Reading mails... ");
    }

}