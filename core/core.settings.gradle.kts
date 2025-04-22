val core = rootDir.resolve("core").walkTopDown().maxDepth(3).filter(File::isDirectory).associateBy(File::getName)

// CORE
include(
    "exception-handler-core"
    ,"jpa-core"
    ,"cors-api"
    ,"cors-webmvc"
)

project(":exception-handler-core").projectDir = core["nettee-exception-handler-core"]!!
project(":jpa-core"              ).projectDir = core["nettee-jpa-core"]!!
project(":cors-api"       ).projectDir = core["nettee-cors-api"]!!
project(":cors-webmvc"    ).projectDir = core["nettee-cors-webmvc"]!!
