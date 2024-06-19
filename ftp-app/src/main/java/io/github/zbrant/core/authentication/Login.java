package io.github.zbrant.core.authentication;

import org.apache.commons.net.ftp.FTPClient;

public class Login {

  public static FTPClient execute(String host, Integer port, String username, String password) throws Exception {
    FTPClient ftpClient = new FTPClient();
    ftpClient.connect(host, port);
    ftpClient.login(username, password);
    return ftpClient;
  }
}
