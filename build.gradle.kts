import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose") version "1.1.1"
}

group = "com.w4ff3l.snake"
version = "1.0-SNAPSHOT"

repositories {
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
        withJava()
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }
    sourceSets {
        val jvmMain by getting {
            dependencies {
                implementation(compose.desktop.currentOs)
                implementation("org.openrndr:openrndr-math:0.4.1")
            }
        }
        val jvmTest by getting {
            dependencies{
                implementation("org.junit.jupiter:junit-jupiter:5.9.1")
            }
        }
    }
}

compose.desktop {
    application {
        val version = "1.0.0"
        mainClass = "w4ff3l.snake.MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "snake"
            packageVersion = version
            windows {
                packageVersion = version
                msiPackageVersion = version
                exePackageVersion = version
            }
        }
    }
}
