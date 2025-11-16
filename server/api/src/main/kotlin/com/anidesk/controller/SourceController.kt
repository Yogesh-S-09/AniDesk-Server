package com.anidesk.controller

import com.anidesk.service.ExtensionLoader
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/sources")
class SourceController(private val loader: ExtensionLoader) {

    @GetMapping
    fun listSources(): List<Map<String, String>> {
        return loader.listInstalled().map {
            mapOf("id" to it, "name" to it.replaceFirstChar(Char::titlecase))
        }
    }
}
