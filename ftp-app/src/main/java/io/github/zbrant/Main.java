package io.github.zbrant;

import io.github.zbrant.core.FTPClientApp;
import io.github.zbrant.core.utils.FormatterUtils;

public class Main {

  public static void main(String[] args) throws Exception {
    if(!valideInput(args)) return;
    String serverIp = args[0];
    Integer serverPort = 21;
    FTPClientApp.start(serverIp, serverPort);
  }

  public static boolean valideInput(String[] args){
    if(args.length != 1){
      FormatterUtils.printHelper();
      return false;
    }
    return true;
  }
}