plugins {
    id("compositebuildsample.android.library")
    id("compositebuildsample.android.library.compose")
    id("compositebuildsample.android.hilt")
}

android {
    namespace = "com.example.compositebuildsample.feature.list"
}

dependencies {

    implementation(project(":core:domain"))
    implementation(project(":core:model"))
    implementation(project(":feature:detail"))

    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.hilt.navigation.compose)
}