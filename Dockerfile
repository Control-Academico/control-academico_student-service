FROM openjdk:21-jdk-slim

# Instalar herramientas necesarias
RUN apt-get update && apt-get install -y \
    curl \
    maven \
    && rm -rf /var/lib/apt/lists/*

# Crear directorio de trabajo
WORKDIR /app

# Copiar archivos de configuración Maven
COPY pom.xml .

# Descargar dependencias (para cache de Docker)
RUN mvn dependency:go-offline -B

# Copiar código fuente
COPY src ./src

# Exponer puerto
EXPOSE 8080

# Comando por defecto - Spring Boot con hot reload
CMD ["mvn", "spring-boot:run", "-Dspring-boot.run.jvmArguments=-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005"]