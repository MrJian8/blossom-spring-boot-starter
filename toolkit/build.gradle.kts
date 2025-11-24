plugins {
    `java-library`
    `maven-publish`
}

// 项目基础配置
group = "xin.blossom"
version = "21.0.0.0"

repositories {
    mavenLocal()
    mavenCentral()
    maven { url = uri("https://maven.aliyun.com/repository/central") }
}
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}
subprojects {
    if (project.name != "toolkit-bom") {
        apply(plugin = "maven-publish")
        apply(plugin = "java-library")
        group = rootProject.group
        version = rootProject.version
        java {
            sourceCompatibility = JavaVersion.VERSION_21
            targetCompatibility = JavaVersion.VERSION_21
            toolchain {
                languageVersion = JavaLanguageVersion.of(21)
            }
        }
        publishing {
            publications {
                create<MavenPublication>("maven") {
                    groupId = rootProject.group.toString()
                    artifactId = project.name
                    version = rootProject.version.toString()
                    from(components["java"])
                }
            }
        }

        repositories {
            mavenLocal()
            mavenCentral()
            maven { url = uri("https://maven.aliyun.com/repository/central") }
        }
        if (project.name != "toolkit-all") {
            dependencies {
                compileOnly("org.projectlombok:lombok:1.18.36")
                annotationProcessor("org.projectlombok:lombok:1.18.36")
                testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.3")
                testImplementation("org.junit.jupiter:junit-jupiter-engine:5.10.3")
                testImplementation("org.junit.jupiter:junit-jupiter-params:5.10.3")
            }
        }
        tasks.withType<JavaCompile> {
            options.encoding = "UTF-8"
            options.compilerArgs.add("-parameters")
        }
        tasks.withType<Test> {
            testLogging {
                events("PASSED", "FAILED", "SKIPPED")
            }
        }
    }
}
