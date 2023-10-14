plugins {
    id("compositebuildsample.android.library")
    id("compositebuildsample.android.library.compose")
}

android {
    namespace = "com.example.compositebuildsample.feature.list"
}

dependencies {

    implementation(project(":feature:detail"))

    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.navigation.compose)
}