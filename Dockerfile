# Baixando um Sistema Operacional
FROM openjdk:8-jdk-alpine
# No SO baixado acima, criando um usuário e senha
RUN addgroup -S spring && adduser -S spring -G spring
# Seta o usuário acima, a ser usado no SO
USER spring:spring
# Cria uma variavel para guardar o camiho do .jar gerado
ARG JAR_FILE=target/*.jar
# Copia o .jar acima, para o SO criado, com o nome app.jar
COPY ${JAR_FILE} app.jar
# Comando a ser executado no Container
ENTRYPOINT ["java","-jar","/app.jar"]