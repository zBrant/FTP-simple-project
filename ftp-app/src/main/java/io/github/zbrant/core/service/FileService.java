package io.github.zbrant.core.service;

import io.github.zbrant.core.utils.FormatterUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class FileService {

  public void uploadFile(String[] input, FTPClient ftpClient) throws Exception {
    String localPath = input[0];
    String remotePath = input[1];
    FileInputStream fileInputStream = new FileInputStream(localPath);
    System.out.println();
    System.out.printf("[uploadFile][%d] Is success to upload file : %s -> %b",
        System.currentTimeMillis(), remotePath, ftpClient.storeFile(remotePath, fileInputStream));
    System.out.println();
  }

  public void renameFile(String[] input, FTPClient ftpClient) throws Exception {
    String oldPath = input[0];
    String newPath = input[1];
    System.out.println();
    System.out.printf("[renameFile][%d] Is success to rename file : from %s to %s -> %b",
        System.currentTimeMillis(), oldPath, newPath, ftpClient.rename(oldPath, newPath));
    System.out.println();
  }

  public byte[] downloadFile(String[] input, FTPClient ftpClient) throws Exception {
    String path = input[0];
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    System.out.println();
    System.out.printf("[downloadFile][%d] Is success to download file : %s -> %b",
        System.currentTimeMillis(), path, ftpClient.retrieveFile(path, byteArrayOutputStream));
    System.out.println();
    return byteArrayOutputStream.toByteArray();
  }

  public void deleteFile(String[] input, FTPClient ftpClient) throws Exception {
    String path = input[0];
    System.out.println();
    System.out.printf("[deleteFile][%d] Is success to delete file : %s -> %b",
        System.currentTimeMillis(), path, ftpClient.deleteFile(path));
    System.out.println();
  }

  public void printFiles(String[] input, FTPClient ftpClient) throws Exception {
    String path = input[0];
    for (FTPFile ftpFile : ftpClient.listFiles(path)) {
      if (ftpFile.isDirectory()) {
        printFiles(new String[]{path + File.separator + ftpFile.getName()}, ftpClient);
      }else{
        FormatterUtils.print(ftpFile);
      }
    }
  }

}
