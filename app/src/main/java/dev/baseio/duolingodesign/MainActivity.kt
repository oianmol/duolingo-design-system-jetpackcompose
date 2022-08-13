package dev.baseio.duolingodesign

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.baseio.composeduolingo.DuolingoSurface
import dev.baseio.composeduolingo.primitives.DuolingoButton
import dev.baseio.composeduolingo.primitives.DuolingoText
import dev.baseio.duolingodesign.ui.theme.DuolingoComposeUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DuolingoComposeUITheme {
                // A surface container using the 'background' color from the theme
                Greeting()
            }
        }
    }
}

@Composable
fun Greeting() {
    DuolingoSurface(Modifier.fillMaxSize()) {
        DuolingoButton(onClick = {
        }, elevation = 4.dp) {
            DuolingoText("Test Text", style = TextStyle())
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DuolingoComposeUITheme {
        Greeting()
    }
}