// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.hilt) apply false
    kotlin("kapt") version "2.0.21"
}

buildscript {
    dependencies {
        classpath(libs.hilt.android.gradle.plugin)
    }
}
