package com.miage.m2.mailspringboot.mail;

public interface MailService {

    boolean send(String subject, String messageContent);
    Object receive();
}
