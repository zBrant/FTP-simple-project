package io.github.zbrant.core.utils;

import org.apache.commons.net.ftp.FTPFile;

public class FormatterUtils {

  public static void print(FTPFile ftpFile) throws Exception {
    System.out.println(ftpFile.toFormattedString());
  }

  public static void printHelper() {
    System.out.print("""
          get       put      ?\s
          delete    ls       cd \s
          mkdir     rmdir    dir\s
          exit      rename   \s
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

  public static void printLogFile(String messageOnFail, String messageOnSuccess,
                                  boolean operationNotFail, String directoryName) {
    if (operationNotFail) {
      System.out.printf("File successfully %s: %s \n", messageOnSuccess, directoryName);
    } else {
      System.out.printf("File %s fail: %s \n", messageOnFail, directoryName);
    }
  }
}
