plugins {
    `java-platform`
    `maven-publish`
}

repositories {
    mavenCentral()
}

javaPlatform {
    allowDependencies()
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["javaPlatform"])
        }
    }
}

dependencies {
    constraints {
        api(project(":toolkit-core"))
        api(project(":toolkit-mybatis"))
        api(project(":toolkit-web"))
    }
}