plugins {
    id("compositebuildsample.android.library")
    id("compositebuildsample.android.library.compose")
    id("compositebuildsample.android.hilt")
}

android {
    namespace = "com.example.compositebuildsample.core.domain"
}

dependencies {
    implementation(project(":core:model"))
}