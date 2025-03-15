rootProject.name = "blolet"

include(
    "monolithic"
    ,"common"
)

apply(from ="core.gradle.kts")
apply(from ="board.gradle.kts")
