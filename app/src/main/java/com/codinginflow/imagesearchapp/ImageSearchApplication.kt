package com.codinginflow.imagesearchapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ImageSearchApplication : Application() { //Annotate with hilt android app which triggers code generation
}