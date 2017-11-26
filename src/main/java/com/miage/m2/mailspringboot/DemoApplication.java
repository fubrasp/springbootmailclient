package com.miage.m2.mailspringboot;

import com.miage.m2.mailspringboot.mail.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:beans.xml")
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private MailService mailClient;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		mailClient.send("Test subject", "Awesome client");
		mailClient.receive();
	}
}
