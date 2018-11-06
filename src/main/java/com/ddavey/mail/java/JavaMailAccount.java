package com.ddavey.mail.java;

import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;

import com.ddavey.mail.MailAccount;

import lombok.Data;

@Data

public class JavaMailAccount extends MailAccount {
	private String host;
	private int port;

	private String password;

	private Store store;

	public JavaMailAccount(String host, int port, String username, String password) {
		super(username);
		this.host = host;
		this.port = port;
		this.password = password;
	}

	public void connect() throws MessagingException {
		Session emailSession = Session.getInstance(compileProperties(), new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		// create the POP3 store object and connect with the pop server
		Store store = emailSession.getStore("imap");

		store.connect(host, null, null);
		this.store = store;
	}

	public Folder getRootFolder() throws MessagingException {
		return store.getDefaultFolder();
	}

	public Message[] getMessages(Folder folder, int startIndex, int endIndex) throws MessagingException {
		return folder.getMessages(startIndex, endIndex);
	}

	private Properties compileProperties() {
		Properties properties = new Properties();
		properties.put("mail.imap.port", port);
		properties.put("mail.imap.host", host);

		properties.setProperty("mail.imap.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.setProperty("mail.imap.socketFactory.fallback", "false");

		properties.setProperty("mail.imap.socketFactory.port", String.valueOf(port));

		return properties;
	}

	public void close() throws MessagingException {
		store.close();
	}
}
