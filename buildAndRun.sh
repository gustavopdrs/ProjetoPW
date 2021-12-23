#!/bin/sh
mvn clean package && docker build -t br.edu.ifsul/Trabalho-PW-Etapa1-Web .
docker rm -f Trabalho-PW-Etapa1-Web || true && docker run -d -p 9080:9080 -p 9443:9443 --name Trabalho-PW-Etapa1-Web br.edu.ifsul/Trabalho-PW-Etapa1-Web