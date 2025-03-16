rootProject.name = "blolet"

include(
    "monolithic-client"
    ,"common"
)

project(":monolithic-client").projectDir = file("monolithic/client")

apply(from ="core.gradle.kts")
apply(from ="board.gradle.kts")

