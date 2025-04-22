version = "0.0.1-SNAPSHOT"

dependencies {
    api(project(":common"))

    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
}