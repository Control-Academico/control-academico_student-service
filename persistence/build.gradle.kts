plugins {
    id("io.spring.dependency-management")
    kotlin("jvm")
    kotlin("plugin.spring")
    kotlin("plugin.jpa")
    kotlin("kapt")
    kotlin("plugin.noarg")
    kotlin("plugin.allopen")
}

dependencies {

    implementation(project(":shared"))
    implementation(project(":domain"))

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    // Querydsl
    implementation("com.querydsl:querydsl-jpa:5.0.0:jakarta")
    implementation("com.querydsl:querydsl-core:5.0.0")
    kapt("com.querydsl:querydsl-apt:5.0.0:jakarta") {
        exclude(group = "com.querydsl", module = "querydsl-core")
    }

    implementation("jakarta.persistence:jakarta.persistence-api:3.1.0")
    implementation("jakarta.annotation:jakarta.annotation-api:2.1.1")

    // DB Oracle
    runtimeOnly("com.oracle.database.jdbc:ojdbc11")

    // Validations
    implementation("org.springframework.boot:spring-boot-starter-validation")

    // Mapper
    implementation("org.mapstruct:mapstruct:1.5.5.Final")
    kapt("org.mapstruct:mapstruct-processor:1.5.5.Final")

    // Librerias compartidas
    implementation("com.development:core:0.0.4-SNAPSHOT")

}

kapt {
    keepJavacAnnotationProcessors = true
    arguments {
        arg("querydsl.entityAccessors", "true")
        arg("querydsl.generatedAnnotationClass", "jakarta.annotation.Generated")
        arg("querydsl.createCompileJava", "true")
        arg("querydsl.packages", arrayOf(
            "com.development.student.service.persistence.entity",
            "com.development.config"  // Añade aquí el paquete donde está Auditable
        ).joinToString(","))
    }
}

allOpen {
    annotation("jakarta.persistence.Entity")
    annotation("jakarta.persistence.MappedSuperclass")
    annotation("jakarta.persistence.Embeddable")
}

noArg {
    annotation("jakarta.persistence.Entity")
    annotation("jakarta.persistence.MappedSuperclass")
    annotation("jakarta.persistence.Embeddable")
}

tasks.withType<JavaCompile> {
    options.annotationProcessorPath = configurations.kapt.get().asFileTree
}

kotlin {
    jvmToolchain(21)
    sourceSets.main {
        kotlin.srcDir("build/generated/source/kapt/main")
    }
}