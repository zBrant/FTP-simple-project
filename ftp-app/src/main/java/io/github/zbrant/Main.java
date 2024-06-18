package io.github.zbrant;

import io.github.zbrant.core.FTPClientApp;

public class Main {
  public static void main(String[] args) throws Exception {
    String serverIp = args[0];
    Integer serverPort = Integer.parseInt(args[1]);
    FTPClientApp.start(serverIp, serverPort);

//    EmailSenderImpl emailService = new EmailSenderImpl("raul.cfr112@gmail.com",
//            "trabalhoredeswork@gmail.com",
//            "smtp.gmail.com",
//            "C:\\Users\\Raul\\Documents\\FTP-simple-project\\textTest.txt"
//    );
  }
}