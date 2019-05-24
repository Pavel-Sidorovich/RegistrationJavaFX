package com.pavesid.mail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class SendEmail {

    public static void send(String name, String pass) {
        String to = name;

        // Sender's email ID needs to be mentioned
        String from = "";
        final String username = "";//change accordingly
        final String password = "";//change accordingly

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            // Create a default MimeMessage object.
            Message message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));

            // Set Subject: header field
            message.setSubject("Testing Subject");

            // This mail has 2 part, the BODY and the embedded image
            MimeMultipart multipart = new MimeMultipart("related");

            // first part (the html)
            BodyPart messageBodyPart = new MimeBodyPart();

            BufferedReader br = null;
            FileReader fr = null;

            //br = new BufferedReader(new FileReader(FILENAME));
            fr = new FileReader("src/com/pavesid/mail/images/mail.html");
            br = new BufferedReader(fr);

            String sCurrentLine;
            String htmlText = "";

            while ((sCurrentLine = br.readLine()) != null) {
                htmlText += sCurrentLine;
            }

            htmlText = htmlText.replaceAll("\\*UserName\\*", name);
            htmlText = htmlText.replaceAll("\\*DeffPass\\*", pass);
            messageBodyPart.setContent(htmlText, "text/html");
            // add it

            multipart.addBodyPart(messageBodyPart);

            Map<String, String> inlineImages = new HashMap<>();
            inlineImages.put("facebook", "src/com/pavesid/mail/images/facebook@2x.png");
            inlineImages.put("pavesid", "src/com/pavesid/mail/images/pavesid@2x.png");
            inlineImages.put("instagram", "src/com/pavesid/mail/images/instagram@2x.png");
            inlineImages.put("pinterest", "src/com/pavesid/mail/images/pinterest@2x.png");
            inlineImages.put("twitter", "src/com/pavesid/mail/images/twitter@2x.png");

            // creates multi-part
            //Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            // adds inline image attachments
            if (inlineImages != null && inlineImages.size() > 0) {
                Set<String> setImageID = inlineImages.keySet();

                for (String contentId : setImageID) {
                    MimeBodyPart imagePart = new MimeBodyPart();
                    imagePart.setHeader("Content-ID", "<" + contentId + ">");
                    imagePart.setDisposition(MimeBodyPart.INLINE);

                    String imageFilePath = inlineImages.get(contentId);
                    try {
                        imagePart.attachFile(imageFilePath);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                    multipart.addBodyPart(imagePart);
                }
            }

            // put everything together
            message.setContent(multipart);
            Transport.send(message);

        } catch (MessagingException e) {
            System.out.println("MessagingException");
        } catch (IOException e ) {
            System.out.println("IOException");
        }

    }
}