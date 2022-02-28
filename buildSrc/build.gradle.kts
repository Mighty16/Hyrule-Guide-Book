import org.gradle.kotlin.dsl.`kotlin-dsl`
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

buildscript {

    repositories {
        google()
        jcenter()
        mavenCentral()
    }

    dependencies {
        val kotlinVersion = "1.6.10"
        classpath(kotlin("gradle-plugin", version = kotlinVersion))
    }
}
//
repositories {
    google()
    jcenter()
    mavenCentral()
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    languageVersion = "1.4.31"
}

dependencies {
    implementation("com.android.tools.build:gradle:7.0.0")
    implementation("com.android.tools.build:gradle-api:7.0.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.6.10")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")
}

