FROM mysql:latest

ADD initdb.sql /docker-entrypoint-initdb.d/initdb.sql
RUN chmod -R 775 /docker-entrypoint-initdb.d

ENV MYSQL_ROOT_PASSWORD somepassword

