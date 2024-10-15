# Etapa de build: Use uma imagem oficial do Maven para construir o aplicativo
FROM maven:3.9.5-eclipse-temurin-21-alpine AS build

# Defina o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copie o arquivo pom.xml e outras dependências necessárias para a construção
COPY pom.xml .

# Baixe as dependências do Maven para agilizar o processo de build
RUN mvn dependency:go-offline

# Copie o restante do código-fonte para o contêiner
COPY src ./src

# Compile e empacote o aplicativo em um arquivo JAR
RUN mvn clean package -DskipTests

# Etapa de execução: Use uma imagem oficial do OpenJDK 21 para executar o aplicativo
FROM openjdk:21-jdk-slim

# Defina o diretório de trabalho no contêiner
WORKDIR /app

# Copie o JAR gerado na etapa de build para o contêiner
COPY --from=build /app/target/*.jar app.jar

# Defina variáveis de ambiente para o MongoDB e outros parâmetros da aplicação
ENV DIGIDINE_PORT=8080
ENV SPRING_DATA_MONGODB_HOST=mongo
ENV SPRING_DATA_MONGODB_PORT=27017
ENV SPRING_DATA_MONGODB_DATABASE=digidine_db
ENV SPRING_DATA_MONGODB_USERNAME=root
ENV SPRING_DATA_MONGODB_PASSWORD=admin
ENV SPRING_PROFILES_ACTIVE=prod

# Exponha a porta da aplicação
EXPOSE ${DIGIDINE_PORT}

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
