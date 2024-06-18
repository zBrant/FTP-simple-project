package io.github.zbrant.core.utils;

import org.apache.commons.net.ftp.FTPFile;

public class FormatterUtils {

  public static void print(FTPFile ftpFile) throws Exception {
      System.out.println();
      System.out.printf("[printTree][%d]\n", System.currentTimeMillis());
      System.out.printf("[printTree][%d] Get name : %s \n", System.currentTimeMillis(), ftpFile.getName());
      System.out.printf("[printTree][%d] Get timestamp : %s \n", System.currentTimeMillis(), ftpFile.getTimestamp().getTimeInMillis());
      System.out.printf("[printTree][%d] Get group : %s \n", System.currentTimeMillis(), ftpFile.getGroup());
      System.out.printf("[printTree][%d] Get link : %s \n", System.currentTimeMillis(), ftpFile.getLink());
      System.out.printf("[printTree][%d] Get user : %s \n", System.currentTimeMillis(), ftpFile.getUser());
      System.out.printf("[printTree][%d] Get type : %s \n", System.currentTimeMillis(), ftpFile.getType());
      System.out.printf("[printTree][%d] Formatted string : %s \n", System.currentTimeMillis(), ftpFile.toFormattedString());
      System.out.println();
    }

    public static void printHelper() {
        System.out.println("""
            Como Usar\s
              java -jar ftp-simple-project <ftp server address>

            Exemplo:
              java -jar ftp-simple-project 192.168.0.2
            """
        );
    }
}
