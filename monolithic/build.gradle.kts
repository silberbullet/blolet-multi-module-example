plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
}

version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
}

dependencies {
    // module
    implementation(project(":exceptionHandlerCore"))
    implementation(project(":boardApplication"))
    implementation(project(":boardDrivenRdbJpa"))
    implementation(project(":boardDrivingWebMvc"))

    // spring
    implementation("org.springframework.boot:spring-boot-starter-web")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
