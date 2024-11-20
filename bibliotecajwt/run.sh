#!/bin/bash

#Cargar variables de entorno
if [ -f .env ]; then
  export $(cat .env | grep -v '#' | awk '/=/ {print $1}')
fi

#Ejecutar la aplicacion Spring Boot con Maven
mvn spring-boot:run
