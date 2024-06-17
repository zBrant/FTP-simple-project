package io.github.zbrant;

import io.github.zbrant.core.FtpClient;
import org.apache.commons.net.ftp.FTPClient;

public class Main {
  public static void main(String[] args) throws Exception {
    System.out.println("Hello from client!");

    FtpClient service = new FtpClient();
    //FTPClient client = service.loginFtp("172.17.0.2", 21, "ftpuser", "passwd");
    //service.printTree("./", client);
    //client.logout();
  }
}