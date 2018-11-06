package com.ddavey.mail.java;

import com.ddavey.mail.EmailAccount;
import com.ddavey.mail.MailConnector;

import lombok.Data;

@Data
public class JavaMail extends EmailAccount {
	private String host;
	private int port;
	private String password;

	public enum ConnectionType {
		IMAP
	};

	private ConnectionType connectionType = ConnectionType.IMAP;

	public JavaMail(String emailAddress, String password, String host, int port) {
		super(emailAddress);
		this.emailAddress = emailAddress;
		this.password = password;
		this.host = host;
		this.port = port;
	}

	public JavaMail() {
		super();
	}

	@Override
	public MailConnector getMailConnector() {
		return new JavaMailConnector(this);
	}
}
