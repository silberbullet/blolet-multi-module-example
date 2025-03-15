val board = file("services/board").walkTopDown().maxDepth(3).filter(File::isDirectory).associateBy(File::getName)

// SERVICE/BOARD
include(
    "boardApi"
    ,"boardApi:domain"
    ,"boardApi:exception"
    ,"boardApi:readmodel"
    ,"boardApplication"
    ,"boardDrivenRdbJpa"
    ,"boardDrivingWebMvc"
)

project(":boardApi"          ).projectDir = board["api"]!!
project(":boardApi:domain"   ).projectDir = board["domain"]!!
project(":boardApi:exception").projectDir = board["exception"]!!
project(":boardApi:readmodel").projectDir = board["readmodel"]!!
project(":boardApplication"  ).projectDir = board["application"]!!
project(":boardDrivenRdbJpa" ).projectDir = board["jpa"]!!
project(":boardDrivingWebMvc").projectDir = board["web-mvc"]!!
