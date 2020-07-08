plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))
    api(project(":infra-common"))
    api(project(":infra-starters"))
    api(project(":infra-spring"))
    implementation("org.jetbrains.exposed:exposed-spring-boot-starter:0.21.1")
}
