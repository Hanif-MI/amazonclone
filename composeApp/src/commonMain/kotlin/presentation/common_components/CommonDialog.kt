package presentation.common_components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun CommonDialog(
    title: String,
    message: String,
    onDismiss: () -> Unit,
    confirmButtonText: String = "OK",
    confirmAction: () -> Unit
) {
    var isDialogOpen by remember { mutableStateOf(false) }

    Button(onClick = { isDialogOpen = true }) {
        Text("Open Dialog")
    }

    if (isDialogOpen) {
        AlertDialog(
            onDismissRequest = { onDismiss() },
            confirmButton = {
                Button(onClick = {
                    confirmAction()
                    isDialogOpen = false
                }) {
                    Text(confirmButtonText)
                }
            },
            title = { Text(title) },
            text = { Text(message) }
        )
    }
}