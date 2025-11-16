package com.anidesk

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AniDeskServerApplication

fun main(args: Array<String>) {
    runApplication<AniDeskServerApplication>(*args)
}
