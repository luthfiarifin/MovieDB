private object Version {
    const val daggerVersion = "2.27"
    const val retrofitVersion = "2.9.0"
    const val moshi = "1.9.2"
}

object Dependencies {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:1.3.72"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofitVersion}"
}

object Android {
    const val ktx = "androidx.core:core-ktx:1.3.0"
    const val appcompat = "androidx.appcompat:appcompat:1.1.0"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:1.1.3"
}

object Testing {
    const val jUnit = "junit:junit:4.13"
    const val extJUnit = "androidx.test.ext:junit:1.1.1"
    const val espresso = "androidx.test.espresso:espresso-core:3.2.0"
}

object Dagger {
    const val dagger = "com.google.dagger:dagger:${Version.daggerVersion}"
    const val androidSupport = "com.google.dagger:dagger-android-support:${Version.daggerVersion}"
    const val compiler = "com.google.dagger:dagger-compiler:${Version.daggerVersion}"
    const val androidProcessor = "com.google.dagger:dagger-android-processor:${Version.daggerVersion}"
}

object Moshi {
    const val kotlin = "com.squareup.moshi:moshi-kotlin:${Version.moshi}"
    const val codeGen = "com.squareup.moshi:moshi-kotlin-codegen:${Version.moshi}"
    const val retrofitConverter = "com.squareup.retrofit2:converter-moshi:${Version.retrofitVersion}"
}