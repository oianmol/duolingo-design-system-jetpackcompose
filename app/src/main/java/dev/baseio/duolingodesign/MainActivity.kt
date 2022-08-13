package dev.baseio.duolingodesign

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.baseio.composeduolingo.primitives.DuolingoText
import dev.baseio.composeduolingo.DuolingoBackground
import dev.baseio.composeduolingo.primitives.DuolingoButton
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
  DuolingoBackground(Modifier.fillMaxSize()) {
    DuolingoButton(onClick = {

    }) {
      DuolingoText()
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