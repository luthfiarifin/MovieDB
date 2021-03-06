plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(30)
    buildToolsVersion("30.0.0")

    defaultConfig {
        applicationId = "com.laam.moviedb"
        minSdkVersion(17)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField("String", "BASE_URL", "\"https://api.themoviedb.org/3/\"")
        buildConfigField("String", "BASE_IMAGE_URL", "\"https://image.tmdb.org/t/p/w185\"")
        buildConfigField("String", "MOVIE_DB_KEY", "\"1e924ebb18bb8856e9245213d420cbcb\"")
        buildConfigField("String", "REGION", "\"id\"")

        javaCompileOptions {
            annotationProcessorOptions {
                arguments = hashMapOf(
                    "room.schemaLocation" to "$projectDir/schemas",
                    "room.incremental" to "true",
                    "room.expandProjection" to "true"
                )
            }
        }
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

    buildFeatures {
        dataBinding = true
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

    // Retrofit
    implementation(Dependencies.retrofit)

    // Moshi
    implementation(Moshi.kotlin)
    implementation(Moshi.retrofitConverter)
    kapt(Moshi.codeGen)

    // Room
    implementation(Room.ktx)
    implementation(Room.runtime)
    kapt(Room.compiler)

    // Lifecycle
    implementation(Lifecycle.viewModel)
    implementation(Lifecycle.liveData)

    // Coroutines
    implementation(Coroutines.core)
    implementation(Coroutines.android)

    testImplementation(Testing.jUnit)
    androidTestImplementation(Testing.extJUnit)
    androidTestImplementation(Testing.espresso)

}