plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    kotlin("jvm")
    kotlin("plugin.spring")
    kotlin("plugin.jpa")
}

dependencies {

    implementation(project(":shared"))
    implementation(project(":persistence"))
    implementation(project(":core-local"))
    implementation(project(":domain"))

    developmentOnly("org.springframework.boot:spring-boot-devtools")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    // DB H2
    runtimeOnly("com.h2database:h2")

    // Librerias de liquibase para migraciones
    implementation("org.liquibase:liquibase-core")

    // Librerias compartidas
    implementation("com.development:core:0.0.4-SNAPSHOT")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}