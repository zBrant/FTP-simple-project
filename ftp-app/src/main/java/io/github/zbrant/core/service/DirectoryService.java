package io.github.zbrant.core.service;

import io.github.zbrant.core.utils.FormatterUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import java.io.File;

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

  public void printDirectories(String path, FTPClient ftpClient) throws Exception {
    for (FTPFile ftpFile : ftpClient.listFiles(path)) {
      if (ftpFile.isDirectory()) {
        FormatterUtils.print(ftpFile);
        printDirectories(path + File.separator + ftpFile.getName(), ftpClient);
      }
    }
  }

}
