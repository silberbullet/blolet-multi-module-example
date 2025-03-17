plugins {
    `java-library`
}

version = "0.0.1-SNAPSHOT"

dependencies {
    implementation(project(":board-application"))

    // spring
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.data:spring-data-commons")
    implementation("org.springframework.boot:spring-boot-starter-validation")

    // mapstruct
    implementation("org.mapstruct:mapstruct:1.6.3")
    annotationProcessor("org.mapstruct:mapstruct-processor:1.6.3")
    annotationProcessor("org.projectlombok:lombok-mapstruct-binding:0.2.0")

    // lombok
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
}