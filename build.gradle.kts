import java.time.LocalDate

plugins {
    kotlin("jvm") version "1.9.25" apply false
    id("java-library")
    id("org.springframework.boot") version "3.5.3" apply false
    id("io.spring.dependency-management") version "1.1.7" apply false
    kotlin("plugin.spring") version "1.9.25" apply false
    kotlin("plugin.jpa") version "1.9.25" apply false
    kotlin("kapt") version "1.9.25" apply false
    kotlin("plugin.noarg") version "1.9.25" apply false
}

allprojects{

    group = "com.development"
    version = "0.0.1-SNAPSHOT"

    repositories {

        maven {
            url = uri("http://5.189.132.17:8081/repository/maven-releases-control-academico/")
            isAllowInsecureProtocol = true
        }
        maven {
            url = uri("http://5.189.132.17:8081/repository/maven-snapshots-control-academico/")
            isAllowInsecureProtocol = true
        }

        mavenCentral()
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "21"
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

subprojects {

    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin="java-library")
    apply(plugin="io.spring.dependency-management")

    dependencies {

        implementation("org.jetbrains.kotlin:kotlin-reflect")

        testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
        testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    }

    the<io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension>().apply{
        imports {
            mavenBom("org.springframework.boot:spring-boot-dependencies:3.5.3")
        }
    }

}

tasks.register("info"){
    group = "Info-Details"
    description = "Info Details"

    val name = project.name
    val version = project.version
    val java = System.getProperty("java.version")

    doLast {
        println("Name: $name")
        println("Version: $version")
        println("Java: $java")
    }
}

tasks.register("System-Info"){
    doLast {
        println("OS: ${System.getenv("OS")}")
    }
}

val saludo = tasks.register("saludo"){
    doLast {
        println("Buenos dias")
    }
}

tasks.register("despedida"){
    dependsOn(saludo)
    doLast {
        println("Buenas noches")
    }
}

tasks.register("task-condicional"){
    doLast {
        println("Env: ${System.getenv("CUSTOM_ENV")}")
    }
    onlyIf { System.getenv("CUSTOM_ENV") != null }
}

tasks.register("create-file-info-system"){

    dependsOn("build")

    doLast {

        val dirInfo = File("docs")
        if(!dirInfo.exists()){
            dirInfo.mkdirs()
        }

        val file = File(dirInfo, "info.md")
        if(file.exists()){
            file.delete()
        }

        file.writeText("# Info \n")
        file.appendText("- Name: ${project.name} \n")
        file.appendText("- Versión: ${project.version} \n")
        file.appendText("- Date: ${LocalDate.now()} \n")
        file.appendText("- User: ${System.getProperty("user.name")} \n")
    }
}

/*
    - Para ejecutar instrucciones cuando se ejecute una tarea nativa se usa tasks.named("<tarea>")
    - Para indicar que una tarea se ejecute al finalizar otra tarea se usa finalizedBy("<tarea>")
 */
tasks.named("build"){
    finalizedBy("create-file-info-system")
}