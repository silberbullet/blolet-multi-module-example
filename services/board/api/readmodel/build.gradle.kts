version = "0.0.1-SNAPSHOT"

dependencies {
    implementation(project(":board-api:domain"))

    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
}