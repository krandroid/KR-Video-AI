package com.kr.videoai
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { KRVideoApp() }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KRVideoApp() {
    var prompt by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }
    
    MaterialTheme {
        Scaffold(
            topBar = { TopAppBar(title = { Text("KR Video AI") }) }
        ) { pad ->
            Column(Modifier.padding(pad).padding(16.dp)) {
                OutlinedTextField(
                    value = prompt,
                    onValueChange = { prompt = it },
                    label = { Text("Tulis ide video...") },
                    placeholder = { Text("Contoh: Astronot dance di Mars") },
                    modifier = Modifier.fillMaxWidth().height(120.dp)
                )
                Spacer(Modifier.height(16.dp))
                Button(
                    onClick = { isLoading = true },
                    enabled = !isLoading && prompt.isNotBlank(),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(if (isLoading) "Generating..." else "Generate Video 5s")
                }
            }
        }
    }
}
