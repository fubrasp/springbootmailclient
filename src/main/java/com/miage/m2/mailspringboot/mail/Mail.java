package com.miage.m2.mailspringboot.mail;

import org.springframework.context.annotation.Bean;

public class Mail {

    private String to;
    private String from;
    private String host;

    public Mail(String to, String from, String host) {
        this.to = to;
        this.from = from;
        this.host = host;
    }

    public Mail() {
        // Recipient's email ID needs to be mentioned.
        this.to="guillaume5524@gmail.com";

        // Sender's email ID needs to be mentioned
        this.from = "guillaume5524@gmail.com";

        // Assuming you are sending email through relay.jangosmtp.net
        this.host = "smtp.mailtrap.io";
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "to='" + to + '\'' +
                ", from='" + from + '\'' +
                ", host='" + host + '\'' +
                '}';
    }
}
