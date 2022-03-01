package com.ayoubelkhatab.tchisky_android_package

import android.os.Build
import android.os.Bundle
import android.os.SystemClock
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ayoubelkhatab.tchisky_android_package.ui.theme.TchiskyAndroidPackageTheme
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TchiskyAndroidPackageTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting(
                        "Android",
                        modifier = Modifier.clickable {
                            val dateNow = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                LocalDate.now()
                            } else {
                                Date(System.currentTimeMillis())
                            }
                            val dateNowFormatted = dateNow
                            println("dateNow=$dateNow")
                            println("dateNow formatted as dd/mm/yyy=$dateNowFormatted")
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TchiskyAndroidPackageTheme {
        Greeting("Android")
    }
}