package io.github.zbrant.core.integration.email;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailSenderImpl {
    private final String to = "raul.cfr112@gmail.com";
    private final String from = "trabalhoredeswork@gmail.com";
    private final String host = "smtp.gmail.com";
    private final String contentOnFTPServer;
    private Properties properties;
    private Session session;

    private EmailSenderImpl(String content) {
        this.contentOnFTPServer = content;
        initializeProperties();
        createSession();
        sendEmail();
    }

    public static void execute(String content){
        new EmailSenderImpl(content);
    }

    private void initializeProperties() {
        properties = System.getProperties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtps.auth", "true");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.host", host);
    }

    private void createSession() {
        session = Session.getDefaultInstance(properties, null);
    }

    private void sendEmail() {
        try {
            MimeMessage message = createMessage();
            System.out.println("Sending email, wait....");
            Transport transport = session.getTransport();
            transport.connect(host, 587, from, "telobnvdwczjyrfb"); // You should secure your password
            transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            transport.close();
            System.out.println("Email sent successfully....");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private MimeMessage createMessage() throws MessagingException {
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject("FTP server files and directories");
        message.setText(contentOnFTPServer);
        return message;
    }
}
