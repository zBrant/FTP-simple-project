package io.github.zbrant.core.service;

import org.apache.commons.net.ftp.FTPClient;

public class DirectoryService {

  public void createDirectory(String path, FTPClient ftpClient) throws Exception {
    System.out.println();
    System.out.printf("[createDirectory][%d] Is success to create directory : %s -> %b",
        System.currentTimeMillis(), path, ftpClient.makeDirectory(path));
    System.out.println();
  }

  public void deleteDirectory(String path, FTPClient ftpClient) throws Exception {
    System.out.println();
    System.out.printf("[deleteDirectory][%d] Is success to delete directory : %s -> %b",
        System.currentTimeMillis(), path, ftpClient.removeDirectory(path));
    System.out.println();
  }
}
