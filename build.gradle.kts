import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.61"
}

group = "io.kata.noells"
version = "1.0-SNAPSHOT"
val spekVersion = "2.0.14"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    annotationProcessor("org.apache.logging.log4j:log4j-core:2.13.3")
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.apache.logging.log4j:log4j-core:2.13.3")
    implementation("io.reactivex.rxjava3:rxkotlin:3.0.1")
    
    testImplementation(platform("org.junit:junit-bom:5.7.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.mockito:mockito-core:3.+")
    testCompile("com.winterbe:expekt:0.5.0")

    testImplementation("org.spekframework.spek2:spek-dsl-jvm:$spekVersion")
    testRuntimeOnly("org.spekframework.spek2:spek-runner-junit5:$spekVersion")
    testRuntimeOnly("org.jetbrains.kotlin:kotlin-reflect:1.3.61")
}

tasks.test {
    useJUnitPlatform {
        includeEngines("spek2")
    }
    testLogging{
        showStandardStreams = true
        events("passed", "skipped", "failed")
    }
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions.jvmTarget = "1.8"
}
