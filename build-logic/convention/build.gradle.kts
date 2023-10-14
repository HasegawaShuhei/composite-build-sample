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
        register("androidLibraryCompose") {
            id = "compositebuildsample.android.library.compose"
            implementationClass = "com.example.compositebuildsample.AndroidLibraryComposePlugin"
        }
        register("androidHilt") {
            id = "compositebuildsample.android.hilt"
            implementationClass = "com.example.compositebuildsample.AndroidHiltPlugin"
        }
    }
}
