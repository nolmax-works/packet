plugins {
    id("java")
    id("maven-publish")
    id("com.google.protobuf") version "0.9.6"
}

group = "com.qtpc.tech.nolmax"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation("com.google.protobuf:protobuf-java:4.34.0")
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])

            pom {
                name.set("nolmax's packet object")
                description.set("packet schema object for nolmax")
                url.set("https://github.com/nolmax-works/packet")
            }
        }
    }

    repositories {
        maven {
            name = "qtpcRepo"
            url = uri("https://maven.qtpc.tech/releases")
            credentials {
                username = System.getenv("MAVEN_USERNAME")
                password = System.getenv("MAVEN_PASSWORD")
            }
        }
    }
}

tasks.test {
    useJUnitPlatform()
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:4.34.0"
    }
}