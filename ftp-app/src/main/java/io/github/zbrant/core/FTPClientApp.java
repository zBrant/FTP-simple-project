package io.github.zbrant.core;

import io.github.zbrant.core.authentication.Login;
import org.apache.commons.net.ftp.FTPClient;

public class FTPClientApp {

  public static void start(String host, Integer port){
    try {
      FTPClient client = Login.loginFTP(host, port, "ftpuser", "passwd");
    } catch (Exception e) {
      System.out.println("error: " + e.getMessage());;
    }
  }
}
