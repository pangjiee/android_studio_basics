package com.example.myapplication_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.myapplication_1.ui.theme.MyApplication_1Theme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplication_1Theme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {

                    /*  GreetingImage(
                          "Sandra", "from Pipi", modifier = Modifier.padding(8.dp)
                      )*/

                    /*  ComposeArticleImage(
                          header = "Jetpack Compose tutorial",
                          contentFirst = "Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.\n",
                          contentSecond = "In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app\\'s UI programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI\\'s construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name.\n"
                      )*/

                    //TaskManagerApp()
                    ComposeBasics()
                }
            }
        }
    }
}

// Birthday Greeting section
@Composable
fun Greeting(name: String, from: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
    ) {
        Text(
            text = "Happy Birthday $name!",
            fontSize = 100.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = "from $from",
            fontSize = 36.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.androidparty)
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Image(painter = image, contentDescription = null, contentScale = ContentScale.Crop, alpha = 0.5F)
        Greeting(
            name = stringResource(R.string.happy_birthday_text), from = stringResource(R.string.signature_text), modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}

//@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplication_1Theme {
        //s Greeting("Sandra", "From Pipi")
        GreetingImage(message = stringResource(id = R.string.happy_birthday_text), from = stringResource(id = R.string.signature_text))
    }
}
// Birthday Greeting section end


// Compose article app
@Composable
fun ComposeArticleImage(header: String, contentFirst: String, contentSecond: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Image(
            painter = painterResource(id = R.drawable.bg_compose_background), // Replace with your image resource name
            contentDescription = "Header Image"
        )
        Text(
            text = header,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(16.dp),
        )
        Text(
            text = contentFirst,
            fontSize = 16.sp,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = contentSecond,
            fontSize = 16.sp,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }

}

//@Preview(showBackground = true)
@Composable
fun ComposeArticleImagePreview() {
    MyApplication_1Theme {
        ComposeArticleImage(
            "Jetpack Compose tutorial",
            "Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.\n",
            "In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app\\'s UI programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI\\'s construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name.\n"
        )
    }
}

// Compose article end


//Task completed app
@Composable
fun TaskManagerApp() {
    TaskManagerScreen(
        painterResource(
            id = R.drawable.ic_task_completed
        ),
        "All tasks completed", "Nice work!"
    )
}

@Composable
private fun TaskManagerScreen(imagePainter: Painter, firstMsg: String, secondMsg: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Image(painter = imagePainter, contentDescription = null)
        Text(
            text = firstMsg,
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = secondMsg,
            fontSize = 16.sp
        )
    }
}

// @Preview(showBackground = true)
@Composable
fun TaskManagerScreenPreview() {
    MyApplication_1Theme {
        TaskManagerApp()
    }
}
// Task completed app end


@Composable
fun ComposeBasics(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier.weight(1f)
        ) {
            Box(
                modifier = Modifier
                    .background(Color(0xFFEADDFF))
                    .weight(1f)
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Text composable",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 16.dp),
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = "Displays text and follows the recommended Material Design guidelines.",
                        textAlign = TextAlign.Justify
                    )
                }

            }
            Box(
                modifier = Modifier
                    .background(Color(0xFFD0BCFF))
                    .weight(1f)
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Image composable",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 16.dp),
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = "Creates a composable that lays out and draws a given Painter class object.",
                        textAlign = TextAlign.Justify
                    )
                }
            }
        }
        Row() {
            Box(
                modifier = Modifier
                    .background(Color(0xFFB69DF8))
                    .weight(1f)
                    .fillMaxSize(0.5f)
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Row composable",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 16.dp),
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = "A layout composable that places its children in a horizontal sequence.",
                        textAlign = TextAlign.Justify
                    )
                }
            }
            Box(
                modifier = Modifier
                    .background(Color(0xFFF6EDFF))
                    .weight(1f)
                    .fillMaxSize(0.5f)
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Column composable",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 16.dp),
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = "A layout composable that places its children in a vertical sequence.",
                        textAlign = TextAlign.Justify
                    )
                }
            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun ComposeBasicsPreview() {
    MyApplication_1Theme {
        ComposeBasics()
    }
}

