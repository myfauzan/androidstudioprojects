package com.workshop.test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.workshop.test.ui.theme.Greenblue
import com.workshop.test.ui.theme.Orange
import com.workshop.test.ui.theme.TestTheme
import com.workshop.test.ui.theme.Yellowlight
import androidx.compose.material.IconButton as IconButton1

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           TestTheme {
               // A surface container using the 'background' color from the theme
               MyApp()
           }

        }
    }
}

@Composable
fun MyApp() {

    var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }

    if (shouldShowOnboarding) {
        OnboardingScreen(onContinueClicked = { shouldShowOnboarding = false })
    } else {
        CreateLayout(onContinueClicked = {})
    }
}
@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun OnboardingPreview() {
    TestTheme {
        OnboardingScreen(onContinueClicked = {})
    }
}

@Composable
fun OnboardingScreen(onContinueClicked: () -> Unit) {

    Surface {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Welcome to the MYFauzan Codelab!")
            Button(
                modifier = Modifier.padding(vertical = 24.dp),
                onClick = onContinueClicked
            ) {
                Text("Continue")
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun CreateLayoutPreview(){
    TestTheme {
        CreateLayout (onContinueClicked = {})
    }
}

@Composable
fun CreateLayout(onContinueClicked: () -> Unit) {
    var shouldNextboarding by rememberSaveable { mutableStateOf(true) }

    Canvas(modifier = Modifier.fillMaxSize()) {
        val canvasWidth = size.width
        val canvasHeight = size.height

        drawCircle(
            color = Greenblue,
            center = Offset(x = (canvasWidth / 2)-300, y = (canvasHeight / 2)-120),
            radius = size.minDimension
        )
        drawCircle(
            color = Yellowlight,
            center = Offset(x = (canvasWidth / 2)+100, y = (canvasHeight/20)-100),
            radius = size.minDimension * 3 / 4
        )
//        drawCircle(
//            color = Orange,
//            center = Offset(x = (canvasWidth*3/4)+50, y = (canvasHeight*3/4)+260),
//            radius = size.minDimension / 3 /3
//        )
    }
    Column(modifier = Modifier.padding(horizontal = 50.dp, vertical = 100.dp)) {
        Text(text = "Create", color = Color.White, fontSize = 35.sp, fontWeight = FontWeight.Bold)
        Text(text = "Account", color = Color.White, fontSize = 35.sp, fontWeight = FontWeight.Bold)
    }
    Row(
        modifier = Modifier
            .padding(20.dp)
            .absoluteOffset(x = 180.dp, y = 0.dp)
    ){
        Text(
            modifier = Modifier.padding(horizontal = 15.dp),
            text = "Login",
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold)
        Text(text = "Create", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
    }
    Dataku()
    Row() {
        IconButton1(onClick = onContinueClicked) {
            Icon(
                imageVector = Icons.Rounded.ArrowForward,
                contentDescription = if (shouldNextboarding) {
                    CreateLayout(onContinueClicked = { shouldNextboarding = false })
                } else {
                    Login()
                }
            )
        }
    }

}

@Composable
fun Login() {

}

@Composable
private fun Dataku(){
    var name by remember { mutableStateOf("Enter Name") }
    var email by rememberSaveable { mutableStateOf("Enter Email") }
    var pass by rememberSaveable { mutableStateOf("Enter Password") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            modifier = Modifier.padding(8.dp),
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            textStyle = TextStyle(color = Color.White, fontWeight = FontWeight.Bold),
        )
        TextField(
            modifier = Modifier.padding(8.dp),
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            textStyle = TextStyle(color = Color.White, fontWeight = FontWeight.Bold),
        )
        TextField(
            modifier = Modifier.padding(8.dp),
            value = pass,
            onValueChange = { pass = it },
            label = { Text("Password") },
            textStyle = TextStyle(color = Color.Blue, fontWeight = FontWeight.Bold),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)

        )
    }
}
@Preview(showBackground = true)
@Composable
fun DatakuPreview(){
    Dataku()
}