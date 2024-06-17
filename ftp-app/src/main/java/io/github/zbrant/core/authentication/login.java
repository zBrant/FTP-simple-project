package io.github.zbrant.core.authentication;

import org.apache.commons.net.ProtocolCommandEvent;
import org.apache.commons.net.ProtocolCommandListener;
import org.apache.commons.net.ftp.FTPClient;

public class login {
  public static FTPClient loginFTP(String host, int port, String username, String password) throws Exception {
    FTPClient ftpClient = new FTPClient();
    ftpClient.addProtocolCommandListener(new ProtocolCommandListener() {
      @Override
      public void protocolCommandSent(ProtocolCommandEvent protocolCommandEvent) {
        System.out.printf("[%s][%d] Command sent : [%s]-%s", Thread.currentThread().getName(),
            System.currentTimeMillis(), protocolCommandEvent.getCommand(),
            protocolCommandEvent.getMessage());
      }

      @Override
      public void protocolReplyReceived(ProtocolCommandEvent protocolCommandEvent) {
        System.out.printf("[%s][%d] Reply received : %s", Thread.currentThread().getName(),
            System.currentTimeMillis(), protocolCommandEvent.getMessage());
      }
    });
    ftpClient.connect(host, port);
    ftpClient.login(username, password);
    return ftpClient;
  }
}
