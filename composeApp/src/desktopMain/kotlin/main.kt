import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import database.getDatabaseBuilder
import di.initKoin

fun main() {
    initKoin()
    application {
        Window(onCloseRequest = ::exitApplication, title = "amazon clone") {
            val database = remember { getDatabaseBuilder().build() }
            App(database)
        }
    }
}

