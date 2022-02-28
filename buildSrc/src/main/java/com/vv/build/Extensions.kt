package com.vv.build

import com.android.build.gradle.BaseExtension
import com.android.build.gradle.internal.dsl.DefaultConfig
import org.gradle.api.GradleException
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.plugins.PluginContainer
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.kotlin
import org.gradle.kotlin.dsl.plugins
import org.gradle.kotlin.dsl.version
import java.io.File
import java.util.Properties

fun DependencyHandlerScope.kotlinDeps() {
    "implementation"(KotlinDeps.kotlinStdLib)
}

fun DependencyHandlerScope.coroutinesDeps() {
    "implementation"(CoroutinesDeps.coroutinesCore)
    "implementation"(CoroutinesDeps.coroutinesAndroid)
}

fun DependencyHandlerScope.unitTestDeps() {
    "testImplementation"(TestingDeps.junit)
}

fun DependencyHandlerScope.androidTestDeps() {
    "androidTestImplementation"(TestingDeps.testRunner)
}

fun DependencyHandlerScope.baseUIDeps() {
    "implementation"(CoreUIDeps.fragments)
    "implementation"(CoreUIDeps.material)
    "implementation"(CoreUIDeps.constraintLayout)
}

fun DependencyHandlerScope.viewModelDeps(){
    "implementation"(ViewModelDeps.viewModel)
    "implementation"(ViewModelDeps.liveData)
    "testImplementation"(ViewModelDeps.viewModelTesting)
}

fun DependencyHandlerScope.koinDeps(){
    "implementation"(KoinDeps.koin)
    "implementation"(KoinDeps.koinAndroid)
}


fun DependencyHandlerScope.networkDeps(){
    "implementation"(NetworkDeps.retrofit)
    "implementation"(NetworkDeps.kotlinxJson)
    "implementation"(NetworkDeps.retrofitKotlinxSerialization)
}

fun DependencyHandlerScope.commonDeps() {
    kotlinDeps()
    coroutinesDeps()
    baseUIDeps()
    viewModelDeps()
    koinDeps()

//    "implementation"(CoreUIDeps.material)
//    "implementation"(CoreUIDeps.constraintLayout)
//    "implementation"(KoinDeps.koin)
//    "implementation"(KoinDeps.koinAndroid)
//    "implementation"(ViewModelDeps.viewModel)
//    "implementation"(ViewModelDeps.liveData)
//    "testImplementation"(ViewModelDeps.viewModelTesting)
}

val Project.android: BaseExtension
    get() = extensions.findByName("android") as? BaseExtension
        ?: error("Project '$name' is not an Android module")

fun Project.applyAppPlugins() {
    plugins.run {
        apply("com.android.application")
        apply("kotlin-android")
        apply("kotlin-parcelize")
    }
}

fun Project.applyLibraryPlugins(pluginsExtension: (PluginContainer.() -> Unit)? = null) {

    plugins.run {
        apply("com.android.library")
        apply("kotlin-android")
        apply("kotlin-parcelize")
        pluginsExtension?.invoke(this)
    }
}

fun Project.versionNameFromFile(filePath:String,incrementBuildNumber:Boolean = true):String{
    val props = Properties()
    val versionFile = File(filePath)
    if (!versionFile.exists()){
        props["VERSION_MAJOR"] = "0"
        props["VERSION_MINOR"] = "0"
        props["VERSION_PATCH"] = "1"
        props["BUILD_NUMBER"] = "1"
        props.store(versionFile.writer(), null)
    }else{
        if (versionFile.canRead()){
            props.load(versionFile.inputStream())
        }else throw GradleException("Could not read version file $filePath")
    }
    val buildNumber = props["BUILD_NUMBER"]?.toString()?.toInt() ?: 1
    val result ="${props["VERSION_MAJOR"]}.${props["VERSION_MINOR"]}.${props["VERSION_PATCH"]}($buildNumber)"

    println(result)

    if (incrementBuildNumber){
        props["BUILD_NUMBER"] = (buildNumber+1).toString()
        props.store(versionFile.writer(), null)
    }

    return result
}

fun Project.androidApplicationConfig(
    appId: String,
    appVersionCode: Int = Versions.applicationVersionCode,
    appVersionName: ()->String
){
    androidApplicationConfig(
        appId = appId,
        appVersionCode = appVersionCode,
        appVersionName = appVersionName()
    )
}

fun Project.androidApplicationConfig(
    appId: String,
    appVersionCode: Int = Versions.applicationVersionCode,
    appVersionName: String = Versions.applicationVersionName
) {
    androidLibraryConfig {
        applicationId = appId
        versionCode = appVersionCode
        versionName = appVersionName
    }
}

fun Project.androidLibraryConfig(defaultConfigExtensions: (DefaultConfig.() -> Unit)? = null) {
    android.run {
        compileSdkVersion(Versions.compileSdkVersion)
        defaultConfig {
            defaultConfigExtensions?.invoke(this)
            minSdk = Versions.minSdkVersion
            targetSdk = Versions.targetSdkVersion
            testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
        }
        buildTypes {
            getByName("debug") {
                isMinifyEnabled = false
            }
            getByName("release") {
                isMinifyEnabled = true
                proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
                consumerProguardFiles("consumer-rules.pro")
            }
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }

        sourceSets {
            val kotlinAdditionalSourceSets = project.file("src/main/kotlin")
            findByName("main")?.java?.srcDirs(kotlinAdditionalSourceSets)
        }

        packagingOptions{
            resources.excludes += "META-INF/main.kotlin_module"
            resources.excludes += "DebugProbesKt.bin"
        }

        viewBinding.isEnabled = true
    }
}
