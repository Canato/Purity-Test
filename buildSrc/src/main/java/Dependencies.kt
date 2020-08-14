object Versions {

    // Build Config
    const val minSDK = 21
    const val compileSDK = 29
    const val targetSDK = 29

    // App Version
    const val appVersionCode = 1
    const val appVersionName = "0.1"

    // Gradle
    const val gradle = "4.0.0"

    // Kotlin
    const val ktLint = "9.2.1"
    const val kotlin = "1.3.70"
    const val coroutine = "1.3.7"
    const val coroutineServices = "1.1.1"
    const val kotlinGradlePlugin = "4.3.3"

    // Android
    const val appcompact = "1.1.0"
    const val core = "1.2.0"

    // Layout
    const val recyclerview = "1.1.0"
    const val materialDesign = "1.1.0"
    const val constraintLayout = "1.1.3"

    // Google
    const val firebaseAuth = "19.3.0"
    const val firebaseAnalytics = "17.3.0"
    const val gson = "2.8.6"

    // Tests
    const val junit = "4.12"
    const val mockk = "1.9.3"
    const val junitAndroid = "1.1.1"
    const val espressoAndroid = "3.2.0"

    // Dependency Injection
    const val hilt = "2.28-alpha"
}

object Deps {

    const val ktlint = "org.jlleitschuh.gradle:ktlint-gradle:${Versions.ktLint}"

    const val gradle = "com.android.tools.build:gradle:${Versions.gradle}"
    const val googleServices = "com.google.gms:google-services:${Versions.kotlinGradlePlugin}"
    const val kotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"

    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"

    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompact}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.core}"

    const val ktCoroutineCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine}"
    const val ktCoroutineAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutine}"

    const val gson = "com.google.code.gson:gson:${Versions.gson}"

    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

    const val materialDesign = "com.google.android.material:material:${Versions.materialDesign}"
    const val coroutinesPlayService =
        "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:${Versions.coroutineServices}"

    const val firebaseAuth = "com.google.firebase:firebase-auth:${Versions.firebaseAuth}"

    const val firebaseAnalytics =
        "com.google.firebase:firebase-analytics:${Versions.firebaseAnalytics}"

    const val hiltGradle =
        "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"

    const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"

    const val hiltComplier = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
}

object DepsTest {

    const val junit = "junit:junit:${Versions.junit}"
    const val junitAndroid = "androidx.test.ext:junit:${Versions.junitAndroid}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoAndroid}"

    const val mockk = "io.mockk:mockk:${Versions.mockk}"
}