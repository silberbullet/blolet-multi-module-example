rootProject.name = "blolet"

val core = file("core").walkTopDown().maxDepth(3).filter(File::isDirectory).associateBy(File::getName)
val board = file("services/board").walkTopDown().maxDepth(3).filter(File::isDirectory).associateBy(File::getName)

include(
    "monolithic"
    ,"common"
)

// CORE
include(
    "nettee-exception-handler-core"
    ,"nettee-jpa-core"
)

project(":nettee-exception-handler-core").projectDir = core["nettee-exception-handler-core"]!!
project(":nettee-jpa-core"              ).projectDir = core["nettee-jpa-core"]!!

// SERVICE/BOARD
include(
    "boardApi"
    ,"boardApi:domain"
    ,"boardApi:exception"
    ,"boardApi:readmodel"
    ,"boardApplication"
    ,"boardDrivenRdbJpa"
    ,"boardDrivingWeb"
)

project(":boardApi"          ).projectDir = board["api"]!!
project(":boardApi:domain"   ).projectDir = board["domain"]!!
project(":boardApi:exception").projectDir = board["exception"]!!
project(":boardApi:readmodel").projectDir = board["readmodel"]!!
project(":boardApplication"  ).projectDir = board["application"]!!
project(":boardDrivenRdbJpa" ).projectDir = board["rdb"]!!
project(":boardDrivingWeb"   ).projectDir = board["rest"]!!
