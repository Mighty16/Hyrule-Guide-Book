import com.vv.build.androidApplicationConfig
import com.vv.build.applyAppPlugins
import com.vv.build.unitTestDeps
import com.vv.build.androidTestDeps
import com.vv.build.commonDeps
import com.vv.build.networkDeps


applyAppPlugins()

androidApplicationConfig("com.vv.botw")

dependencies {
    commonDeps()
    networkDeps()
    unitTestDeps()
    androidTestDeps()
}
