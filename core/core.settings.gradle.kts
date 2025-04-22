val core = rootDir.resolve("core").walkTopDown().maxDepth(3).filter(File::isDirectory).associateBy(File::getName)

// CORE
include(
    "exception-handler-core"
    ,"jpa-core"
    ,"nettee-cors-api"
    ,"nettee-cors-webmvc"
)

project(":exception-handler-core").projectDir = core["nettee-exception-handler-core"]!!
project(":jpa-core"              ).projectDir = core["nettee-jpa-core"]!!
project(":nettee-cors-api"       ).projectDir = core["nettee-cors-api"]!!
project(":nettee-cors-webmvc"    ).projectDir = core["nettee-cors-webmvc"]!!
