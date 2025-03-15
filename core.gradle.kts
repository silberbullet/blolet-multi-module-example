val core = file("core").walkTopDown().maxDepth(3).filter(File::isDirectory).associateBy(File::getName)

// CORE
include(
    "exceptionHandlerCore"
    ,"jpaCore"
)

project(":exceptionHandlerCore").projectDir = core["nettee-exception-handler-core"]!!
project(":jpaCore"             ).projectDir = core["nettee-jpa-core"]!!
