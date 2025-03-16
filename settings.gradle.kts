rootProject.name = "blolet"

include(
    "monolithic-client"
    ,"common"
)

project(":monolithic-client").projectDir = file("monolithic/client-api")

apply(from ="core/core.settings.gradle.kts")
apply(from ="services/board/board.settings.gradle.kts")

