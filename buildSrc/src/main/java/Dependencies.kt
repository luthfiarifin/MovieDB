object Dependencies {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:1.3.72"
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
    private const val daggerVersion = "2.27"
    const val dagger = "com.google.dagger:dagger:$daggerVersion"
    const val androidSupport = "com.google.dagger:dagger-android-support:$daggerVersion"
    const val compiler = "com.google.dagger:dagger-compiler:$daggerVersion"
    const val androidProcessor = "com.google.dagger:dagger-android-processor:$daggerVersion"
}