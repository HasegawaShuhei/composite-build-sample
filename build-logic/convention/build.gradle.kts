plugins {
    `kotlin-dsl`
}

group = "com.example.compositebuildsample.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}


dependencies {
    implementation(libs.android.gradlePlugin)
    implementation(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "compositebuildsample.android.application"
            implementationClass = "com.example.compositebuildsample.AndroidApplicationPlugin"
        }
        register("androidLibrary") {
            id = "compositebuildsample.android.library"
            implementationClass = "com.example.compositebuildsample.AndroidLibraryPlugin"
        }
    }
}
//dependencies {
//    implementation(libs.androidxCoreCoreKtx)
//    implementation(libs.androidxLifecycleLifecycleRuntimeKtx)
//    implementation(libs.androidxActivityActivityCompose)
//    implementation(libs.junit)
//    implementation(libs.androidxTestExtJunit)
//    implementation(libs.androidxTestEspressoEspressoCore)
//    implementation(libs.androidxComposeComposeBom)
//}