package io.github.zbrant.core;

import io.github.zbrant.core.authentication.Login;
import io.github.zbrant.core.utils.InputHandler;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.util.Scanner;

public class FTPClientApp {

  private final String host;
  private final Integer port;
  private final Scanner scanner;

  private FTPClientApp(String host, Integer port){
    this.host = host;
    this.port = port;
    this.scanner = new Scanner(System.in);

    InputHandler inputHandler = new InputHandler();
    FTPClient client = authenticateUser();

    while (client != null && client.isConnected()) {
      System.out.print("ftp-client > ");
      String line = scanner.nextLine().trim();
      inputHandler.perform(line.split(" "), client);
    }
  }

  public static void start(String host, Integer port){
    new FTPClientApp(host, port);
  }

  public FTPClient authenticateUser(){
    System.out.print("User: ");
    String username = scanner.nextLine().trim();
    System.out.print("Password: ");
    String password = scanner.nextLine().trim();

    FTPClient client;
    try {
      client = Login.execute(host, port, username, password);
      int replyCode = client.getReplyCode();

      if (!FTPReply.isPositiveCompletion(replyCode)) throw new RuntimeException();
      return client;
    } catch (Exception e) {
      System.out.println("\n[ERROR] cause: username or password incorrect");
    }
    return null;
  }
}
