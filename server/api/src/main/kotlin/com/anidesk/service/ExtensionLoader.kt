package com.anidesk.service

import org.springframework.stereotype.Service
import java.io.File

@Service
class ExtensionLoader {

    private val extensionsDir = File("extensions")

    init {
        if (!extensionsDir.exists()) extensionsDir.mkdirs()
    }

    fun listInstalled(): List<String> {
        return extensionsDir.listFiles()
            ?.filter { it.extension == "apk" }
            ?.map { it.nameWithoutExtension }
            ?: emptyList()
    }

    fun installExtension(file: File): Boolean {
        val dest = File(extensionsDir, file.name)
        file.copyTo(dest, overwrite = true)
        return dest.exists()
    }
}
