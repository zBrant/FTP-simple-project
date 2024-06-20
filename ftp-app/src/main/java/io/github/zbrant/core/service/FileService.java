package io.github.zbrant.core.service;

import io.github.zbrant.core.utils.FormatterUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileService {

  public void uploadFile(String[] input, FTPClient ftpClient) throws Exception {
    String localPath = input[0];
    String remotePath = input[1];
    if (remotePath.length() == 1 && remotePath.charAt(0) == '.') remotePath += '/';

    ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
    File localFile = new File(localPath);
    FileInputStream fileInputStream = new FileInputStream(localFile);

    FormatterUtils.printLogFile("upload", "uploaded",
        ftpClient.storeFile(remotePath + localFile.getName(), fileInputStream), localFile.getName()
    );
    fileInputStream.close();
  }

  public void renameFile(String[] input, FTPClient ftpClient) throws Exception {
    String oldPath = input[0];
    String newPath = input[1];
    if (ftpClient.rename(oldPath, newPath)) {
      System.out.printf("File successfully renamed: %s to %s \n", oldPath, newPath);
    } else {
      System.out.printf("File rename fail: %s \n", oldPath);
    }
  }

  public void downloadFile(String[] input, FTPClient ftpClient) throws Exception {
    String path = input[0];
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

    FormatterUtils.printLogFile("download","downloaded",
        ftpClient.retrieveFile(path, byteArrayOutputStream), path
    );
    saveFile(byteArrayOutputStream.toByteArray(), path);
  }

  public void deleteFile(String[] input, FTPClient ftpClient) throws Exception {
    String path = input[0];
    FormatterUtils.printLogFile("delete", "deleted", ftpClient.deleteFile(path), path);
  }

  public void printFiles(String[] input, FTPClient ftpClient) throws Exception {
    String path = (input == null) ? "." : input[0];
    for (FTPFile ftpFile : ftpClient.listFiles(path)) {
      if (ftpFile.isFile()) FormatterUtils.print(ftpFile);
    }
  }

  private void saveFile(byte[] fileBytes, String fileName) {
    String osName = System.getProperty("os.name");
    String downloadUserDirectory;

    if(osName.toLowerCase().contains("windows")){
      downloadUserDirectory = System.getProperty("user.home") + "\\Downloads";
    } else {
      downloadUserDirectory = System.getProperty("user.home") + "/Downloads";
    }

    try{
      File file = new File(downloadUserDirectory, fileName);
      boolean newFile = file.createNewFile();
      FileOutputStream fos = new FileOutputStream(file);

      if (newFile) fos.write(fileBytes);
      fos.close();
    }catch (Exception e ){
      System.out.println("[ERROR] file save failed");
    }
  }

}
