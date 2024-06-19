package io.github.zbrant;

import io.github.zbrant.core.authentication.Login;
import io.github.zbrant.core.utils.InputHandler;
import org.apache.commons.net.ftp.FTPClient;

import java.util.Scanner;

public class FTPClientApp {

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args){
    InputHandler inputHandler = new InputHandler();
    FTPClient client = Login.authenticateUser(getCredentials());

    while (client != null && client.isConnected()) {
      System.out.print("ftp-client > ");
      String line = scanner.nextLine().trim();
      inputHandler.perform(line.split(" "), client);
      //if (!client.isConnected()) EmailSenderImpl.execute();
    }
  }

  public static String[] getCredentials(){
    System.out.print("Enter FTP server address: ");
    String host = scanner.nextLine().trim();
    System.out.print("User: ");
    String username = scanner.nextLine().trim();
    System.out.print("Password: ");
    String password = scanner.nextLine().trim();
    return  new String[]{host,username,password};
  }
}
