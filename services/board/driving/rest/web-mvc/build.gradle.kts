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

tasks.processResources {
    duplicatesStrategy = DuplicatesStrategy.INCLUDE // 또는 DuplicatesStrategy.WARN 사용 가능

    from("src/main/resources") {
        include("web-local.yml") // 로컬 환경 설정
        include("web-dev.yml")   // 개발 환경 설정
    }
}