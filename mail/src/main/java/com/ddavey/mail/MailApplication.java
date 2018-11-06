package com.ddavey.mail;

import javax.mail.Folder;
import javax.mail.MessagingException;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MailApplication {
	private static ConfigurableApplicationContext ctx;

	public static void main(String[] args) {
		ctx = SpringApplication.run(MailApplication.class, args);

	}

	private static void printFolders(Folder folder) {
		System.out.println(folder.getFullName());
		try {
			for (Folder subFolder : folder.list("*")) {
				printFolders(subFolder);
			}
		} catch (MessagingException e) {
			System.out.println("Cannot list folders for: " + folder.getName());
		}
	}

	private static void exit() {
		int exitCode = SpringApplication.exit(ctx, new ExitCodeGenerator() {
			@Override
			public int getExitCode() {
				// no errors
				return 0;
			}
		});
		System.exit(exitCode);
	}
}
