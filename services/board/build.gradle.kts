plugins {
    `java-library`
}

version = "0.0.1-SNAPSHOT"

dependencies {
    api(project(":board-api"))
    api(project(":board-application"))
    api(project(":board-rdb-postgresql-adapter"))
    api(project(":board-rest-webmvc-adapter"))
}