package com.ayoubelkhatab.tchisky_android_package

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ayoubelkhatab.android_ktx.formatToString
import com.ayoubelkhatab.tchisky_android_package.ui.theme.TchiskyAndroidPackageTheme
import java.time.LocalDate

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TchiskyAndroidPackageTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Greeting(
                            "Android",
                            modifier = Modifier
                                .padding(20.dp)
                                .clickable {
                                    val dateNow: LocalDate? =
                                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                            LocalDate.now()
                                        } else {
                                            null
                                        }
                                    Log.d("dateNow", "dateNow=$dateNow")
                                    val dateNowFormatted = dateNow?.formatToString("LLL-yyyy")
                                    Log.d(
                                        "dateNow",
                                        "dateNow formatted as dd/mm/yyy=$dateNowFormatted"
                                    )
                                }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        modifier = modifier,
        text = "Hello $name!"
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TchiskyAndroidPackageTheme {
        Greeting("Android")
    }
}