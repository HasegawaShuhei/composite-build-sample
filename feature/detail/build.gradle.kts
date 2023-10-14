plugins {
    id("compositebuildsample.android.library")
    id("compositebuildsample.android.library.compose")
}

android {
    namespace = "com.example.compositebuildsample.feature.detail"
}

dependencies {

    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.navigation.compose)
}