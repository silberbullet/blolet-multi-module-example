rootProject.name = "blolet"

include(
    "monolithic"
    ,"common"
    ,"nettee-exception-handler-core"
    ,"nettee-jpa-core"
)

val coreDirs = file("core").walkTopDown().filter(File::isDirectory).associateBy(File::getName)
val servicesDir = file("services")

project(":nettee-exception-handler-core").projectDir = coreDirs["nettee-exception-handler-core"]!!
project(":nettee-jpa-core").projectDir = coreDirs["nettee-jpa-core"]!!
