package io.github.zbrant.core.service;

import org.apache.commons.net.ftp.FTPClient;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;

public class FileService {

  public void uploadFile(String localPath, String remotePath, FTPClient ftpClient) throws Exception {
    FileInputStream fileInputStream = new FileInputStream(localPath);
    System.out.println();
    System.out.printf("[uploadFile][%d] Is success to upload file : %s -> %b",
        System.currentTimeMillis(), remotePath, ftpClient.storeFile(remotePath, fileInputStream));
    System.out.println();
  }

  public void renameFile(String oldPath, String newPath, FTPClient ftpClient) throws Exception {
    System.out.println();
    System.out.printf("[renameFile][%d] Is success to rename file : from %s to %s -> %b",
        System.currentTimeMillis(), oldPath, newPath, ftpClient.rename(oldPath, newPath));
    System.out.println();
  }

  public byte[] downloadFile(String path, FTPClient ftpClient) throws Exception {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    System.out.println();
    System.out.printf("[downloadFile][%d] Is success to download file : %s -> %b",
        System.currentTimeMillis(), path, ftpClient.retrieveFile(path, byteArrayOutputStream));
    System.out.println();
    return byteArrayOutputStream.toByteArray();
  }

  public void deleteFile(String path, FTPClient ftpClient) throws Exception {
    System.out.println();
    System.out.printf("[deleteFile][%d] Is success to delete file : %s -> %b",
        System.currentTimeMillis(), path, ftpClient.deleteFile(path));
    System.out.println();
  }
}
