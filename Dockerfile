# Use uma imagem oficial do Maven para a construção do aplicativo
FROM maven:3.9.5-eclipse-temurin-21-alpine AS build

# Defina o diretório de trabalho dentro do contêiner para a construção
WORKDIR /app

# Copie o arquivo pom.xml e outras dependências necessárias para a construção
COPY pom.xml .

# Baixe as dependências do Maven
RUN mvn dependency:go-offline

# Copie o restante do código-fonte para o contêiner
COPY src ./src

# Compile e empacote o aplicativo em um arquivo JAR
RUN mvn clean package 

# Use uma imagem oficial do OpenJDK 21 como base para a execução
FROM openjdk:21-jdk-slim

# Defina o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copie o arquivo JAR gerado do estágio de construção para o diretório de trabalho no contêiner
COPY --from=build /app/target/*.jar app.jar

# Defina variáveis de ambiente
ENV DIGIDINE_PORT=8080
ENV DIGIDINE_DATABASE_URL=jdbc:mysql://db:3306/DigiDine
ENV DIGIDINE_DATABASE_USER=admin
ENV DIGIDINE_DATABASE_PASSWORD=admin

# Exponha a porta configurada
EXPOSE ${DIGIDINE_PORT}

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]