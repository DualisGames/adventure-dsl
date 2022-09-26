plugins {
    `java-library`
    `maven-publish`
    alias(libs.plugins.indra.sonatype)
    alias(libs.plugins.kotlin)
}

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    api(libs.adventure.api)
    compileOnly(libs.kotlin.stdlib)
}

configure<PublishingExtension> {
    publications {
        create("mavenJava", MavenPublication::class.java) {
            from(components["java"])
        }
    }
}