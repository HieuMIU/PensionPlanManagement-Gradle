plugins {
    application
    id("com.github.johnrengelman.shadow") version "8.1.1" // Apply the Shadow plugin
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.guava)
    implementation("com.fasterxml.jackson.core:jackson-core:2.15.0")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.15.0")
}

testing {
    suites {
        val test by getting(JvmTestSuite::class) {
            useJUnitJupiter("5.10.3")
        }
    }
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21) // Set this to your Java version
    }
}

application {
    mainClass.set("pensionplan.Main")
}

// Configure the shadow task to create a fat JAR
tasks.shadowJar {
    archiveBaseName.set("Pension-Plan-Management")
    archiveVersion.set("1.0.0")
}
