package io.github.zbrant.core.integration.email;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.OutputStream;
import java.util.Properties;

public class EmailSenderImpl {

  /*
    TODO:
     - enviar anexo junto do email
   */

  public EmailSenderImpl(String to, String from, String host, OutputStream file) {
    Properties properties = System.getProperties();
    properties.setProperty("mail.smtp.host", host);
    Session session = Session.getDefaultInstance(properties);


    try {
      MimeMessage message = new MimeMessage(session);
      message.setFrom(new InternetAddress(from));
      message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
      message.setSubject("Ping");
      message.setText("Hello, this is example of sending email  ");

      Transport.send(message);
      System.out.println("message sent successfully....");
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}
