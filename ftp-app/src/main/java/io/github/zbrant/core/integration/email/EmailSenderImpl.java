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

    public EmailSenderImpl(String to, String from, String host, String fileName) {
        /*
            exemplo de uso do emailSender:
                EmailSenderImpl emailService = new EmailSenderImpl("raul.cfr112@gmail.com",
                        "trabalhoredeswork@gmail.com",
                        "smtp.gmail.com",
                        "C:\\Users\\Raul\\Documents\\FTP-simple-project\\textTest.txt"
                );
         */

        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtps.auth", "true");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.host", host);
        Session session = Session.getDefaultInstance(properties, null);


        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Ping");
            message.setText("Hello, this is example of sending email  ");
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("Here's the file");
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            messageBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(fileName);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(fileName);
            multipart.addBodyPart(messageBodyPart);
            message.setContent(multipart);

            Transport transport = session.getTransport();
            transport.connect(host, 587, from, "telobnvdwczjyrfb ");
            transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            transport.close();
            System.out.println("message sent successfully....");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
