plugins {
    `java-library`
}

dependencies {
    api(project(":boardApi:domain"))
    api(project(":boardApi:exception"))
    api(project(":boardApi:readmodel"))
}