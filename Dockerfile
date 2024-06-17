FROM ubuntu:latest

RUN apt-get update && apt-get install -y vsftpd

RUN useradd -m -d /home/ftpuser -s /bin/bash ftpuser

RUN echo "ftpuser:passwd" | chpasswd

COPY vsftpd.conf /etc/vsftpd.conf

EXPOSE 21

CMD ["/usr/sbin/vsftpd", "/etc/vsftpd.conf"]