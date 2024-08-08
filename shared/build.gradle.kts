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
                jvmTarget = "11"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {


            groupId = "com.intellihealth"
            artifactId = "shared-release"
            version = "0.1.0"
            artifact("$buildDir/outputs/aar/shared-release.aar")

            from(components["kotlin"])

            pom {
                name.set("TMComponentKmp")
                description.set("A Kotlin Multiplatform library for IntelliHealth TrueMeds")
                url.set("")//landing page for component

                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("")
                    }
                }

                developers {
                    developer {
                        id.set("intellihealth")
                        name.set("IntelliHealth Team")
                        email.set("")
                    }
                }

                scm {
                    connection.set("scm:git:git://intellihealth.com/shared-release.git")//anonymous public access
                    developerConnection.set("scm:git:ssh://intellihealth.com/shared-release.git") //write permissions, usually via SSH
                    url.set("http://intellihealth.com/shared-release")//This is the URL to the SCM web interface where users can view the repository in a web browser
                }
            }
        }
    }

    repositories {
        maven {
            url = uri("https://mavan.pkg.github.com/nikhilpednekar1/TmComponentKmp")
            credentials {
                username = "nikhilpednekar1"//project.findProperty("repoUser") as String? ?: ""
                password = "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"//project.findProperty("repoPassword") as String? ?: ""
            }
        }
    }
}
