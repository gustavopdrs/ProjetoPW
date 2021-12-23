@echo off
call mvn clean package
call docker build -t br.edu.ifsul/Trabalho-PW-Etapa1-Web .
call docker rm -f Trabalho-PW-Etapa1-Web
call docker run -d -p 9080:9080 -p 9443:9443 --name Trabalho-PW-Etapa1-Web br.edu.ifsul/Trabalho-PW-Etapa1-Web