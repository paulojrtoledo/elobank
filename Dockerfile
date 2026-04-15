# 1. Imagem base com Java 17
FROM eclipse-temurin:17-jdk

# 2. Diretório de trabalho dentro do container
WORKDIR /app

# 3. Copia os arquivos do projeto
COPY . .

# 4. Dá permissão de execução para o Maven wrapper
RUN chmod +x mvnw

# 5. Faz o build da aplicação (gera o .jar)
RUN ./mvnw clean package -DskipTests

# 6. Expõe a porta da aplicação
EXPOSE 8080

# 7. Comando para rodar a aplicação
CMD ["java", "-jar", "target/elobank-0.0.1-SNAPSHOT.jar"]