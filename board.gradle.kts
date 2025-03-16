val board = file("services/board").walkTopDown().maxDepth(3).filter(File::isDirectory).associateBy(File::getName)

// SERVICE/BOARD
include(
    "board-api"
    ,"board-api:domain"
    ,"board-api:exception"
    ,"board-api:readmodel"
    ,"board-application"
    ,"board-rdb-postgresql-adapter"
    ,"board-rest-webmvc-adapter"
)

project(":board-api"                   ).projectDir = board["api"]!!
project(":board-api:domain"            ).projectDir = board["domain"]!!
project(":board-api:exception"         ).projectDir = board["exception"]!!
project(":board-api:readmodel"         ).projectDir = board["readmodel"]!!
project(":board-application"           ).projectDir = board["application"]!!
project(":board-rdb-postgresql-adapter").projectDir = board["jpa"]!!
project(":board-rest-webmvc-adapter"   ).projectDir = board["web-mvc"]!!
