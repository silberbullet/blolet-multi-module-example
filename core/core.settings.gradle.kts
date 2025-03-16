val core = rootDir.resolve("core").walkTopDown().maxDepth(3).filter(File::isDirectory).associateBy(File::getName)

// CORE
include(
    "exception-handler-core"
    ,"jpa-core"
)

project(":exception-handler-core").projectDir = core["nettee-exception-handler-core"]!!
project(":jpa-core"             ).projectDir = core["nettee-jpa-core"]!!
