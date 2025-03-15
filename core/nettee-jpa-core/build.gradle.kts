plugins {
    `java-library`
}

version = "0.0.1-SNAPSHOT"

dependencies {
    implementation(project(":common"))
    api("org.springframework.boot:spring-boot-starter-data-jpa")

    // querydsl
    implementation("com.querydsl:querydsl-jpa:${dependencyManagement.importedProperties["querydsl.version"]}:jakarta")
    annotationProcessor("com.querydsl:querydsl-apt:${dependencyManagement.importedProperties["querydsl.version"]}:jakarta")
    annotationProcessor("jakarta.persistence:jakarta.persistence-api")
    annotationProcessor("jakarta.annotation:jakarta.annotation-api")
}