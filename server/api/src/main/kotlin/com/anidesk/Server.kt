package com.anidesk

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

// We can try importing something from the tester.
// If this line doesn't show an error in your IDE, the build is working!
// import com.github.safapp.aniyomi.tester.ExtensionTester // (This is just a guess at the package name)

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureRouting()
    }.start(wait = true)
}

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("AniDesk Server is running!")
        }

        get("/test-integration") {
            // Later, we will put the real tester code here.
            // For now, just prove the route works.
            call.respondText("Integration point. Next step is to call the tester.")
        }
    }
}