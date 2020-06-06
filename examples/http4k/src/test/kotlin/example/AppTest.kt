package example

import com.natpryce.hamkrest.assertion.assertThat
import org.http4k.core.Method.GET
import org.http4k.core.Request
import org.http4k.hamkrest.hasBody
import org.junit.jupiter.api.Test

class AppTest {
    private val app = App()

    @Test
    fun `app says hello!`() {
        assertThat(app(Request(GET, "/")), hasBody("🥳 Hello World 🥳"))
    }
}