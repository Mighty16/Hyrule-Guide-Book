package com.vv.build

object Versions {

    const val kotlinVersion = "1.6.10"
    const val compileSdkVersion = 29
    const val minSdkVersion = 23
    const val targetSdkVersion = 29
    const val applicationId = "com.vv.sample"
    const val applicationVersionCode = 1
    const val applicationVersionName = "1.0.0"

    const val kotlinGradlePlugin = "1.6.10"
    const val ktLint = "10.2.1"
}

object KotlinDeps{
    const val kotlinVer = "1.5.0"

    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${kotlinVer}"
}

object CoroutinesDeps{
    private const val coroutinesVer = "1.6.0"
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVer"
    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVer"
}


object CoreUIDeps{

    private const val materialVersion = "1.1.0-alpha09"
    private const val constraintLayoutVersion = "2.1.3"
    private const val fragmentsVer = "1.4.1"

    const val fragments = "androidx.fragment:fragment-ktx:$fragmentsVer"
    const val material = "com.google.android.material:material:${materialVersion}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${constraintLayoutVersion}"
}

object TestingDeps{

    private const val junitVer = "4.12"
    private const val testRunnerVer = "1.1.1"

    const val junit = "junit:junit:${junitVer}"
    const val testRunner = "androidx.test:runner:${testRunnerVer}"
}

object KoinDeps {
    private const val koinVer = "3.2.0"

    // Koin Core features
    const val koin = "io.insert-koin:koin-core:$koinVer"
    const val koinAndroid = "io.insert-koin:koin-android:$koinVer"
    const val koinTest = "io.insert-koin:koin-test-junit4:$koinVer"
}

object ViewModelDeps {

    private const val lifecycleVer = "2.4.1"
    private const val archVer = "2.1.0"

    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVer"
    const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVer"

    const val viewModelTesting = "androidx.arch.core:core-testing:$archVer"
}

object NetworkDeps {

    private const val retrofitVer = "2.9.0"
    private const val kotlinxJsonVer = "1.3.2"
    private const val kotlinxRetrofitSerializationVer = "0.8.0"

    const val retrofit = "com.squareup.retrofit2:retrofit:$retrofitVer"
    const val kotlinxJson = "org.jetbrains.kotlinx:kotlinx-serialization-json:$kotlinxJsonVer"
    const val retrofitKotlinxSerialization = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:$kotlinxRetrofitSerializationVer"
}
