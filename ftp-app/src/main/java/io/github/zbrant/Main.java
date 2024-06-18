package io.github.zbrant;

import io.github.zbrant.core.FtpClient;
import io.github.zbrant.core.integration.email.EmailSenderImpl;
import org.apache.commons.net.ftp.FTPClient;

public class Main {
  public static void main(String[] args) throws Exception {
    System.out.println("Hello from client!");

    EmailSenderImpl emailService = new EmailSenderImpl("raul.cfr112@gmail.com",
            "trabalhoredeswork@gmail.com",
            "smtp.gmail.com",
            "C:\\Users\\Raul\\Documents\\FTP-simple-project\\textTest.txt"
    );
//    FtpClient service = new FtpClient();
    //FTPClient client = service.loginFtp("172.17.0.2", 21, "ftpuser", "passwd");
    //service.printTree("./", client);
    //client.logout();
  }
}