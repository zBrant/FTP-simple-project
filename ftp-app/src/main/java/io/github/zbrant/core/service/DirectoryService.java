package io.github.zbrant.core.service;

import io.github.zbrant.core.utils.FormatterUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class DirectoryService {

  public void createDirectory(String[] input, FTPClient ftpClient) throws Exception {
    String path = input[0];
    FormatterUtils.printLogDirectory("created", ftpClient.makeDirectory(path), path);
  }

  public void deleteDirectory(String[] input, FTPClient ftpClient) throws Exception {
    String path = input[0];
    FormatterUtils.printLogDirectory("deleted", ftpClient.removeDirectory(path), path);
  }

  public void changeDirectory(String[] input, FTPClient ftpClient) throws Exception {
    String path = input[0];
    FormatterUtils.printLogDirectory("changed", ftpClient.changeWorkingDirectory(path), path);
  }

  public void printDirectories(String[] input, FTPClient ftpClient) throws Exception {
    String path = (input == null) ? "." : input[0];
    for (FTPFile ftpFile : ftpClient.listFiles(path)) {
      if (ftpFile.isDirectory()) FormatterUtils.print(ftpFile);
    }
  }

}
