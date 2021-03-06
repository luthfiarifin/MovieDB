plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(30)
    buildToolsVersion("30.0.0")

    defaultConfig {
        minSdkVersion(17)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Dependencies.kotlin)
    implementation(Android.ktx)
    implementation(Android.appcompat)

    // Design
    implementation(Dependencies.materialDesign)
    implementation(Dependencies.glide)
    implementation(Android.constraintLayout)

    // Dagger
    implementation(Dagger.dagger)
    implementation(Dagger.androidSupport)
    kapt(Dagger.compiler)
    kapt(Dagger.androidProcessor)

    // Coroutines
    implementation(Coroutines.core)
    implementation(Coroutines.android)

    // Lifecycle
    implementation(Lifecycle.viewModel)
    implementation(Lifecycle.liveData)

    testImplementation(Testing.jUnit)
    androidTestImplementation(Testing.extJUnit)
    androidTestImplementation(Testing.espresso)

    implementation(project(Modules.abstraction))
    implementation(project(Modules.data))
}