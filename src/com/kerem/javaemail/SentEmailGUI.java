package com.kerem.javaemail;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.mail.Authenticator;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window.Type;
import javax.swing.JTextArea;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.Properties;
import java.awt.event.ActionEvent;
public class SentEmailGUI extends JFrame {

	private JPanel contentPane;
	private JTextField repository;
	private JTextField sender;
	private String senderEmail;
	private String passwordEmail;
	private JTextField senderEmailPassword;
	private JTextField subject;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SentEmailGUI frame = new SentEmailGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SentEmailGUI() {
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 362, 516);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		repository = new JTextField();
		repository.setFont(new Font("Tahoma", Font.BOLD, 16));
		repository.setBounds(10, 17, 329, 28);
		contentPane.add(repository);
		repository.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Repository Email");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setBounds(10, 0, 148, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblSenderEmail = new JLabel("Sender Email");
		lblSenderEmail.setForeground(Color.RED);
		lblSenderEmail.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSenderEmail.setBounds(10, 50, 148, 16);
		contentPane.add(lblSenderEmail);
		
		sender = new JTextField();
		sender.setFont(new Font("Tahoma", Font.BOLD, 16));
		sender.setColumns(10);
		sender.setBounds(10, 67, 329, 28);
		contentPane.add(sender);
		
		JTextArea message = new JTextArea();
		message.setFont(new Font("Mongolian Baiti", Font.BOLD, 16));
		message.setBounds(10, 218, 329, 237);
		contentPane.add(message);
		
		JLabel lblMessage = new JLabel("Message");
		lblMessage.setForeground(Color.RED);
		lblMessage.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMessage.setBounds(10, 202, 148, 16);
		contentPane.add(lblMessage);
		
		JButton send = new JButton("Send");
		
		send.setBackground(new Color(0, 0, 0));
		send.setForeground(new Color(255, 255, 0));
		send.setFont(new Font("Tahoma", Font.BOLD, 16));
		send.setBounds(250, 454, 89, 22);
		contentPane.add(send);
		
		JLabel lblSenderEmailPassword = new JLabel("Sender Email Password");
		lblSenderEmailPassword.setForeground(Color.RED);
		lblSenderEmailPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSenderEmailPassword.setBounds(10, 108, 190, 16);
		contentPane.add(lblSenderEmailPassword);
		
		senderEmailPassword = new JTextField();
		senderEmailPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		senderEmailPassword.setColumns(10);
		senderEmailPassword.setBounds(10, 124, 329, 28);
		contentPane.add(senderEmailPassword);
		
		subject = new JTextField();
		subject.setFont(new Font("Tahoma", Font.BOLD, 16));
		subject.setColumns(10);
		subject.setBounds(10, 173, 329, 28);
		contentPane.add(subject);
		
		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setForeground(Color.RED);
		lblSubject.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSubject.setBounds(10, 156, 190, 16);
		contentPane.add(lblSubject);
		
		send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				senderEmail = sender.getText().toString();
				passwordEmail = senderEmailPassword.getText().toString();
				Properties p = new Properties();
				p.put("mail.smtp.auth", "true");
				p.put("mail.smtp.starttls.enable", "true");
				p.put("mail.smtp.host","smtp.gmail.com");
				p.put("mail.smtp.port", "587");
				Session s = Session.getInstance(p,new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(senderEmail,passwordEmail);
					}});
					try {
						Message m = new MimeMessage(s);
						m.setFrom(new InternetAddress(senderEmail));
						m.setRecipients(Message.RecipientType.TO,InternetAddress.parse(repository.getText().toString()));
						m.setSubject(subject.getText().toString());
						m.setText(message.getText().toString());
						Transport.send(m);
					}catch(Exception e1) {
						e1.printStackTrace();
					}
				}});
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
