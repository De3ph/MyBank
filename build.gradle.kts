// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.2" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
    id("com.google.devtools.ksp") version "1.9.0-1.0.12" apply false
    id("androidx.room") version "2.6.0" apply false
}

project.ext{
    var RateApiKey = "091e06f20amsh3cb04795e5aab32p173a2bjsn5cc14b59a9af"
}