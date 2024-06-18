package io.github.zbrant.core.service;

import io.github.zbrant.core.utils.FormatterUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import java.io.File;

public class DirectoryService {

  public void createDirectory(String[] input, FTPClient ftpClient) throws Exception {
    String path = input[0];
    System.out.println();
    System.out.printf("[createDirectory][%d] Is success to create directory : %s -> %b",
        System.currentTimeMillis(), path, ftpClient.makeDirectory(path));
    System.out.println();
  }

  public void deleteDirectory(String[] input, FTPClient ftpClient) throws Exception {
    String path = input[0];
    System.out.println();
    System.out.printf("[deleteDirectory][%d] Is success to delete directory : %s -> %b",
        System.currentTimeMillis(), path, ftpClient.removeDirectory(path));
    System.out.println();
  }

  public void printDirectories(String[] input, FTPClient ftpClient) throws Exception {
    String path = input[0];
    for (FTPFile ftpFile : ftpClient.listFiles(path)) {
      if (ftpFile.isDirectory()) {
        FormatterUtils.print(ftpFile);
        printDirectories(new String[]{path + File.separator + ftpFile.getName()}, ftpClient);
      }
    }
  }

}
