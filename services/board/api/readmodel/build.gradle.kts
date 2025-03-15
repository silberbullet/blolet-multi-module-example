version = "0.0.1-SNAPSHOT"

dependencies {
    implementation(project(":boardApi:domain"))

    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
}