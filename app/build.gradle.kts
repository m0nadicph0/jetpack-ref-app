import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.serialization") version "2.0.0-Beta4"
}

android {
    namespace = "com.m0nadic.contacts"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.m0nadic.contacts"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

        val key: String = gradleLocalProperties(rootDir).getProperty("SUPABASE_ANON_KEY")
        val url: String = gradleLocalProperties(rootDir).getProperty("SUPABASE_URL")

        buildConfigField("String","SUPABASE_ANON_KEY","\"$key\"")
        buildConfigField("String","SUPABASE_URL","\"$url\"")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    implementation("androidx.navigation:navigation-compose:2.7.7")
    implementation("br.com.devsrsouza.compose.icons:tabler-icons:1.1.0")

    val lifecycleVersion = "2.7.0"
    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")
    // ViewModel utilities for Compose
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycleVersion")

    val supabaseVersion = "2.1.2"
    val ktorVersion = "2.3.8"

    implementation("io.github.jan-tennert.supabase:postgrest-kt:$supabaseVersion")
    implementation( "io.github.jan-tennert.supabase:storage-kt:$supabaseVersion")
    implementation( "io.github.jan-tennert.supabase:gotrue-kt:$supabaseVersion")
    implementation( "io.ktor:ktor-client-android:$ktorVersion")
    implementation( "io.ktor:ktor-client-core:$ktorVersion")
    implementation( "io.ktor:ktor-utils:$ktorVersion")

}