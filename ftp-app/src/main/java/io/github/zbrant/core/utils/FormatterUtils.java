package io.github.zbrant.core.utils;

import org.apache.commons.net.ftp.FTPFile;

public class FormatterUtils {

  public static void print(FTPFile ftpFile) throws Exception {
    System.out.println(ftpFile.toFormattedString());
  }

  public static void printHelper() {
    System.out.println("""
          How to use:\s
            java -jar ftp-simple-project.jar <ftp server address>

          Example:
            java -jar ftp-simple-project 192.168.0.2
          """
    );
  }

  public static void printLogDirectory(String message, boolean operationNotFail, String directoryName){
    if(operationNotFail){
      System.out.printf("Directory successfully %s: %s \n",message, directoryName);
    }else{
      System.out.printf("Directory %s fail: %s \n", message.substring(0, message.length()-1), directoryName);
    }
  }

  public static void printLogFile(String messageOnfail, String messageOnSuccess,
                                  boolean operationNotFail, String directoryName) {
    if (operationNotFail) {
      System.out.printf("File successfully %s: %s \n", messageOnSuccess, directoryName);
    } else {
      System.out.printf("File %s fail: %s \n", messageOnfail, directoryName);
    }
  }
}
