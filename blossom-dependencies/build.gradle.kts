javaPlatform {
    allowDependencies()
}

//publishing {
//    publications {
//        create<MavenPublication>("maven") {
//            from(components["javaPlatform"])
//        }
//    }
//}
publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["javaPlatform"])
        }
    }
}
val versions = mapOf(
    "lombok" to "1.18.36",
    "springBoot" to "3.5.5",
    "springCloud" to "2025.0.0",
    "springCloudAlibaba" to "2023.0.3.3",
    "netty" to "4.1.116.Final",
    "springdoc" to "2.8.11",
    "knife4j" to "4.5.0",
    "druid" to "1.2.27",
    "mybatis" to "3.5.19",
    "mybatisPlus" to "3.5.14",
    "dynamicDatasource" to "4.3.1",
    "pagehelper" to "6.1.0",
    "easyTrans" to "3.0.6",
    "redisson" to "3.51.0",
    "xxlJob" to "3.2.0",
    "lock4j" to "2.2.7",
    "skywalking" to "9.0.0",
    "springBootAdmin" to "3.4.5",
    "opentracing" to "0.33.0",
    "jsoup" to "1.18.1",
    "mapstruct" to "1.6.3",
    "hutool5" to "5.8.35",
    "hutool6" to "6.0.0-M19",
    "fastjson2" to "2.0.54",
    "guava" to "33.4.8-jre"
)


dependencies {
    api(platform("org.springframework.boot:spring-boot-dependencies:${versions["springBoot"]}"))
    api(platform("org.springframework.cloud:spring-cloud-dependencies:${versions["springCloud"]}"))
    api(platform("com.alibaba.cloud:spring-cloud-alibaba-dependencies:${versions["springCloudAlibaba"]}"))
    api(platform("io.netty:netty-bom:${versions["netty"]}"))
    constraints {
//        api(project(":blossom-common"))
        api("org.springframework.boot:spring-boot-configuration-processor:${versions["springBoot"]}")
        api("org.springdoc:springdoc-openapi-starter-webmvc-api:${versions["springdoc"]}")
        api("com.github.xiaoymin:knife4j-openapi3-jakarta-spring-boot-starter:${versions["knife4j"]}") // 推测对应的 Knife4j 依赖
        api("com.alibaba:druid-spring-boot-3-starter:${versions["druid"]}")
        api("org.mybatis:mybatis:${versions["mybatis"]}")
        api("com.baomidou:mybatis-plus-spring-boot3-starter:${versions["mybatisPlus"]}")
        api("com.baomidou:mybatis-plus-jsqlparser:${versions["mybatisPlus"]}")
        api("com.baomidou:mybatis-plus-generator:${versions["mybatisPlus"]}")
        api("com.baomidou:mybatis-plus-extension:${versions["mybatisPlus"]}")
        api("com.baomidou:dynamic-datasource-spring-boot3-starter:${versions["dynamicDatasource"]}")
        api("com.github.pagehelper:pagehelper:${versions["pagehelper"]}")
        api("com.fhs-opensource:easy-trans-spring-boot-starter:${versions["easyTrans"]}")
        api("com.fhs-opensource:easy-trans-mybatis-plus-extend:${versions["easyTrans"]}")
        api("com.fhs-opensource:easy-trans-anno:${versions["easyTrans"]}")
        api("org.redisson:redisson-spring-boot-starter:${versions["redisson"]}")
        api("com.xuxueli:xxl-job-core:${versions["xxlJob"]}")
        api("com.baomidou:lock4j-redisson-spring-boot-starter:${versions["lock4j"]}")
        api("org.apache.skywalking:apm-toolkit-trace:${versions["skywalking"]}")
        api("org.apache.skywalking:apm-toolkit-logback-1.x:${versions["skywalking"]}")
        api("org.apache.skywalking:apm-toolkit-opentracing:${versions["skywalking"]}")
        api("de.codecentric:spring-boot-admin-starter-server:${versions["springBootAdmin"]}")
        api("de.codecentric:spring-boot-admin-starter-client:${versions["springBootAdmin"]}")
        api("io.opentracing:opentracing-api:${versions["opentracing"]}")
        api("io.opentracing:opentracing-util:${versions["opentracing"]}")
        api("io.opentracing:opentracing-noop:${versions["opentracing"]}")
        api("org.jsoup:jsoup:${versions["jsoup"]}")
        api("org.projectlombok:lombok:${versions["lombok"]}")
        api("org.mapstruct:mapstruct:${versions["mapstruct"]}")
        api("org.mapstruct:mapstruct-processor:${versions["mapstruct"]}")
        api("cn.hutool:hutool-all:${versions["hutool5"]}")
        api("org.dromara.hutool:hutool-extra:${versions["hutool6"]}")
        api("com.alibaba.fastjson2:fastjson2:${versions["fastjson2"]}")
        api("com.google.guava:guava:${versions["guava"]}")
    }
}