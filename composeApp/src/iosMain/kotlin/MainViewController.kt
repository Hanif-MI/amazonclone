import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import datastore.createDataStore
import di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) { App(
    prefs = remember {
        createDataStore()
    }
) }