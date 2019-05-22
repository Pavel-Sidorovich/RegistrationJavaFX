package com.pavesid.helper;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import java.util.Date;
import java.util.Properties;

public class sendEmail {

    public static void sendHtmlEmail(String server, String from, String to, String cc, String subject, String htmlBody) throws MessagingException {
        Properties props = new Properties();
        props.setProperty("mail.smtp.host", server);
        Session session = Session.getInstance(props);

        MimeMessage msg = new MimeMessage(session);
        msg.setFrom(from);
        msg.setRecipients(Message.RecipientType.TO, to);
        msg.setRecipients(Message.RecipientType.CC, cc);
        msg.setSubject(subject);
        msg.setSentDate(new Date());

        MimeMultipart mp = new MimeMultipart();
        MimeBodyPart part = new MimeBodyPart();
        part.setText(htmlBody);
        mp.addBodyPart(part);
        msg.setContent(mp);

        // Content type has to be set after the message is put together
        // Then saveChanges() must be called for it to take effect
        part.setHeader("Content-Type", "text/html");
        msg.saveChanges();

        Transport.send(msg);
    }

}
