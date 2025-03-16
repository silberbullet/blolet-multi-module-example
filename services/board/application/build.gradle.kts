plugins{
    `java-library`
}

version = "0.0.1-SNAPSHOT"

dependencies {
    api(project(":board-api"))

    // spring
    implementation("org.springframework:spring-context")
    implementation("org.springframework.data:spring-data-commons")

    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
}