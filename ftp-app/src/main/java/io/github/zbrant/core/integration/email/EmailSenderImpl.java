package io.github.zbrant.core.integration.email;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class EmailSenderImpl {
    private final String to = "raul.cfr112@gmail.com";
    private final String from = "trabalhoredeswork@gmail.com";
    private final String host = "smtp.gmail.com";
    private final String fileName = "C:\\Users\\Raul\\Documents\\FTP-simple-project\\textTest.txt";
    private Properties properties;
    private Session session;

    private EmailSenderImpl() {
        initializeProperties();
        createSession();
    }

    public static void execute(){
        new EmailSenderImpl();
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

    public void sendEmail() {
        try {
            MimeMessage message = createMessage();
            addContentToMessage(message);
            System.out.println("Sending message, wait....");
            sendMessage(message);
            System.out.println("message sent successfully....");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private MimeMessage createMessage() throws MessagingException {
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject("Ping");
        return message;
    }

    private void addContentToMessage(MimeMessage message) throws MessagingException {
        message.setText("Hello, this is example of sending email  ");
        Multipart multipart = new MimeMultipart();

        // Text part
        BodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setText("Here's the file");
        multipart.addBodyPart(messageBodyPart);

        // File part
        messageBodyPart = new MimeBodyPart();
        DataSource source = new FileDataSource(fileName);
        messageBodyPart.setDataHandler(new DataHandler(source));
        messageBodyPart.setFileName(fileName);
        multipart.addBodyPart(messageBodyPart);

        message.setContent(multipart);
    }

    private void sendMessage(MimeMessage message) throws MessagingException {
        Transport transport = session.getTransport();
        transport.connect(host, 587, from, "telobnvdwczjyrfb"); // You should secure your password
        transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
        transport.close();
    }

}
