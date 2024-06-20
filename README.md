# FTP Client

This is a basic FTP client written in java. It provides a command-line interface to perform common FTP operations.

### Commands

- **get**: Downloads a file from the FTP server.
- **put**: Uploads a file to the FTP server.
- **rename**: Renames a file on the FTP server.
- **delete**: Deletes a file on the FTP server.
- **ls**: Lists the files on the FTP server.
- **dir**: Lists the directories on the FTP server.
- **mkdir**: Creates a new directory on the FTP server.
- **rmdir**: Deletes a directory on the FTP server.
- **cd**: Changes the current directory on the FTP server.
- **exit**: Exits the FTP client.
- **?**: List all available commands.

### Usage

1. Compile the program.
2. Run the program and enter the FTP server address to connect.
3. Enter the user and password.
4. Use the provided commands below to interact with the FTP server.

### Example Usage

| Command | How to use                                            |
|:--------|:------------------------------------------------------|
| get     | ```ftp-client > get <path/to/file>```                 |
| put     | ```ftp-client > put <path/to/file>```                 |
| rename  | ```ftp-client > rename <file name> <new file name>``` |
| delete  | ```ftp-client > delete <file name>```                 |
| ls      | ```ftp-client > ls```                                 |
| dir     | ```ftp-client > dir ```                               |
| mkdir   | ```ftp-client > mkdir <new directory name>```         |
| rmdir   | ```ftp-client > rmdir <directory name>```             |
| cd      | ```ftp-client > cd <directory name>```                |
| exit    | ```ftp-client > exit```                               |
| ?       | ```ftp-client > ?```                                  |

### Contributing
This project is open-source and welcomes contributions. If you have any suggestions or bug reports, please open an issue on GitHub.

### License

This project is licensed under the [MIT License](https://opensource.org/licenses/MIT).