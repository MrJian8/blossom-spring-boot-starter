plugins {
    id("java-library")
}
val revision = "21.1.0.0"
val lombokVersionFinal = "1.18.36"
val springBootVersionFinal = "3.4.1"
val mapstructVersionFinal = "1.6.3"

group = "xin.blossom"
version = revision

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

allprojects {
    group = "xin.blossom"
    version = revision

    repositories {
        mavenLocal()
        mavenCentral()
    }
}

subprojects {
    if (name != "blossom-dependencies") {
        apply(plugin = "java-library")
        java {
            sourceCompatibility = JavaVersion.VERSION_21
            targetCompatibility = JavaVersion.VERSION_21
        }
        tasks.withType<JavaCompile> {
            options.encoding = "UTF-8"
            options.compilerArgs.add("-parameters")
        }
        configurations {
            val apt by creating
            compileOnly.get().extendsFrom(apt)
        }
        if (name != "blossom-common") {
            dependencies {
//                implementation(project(":blossom-common"))
            }
        }
        dependencies {
//            implementation(platform(project(":blossom-dependencies")))
            annotationProcessor("org.projectlombok:lombok:$lombokVersionFinal")
            compileOnly("org.projectlombok:lombok:$lombokVersionFinal")
            annotationProcessor("org.mapstruct:mapstruct-processor:$mapstructVersionFinal")
            compileOnly("org.mapstruct:mapstruct-processor:$mapstructVersionFinal")
            annotationProcessor("org.springframework.boot:spring-boot-configuration-processor:$springBootVersionFinal")
            compileOnly("org.springframework.boot:spring-boot-configuration-processor:$springBootVersionFinal")
        }
    } else {
        apply(plugin = "java-platform")
        apply(plugin = "maven-publish")
    }
}