import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import database.getDatabaseBuilder
import datastore.DATA_STORE_FILE_NAME
import datastore.createDataStore
import di.initKoin

fun main() {
    initKoin()
    val prefs = createDataStore {
        DATA_STORE_FILE_NAME
    }
    application {
        Window(onCloseRequest = ::exitApplication, title = "amazon clone") {
            val database = remember { getDatabaseBuilder().build() }
            App(prefs = prefs)
        }
    }
}

