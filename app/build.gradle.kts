plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.sumitkotiya.quickbazar"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.sumitkotiya.quickbazar"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    implementation(group="com.squareup.retrofit2",name="retrofit", version = "2.11.0")
    implementation(group="com.squareup.retrofit2",name="converter-gson", version = "2.11.0")
    implementation(group="com.google.android.material",name="material", version = "1.12.0")

    val room_version = "2.6.1"

    implementation("androidx.room:room-runtime:$room_version")
    annotationProcessor("androidx.room:room-compiler:$room_version")
    implementation("com.github.denzcoskun","ImageSlideshow","0.1.2")
    implementation("com.github.bumptech.glide","glide","4.16.0")
    implementation("de.hdodenhof","circleimageview","3.1.0")

    implementation("com.google.android.exoplayer","exoplayer","2.19.0")


}