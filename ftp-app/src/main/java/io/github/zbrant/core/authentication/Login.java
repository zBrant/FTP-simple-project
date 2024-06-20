package io.github.zbrant.core.authentication;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class Login {

  private static FTPClient execute(String host, Integer port, String username, String password) throws Exception {
    FTPClient ftpClient = new FTPClient();
    ftpClient.setConnectTimeout(2000);
    ftpClient.connect(host, port);
    ftpClient.login(username, password);
    return ftpClient;
  }

  public static FTPClient authenticateUser(String[] credentials){
    try {
      String host = credentials[0];
      String username = credentials[1];
      String password = credentials[2];
      Integer port = 21;

      FTPClient client;
      client = execute(host, port, username, password);
      int replyCode = client.getReplyCode();

      if (!FTPReply.isPositiveCompletion(replyCode)) throw new RuntimeException();
      System.out.printf("[LOG] Connected to %s successfully. \n", host);
      return client;
    } catch (Exception e) {
      System.out.println("\n[ERROR] " + e.getMessage());
    }
    return null;
  }
}
