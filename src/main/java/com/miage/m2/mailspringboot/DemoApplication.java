package com.miage.m2.mailspringboot;

import com.miage.m2.mailspringboot.mail.MailClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.miage.m2.mailspringboot.loggers.Logger;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private MailClient mailClient;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {

		mailClient.send("Test subject", "Awesome client");
		mailClient.receive();
	}

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
}
