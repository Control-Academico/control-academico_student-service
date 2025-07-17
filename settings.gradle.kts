dependencyResolutionManagement {
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
}

rootProject.name = "student-service"

listOf("api", "core-local", "persistence", "shared", "domain")
    .forEach { include(it) }