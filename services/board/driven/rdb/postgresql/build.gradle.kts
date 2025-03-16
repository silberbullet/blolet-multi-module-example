plugins {
    `java-library`
}

version = "0.0.1-SNAPSHOT"

dependencies {
    implementation(project(":board-application"))
    api(project(":jpa-core"))

    // spring
    implementation("org.springframework:spring-context")

    // mapstruct
    implementation("org.mapstruct:mapstruct:1.6.3")
    annotationProcessor("org.mapstruct:mapstruct-processor:1.6.3")
    annotationProcessor("org.projectlombok:lombok-mapstruct-binding:0.2.0")

    // database
    runtimeOnly("org.postgresql:postgresql:42.7.4")

    // flyway
    implementation("org.flywaydb:flyway-database-postgresql")

    // lombok
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

    // querydsl
    implementation("com.querydsl:querydsl-jpa:${dependencyManagement.importedProperties["querydsl.version"]}:jakarta")
    annotationProcessor("com.querydsl:querydsl-apt:${dependencyManagement.importedProperties["querydsl.version"]}:jakarta")
    annotationProcessor("jakarta.persistence:jakarta.persistence-api")
    annotationProcessor("jakarta.annotation:jakarta.annotation-api")
}

tasks.processResources {
    duplicatesStrategy = DuplicatesStrategy.INCLUDE // 또는 DuplicatesStrategy.WARN 사용 가능

    from("src/main/resources") {
        include("db-local.yml") // 로컬 환경 설정
        include("db-dev.yml")   // 개발 환경 설정
    }
}