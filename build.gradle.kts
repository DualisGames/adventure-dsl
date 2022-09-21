plugins {
    `java-library`
    alias(libs.plugins.indra.sonatype)
    alias(libs.plugins.kotlin)
}

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    api(libs.adventure.api)
}
