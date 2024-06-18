package io.github.zbrant.core;

import io.github.zbrant.core.authentication.Login;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.util.Scanner;

public class FTPClientApp {

  private final String host;
  private final Integer port;
  private final Scanner scanner = new Scanner(System.in);

  private FTPClientApp(String host, Integer port){
    this.host = host;
    this.port = port;

    FTPClient client = authenticateUser();
    while (client != null && client.isConnected()) {
      System.out.print("ftp-client > ");
      String line = scanner.nextLine();
      executeCommand(line, client);
    }
  }

  private void executeCommand(String line, FTPClient client) {
    System.out.println("executando comando...");
  }

  public static void start(String host, Integer port){
    new FTPClientApp(host, port);
  }

  public FTPClient authenticateUser(){
    System.out.print("Digite o usuario: ");
    String username = scanner.nextLine().trim();
    System.out.print("Digite a senha: ");
    String password = scanner.nextLine().trim();

    FTPClient client;
    try {
      client = Login.loginFTP(host, port, username, password);
      int replyCode = client.getReplyCode();

      if (!FTPReply.isPositiveCompletion(replyCode)) throw new RuntimeException();
      return client;
    } catch (Exception e) {
      System.out.println("\nError: Usuario ou senha incorreto");
    }
    return null;
  }
}
