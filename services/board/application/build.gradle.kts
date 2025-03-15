plugins{
    `java-library`
}

version = "0.0.1-SNAPSHOT"

dependencies {
    implementation(project(":common"))
    api(project(":boardApi"))

    // spring
    implementation("org.springframework:spring-context")
    implementation("org.springframework.data:spring-data-commons")

    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
}