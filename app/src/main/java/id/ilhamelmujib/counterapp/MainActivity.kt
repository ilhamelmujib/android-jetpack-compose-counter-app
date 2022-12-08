package id.ilhamelmujib.counterapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import id.ilhamelmujib.counterapp.ui.theme.CounterAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CounterAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CounterApp()
                }
            }
        }
    }
}

@Composable
fun CounterApp() {
    Column {
        var number by remember {
            mutableStateOf(0)
        }
        MyButton { number++ }
        Text(
            text = number.toString(),
            modifier = Modifier.align(Alignment.CenterHorizontally),
            style = MaterialTheme.typography.h2,
            fontStyle = FontStyle.Italic
        )
        LazyRow {
            item { Text("No: ") }
            items(number) {
                Text("${it + 1}")
            }
        }
    }
}

@Composable
fun MyButton(onClick: () -> Unit) {
    Button(onClick) {
        Text(text = "Click Me")
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4, showSystemUi = true)
@Composable
fun DefaultPreview() {
    CounterAppTheme {
        CounterApp()
    }
}