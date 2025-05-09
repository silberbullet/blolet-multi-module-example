version = "0.0.1-SNAPSHOT"

dependencies {
    api(project(":snowflake-id-hibernate"))
    api("org.springframework.boot:spring-boot-starter-data-jpa")

    // querydsl
    // JPA 엔티티를 분석하고 Q클래스 자동생성
    implementation("com.querydsl:querydsl-jpa:${dependencyManagement.importedProperties["querydsl.version"]}:jakarta")
    annotationProcessor("com.querydsl:querydsl-apt:${dependencyManagement.importedProperties["querydsl.version"]}:jakarta")
    // JPA 기반으로 querydsl-apt 보조
    annotationProcessor("jakarta.persistence:jakarta.persistence-api")
    annotationProcessor("jakarta.annotation:jakarta.annotation-api")
}