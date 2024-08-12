# Use uma imagem oficial do OpenJDK 21 como base
FROM openjdk:21-jdk-slim

# Defina o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copie o arquivo JAR gerado para o diretório de trabalho no contêiner
COPY target/*.jar app.jar

# Defina variáveis de ambiente
ENV DIGIDINE_PORT=8080
ENV DIGIDINE_DATABASE_URL=jdbc:mysql://db:3306/DigiDine
ENV DIGIDINE_DATABASE_USER=admin
ENV DIGIDINE_DATABASE_PASSWORD=admin

# Exponha a porta configurada
EXPOSE ${DIGIDINE_PORT}

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
