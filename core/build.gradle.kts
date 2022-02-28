import com.vv.build.androidLibraryConfig
import com.vv.build.applyLibraryPlugins
import com.vv.build.baseUIDeps
import com.vv.build.kotlinDeps
import com.vv.build.networkDeps
import com.vv.build.viewModelDeps


plugins {
    kotlin("plugin.serialization") version "1.4.0"
}

applyLibraryPlugins{

}

androidLibraryConfig{
}

dependencies{
    baseUIDeps()
    kotlinDeps()
    viewModelDeps()
    networkDeps()
}