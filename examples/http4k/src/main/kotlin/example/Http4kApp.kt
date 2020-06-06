package example

import org.http4k.core.HttpHandler
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status.Companion.OK
import org.http4k.core.then
import org.http4k.filter.DebuggingFilters
import org.http4k.server.SunHttp
import org.http4k.server.asServer

/**
 * http4k applications are just pure Kotlin functions. They are simple to write, understand and test!
 *
 * An HttpHandler is just a function which maps a Request to a Response
 *      typealias HttpHandler = (Request) -> Response
 *
 * Filters (or middleware) are functions which decorate HttpHandlers!
 *      interface Filter : (HttpHandler) -> HttpHandler
 *
 * The HTTP message model is immutable, so they are safe and easy to use.
 */
fun App(): (Request) -> Response {

    // our main function - we can add routing easily with a routes() block
    val main: HttpHandler = { _: Request -> Response(OK).body("🥳 Hello World 🥳") }

    // Stacking HttpHandlers and Filters together is just function composition
    val app = DebuggingFilters.PrintRequestAndResponse().then(main)

    return app
}

fun main() {
    // Turn any function into a running server with 1 LOC!
    App().asServer(SunHttp(8080)).start()
}