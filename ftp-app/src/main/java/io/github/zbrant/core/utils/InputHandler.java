package io.github.zbrant.core.utils;

import io.github.zbrant.core.service.DirectoryService;
import io.github.zbrant.core.service.FileService;
import org.apache.commons.net.ftp.FTPClient;

import java.io.FileNotFoundException;
import java.util.Arrays;

public class InputHandler {
  private final DirectoryService directoryService;
  private final FileService fileService;

  public InputHandler(){
    this.directoryService = new DirectoryService();
    this.fileService = new FileService();
  }

  public void perform(String[] input, FTPClient client){
    try{
      String command = input[0];
      String[] params = getParams(input);
      switch (command){
        case "get"    -> fileService.downloadFile(params, client);
        case "put"    -> fileService.uploadFile(params, client);
        case "rename" -> fileService.renameFile(params, client);
        case "delete" -> fileService.deleteFile(params, client);
        case "ls"     -> fileService.printFiles(params, client);
        case "dir"    -> directoryService.printDirectories(params, client);
        case "mkdir"  -> directoryService.createDirectory(params, client);
        case "rmdir"  -> directoryService.deleteDirectory(params, client);
        case "cd"     -> directoryService.changeDirectory(params, client);
        case "exit"   -> client.disconnect();
        default -> System.out.println("[ERROR] unknown command: " + command);
      }
    }catch (FileNotFoundException e){
      System.out.println("[ERROR] cause: " + e.getMessage());
    }catch (Exception e){
      System.out.println("[ERROR] cause: Invalid command. Please use the correct syntax");
    }
  }

  public String[] getParams(String[] input){
    if(input.length > 1) return Arrays.copyOfRange(input, 1, input.length);
    return null;
  }
}
