plugins {
    id("compositebuildsample.android.library")
    id("compositebuildsample.android.library.compose")
    id("compositebuildsample.android.hilt")
}

android {
    namespace = "com.example.compositebuildsample.core.data"
}

dependencies {
    implementation(project(":core:database"))
    implementation(project(":core:domain"))
    implementation(project(":core:model"))
}