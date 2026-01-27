buildscript {
    extra.apply {
        set("compose_compiler_version", "1.5.3")
    }
}

// Top-level build file

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
}
