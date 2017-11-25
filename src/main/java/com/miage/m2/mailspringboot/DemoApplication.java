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

		SampleServiceAspect sampleServiceAspect = new SampleServiceAspect();
		sampleServiceAspect.beforeSampleCreation("TestObject");

		SampleService sampleService = new SampleService();
		Sample sample = sampleService.createSample("TestObject");
		System.out.println(sample.toString());

		//sampleServiceAspect.aroundSampleCreation("TestObject");
	}
}
