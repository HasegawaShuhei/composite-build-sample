plugins {
    id("compositebuildsample.android.library")
    id("compositebuildsample.android.library.compose")
}

android {
    namespace = "com.example.compositebuildsample.core.domain"
}

dependencies {
    implementation(project(":core:model"))
}