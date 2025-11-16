package com.anidesk.controller

import com.anidesk.service.ExtensionLoader
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.io.File

@RestController
@RequestMapping("/api/extensions")
class ExtensionController(private val loader: ExtensionLoader) {

    @PostMapping("/install")
    fun uploadExtension(@RequestParam("file") file: MultipartFile): ResponseEntity<String> {
        val extensionsDir = File(System.getProperty("user.dir"), "extensions")
        print(extensionsDir)
        if (!extensionsDir.exists()) extensionsDir.mkdirs()

        val dest = File(extensionsDir, file.originalFilename!!)
        file.transferTo(dest)

        return if (dest.exists()) {
            ResponseEntity.ok("✅ Extension ${file.originalFilename} installed at ${dest.absolutePath}")
        } else {
            ResponseEntity.internalServerError().body("❌ Failed to install ${file.originalFilename}")
        }
    }

    @GetMapping("/")
    fun listExtensions(): List<String> = loader.listInstalled()
}
