package com.wyett.send;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import java.util.Properties;

/**
 * @author : wyettLei
 * @date : Created in 2021/12/13 14:17
 * @description: TODO
 */

public class EmailUtil {

    private static final String MAIL_FROM = "wyett@wyett.com";
    private static final String HOST = "localhost";
    private static final String PASSWD = "xxxxxxx";

    /**
     * send simple mail
     * @param subject
     * @param content
     * @param to
     */
    public void sendSmipleEmail(String subject, String content, String... to) {

        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setHost(HOST);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(MAIL_FROM);
        message.setSubject(subject);
        message.setTo(to);
        message.setText(content);

        sender.setUsername(MAIL_FROM);
        sender.setPassword(PASSWD);

        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.timeout", 25000);
        sender.setJavaMailProperties(prop);

        sender.send(message);
    }

    /**
     * send html mail
     * @param subject
     * @param content
     * @param to
     * @throws MessagingException
     */
    public void sendHtmlEmail(String subject, String content, String... to) throws MessagingException {
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setHost(HOST);

        javax.mail.internet.MimeMessage mimeMessage = sender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "GBK");

        messageHelper.setFrom(MAIL_FROM);
        messageHelper.setSubject(subject);
        messageHelper.setTo(to);
        messageHelper.setText(content, true);

        sender.setUsername(MAIL_FROM);
        sender.setPassword(PASSWD);

        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.timeout", 25000);
        sender.setJavaMailProperties(prop);

        sender.send(mimeMessage);
    }
}
