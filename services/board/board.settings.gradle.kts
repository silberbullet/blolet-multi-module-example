val board = rootDir.resolve("services").resolve("board").walkTopDown().maxDepth(3).filter(File::isDirectory).associateBy(File::getName)

// SERVICE/BOARD
include(
     "board"
    ,"board-api"
    ,"board-api:domain"
    ,"board-api:exception"
    ,"board-api:readmodel"
    ,"board-application"
    ,"board-rdb-postgresql-adapter"
    ,"board-rest-webmvc-adapter"
)

project(":board"                       ).projectDir = board["board"]!!
project(":board-api"                   ).projectDir = board["api"]!!
project(":board-api:domain"            ).projectDir = board["domain"]!!
project(":board-api:exception"         ).projectDir = board["exception"]!!
project(":board-api:readmodel"         ).projectDir = board["readmodel"]!!
project(":board-application"           ).projectDir = board["application"]!!
project(":board-rdb-postgresql-adapter").projectDir = board["postgresql"]!!
project(":board-rest-webmvc-adapter"   ).projectDir = board["web-mvc"]!!

