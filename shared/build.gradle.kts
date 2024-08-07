plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.compose.compiler)
    id("org.jetbrains.compose") version "1.6.11"
    id("maven-publish")
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(compose.ui)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.components.resources)
            implementation(libs.kotlinx.datetime)
            implementation(libs.kotlin.stdlib.common)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "com.intellihealth.truemeds.tmcomponentkmp"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["kotlin"])

            groupId = "com.intellihealth"
            artifactId = "shared-release"
            version = "0.1.0"
            artifact("$buildDir/outputs/aar/shared-release.aar")


//            pom {
//                name.set("TMComponentKmp")
//                description.set("A Kotlin Multiplatform library for IntelliHealth TrueMeds")
//                url.set("http://www.intellihealth.com/shared-release")
//
//                licenses {
//                    license {
//                        name.set("The Apache License, Version 2.0")
//                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
//                    }
//                }
//
//                developers {
//                    developer {
//                        id.set("intellihealth")
//                        name.set("IntelliHealth Team")
//                        email.set("support@intellihealth.com")
//                    }
//                }
//
//                scm {
//                    connection.set("scm:git:git://github.com/intellihealth/shared-release.git")
//                    developerConnection.set("scm:git:ssh://github.com:intellihealth/shared-release.git")
//                    url.set("http://github.com/intellihealth/shared-release")
//                }
//            }
        }
    }

    repositories {
        maven {
            url = uri("https://mavan.pkg.github.com/nikhilpednekar1/TmComponentKmp")
            credentials {
                username = project.findProperty("repoUser") as String? ?: ""
                password = project.findProperty("repoPassword") as String? ?: ""
            }
        }
    }
}
