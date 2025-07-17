plugins {
    id("io.spring.dependency-management")
    //kotlin("plugin.spring")
}

dependencies {

    implementation(project(":shared"))
    implementation(project(":persistence"))
    implementation(project(":domain"))

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    // Librerias compartidas
    implementation("com.development:core:0.0.4-SNAPSHOT")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}