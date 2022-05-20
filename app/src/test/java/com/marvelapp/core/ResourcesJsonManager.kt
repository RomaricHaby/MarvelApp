package com.marvelapp.core

import java.io.File

object ResourcesJsonManager {
    private const val RESOURCES_URI = "src/test/java/com/marvelapp/json/"

    fun loadResource(filename: String): String {
        return File(
            RESOURCES_URI,
            filename
        ).readText()
    }
}