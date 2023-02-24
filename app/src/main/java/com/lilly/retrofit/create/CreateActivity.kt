package com.lilly.retrofit.create

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lilly.retrofit.CustomOutlinedField
import com.lilly.retrofit.login.LoginActivity
import com.lilly.retrofit.main.MainActivity
import com.lilly.retrofit.ui.theme.RetrofitTheme

class CreateActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RetrofitTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CreateAccount(createVM = CreateVM())
                }
            }
        }
    }
}

@Composable
fun CreateAccount(createVM:CreateVM) {
    val context = LocalContext.current
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(40.dp),
    horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Create yor Account",
            fontSize = MaterialTheme.typography.h4.fontSize,
            fontFamily = FontFamily.Cursive )
        Spacer(modifier = Modifier.padding(20.dp))
        CustomOutlinedField(value = createVM.name,
            onValueChange = {createVM.onNameChange(it)},
            placeholder = "Name")
        Spacer(modifier = Modifier.padding(16.dp))
        CustomOutlinedField(value = createVM.email,
            onValueChange = {createVM.onEmailChange(it)},
            placeholder = "Email")
        Spacer(modifier = Modifier.padding(16.dp))
        CustomOutlinedField(value = createVM.password,
            onValueChange = {createVM.onPasswordChange(it)},
            placeholder = "Password",
            isPassword = true,
            isPasswordVisible =!createVM.isPasswordVisible,
            onVisibilityChange = {createVM.isPasswordVisible=it} )
        Spacer(modifier = Modifier.padding(20.dp))
        Button(onClick = { context.startActivity(Intent(context, MainActivity::class.java)) },
        Modifier.fillMaxWidth()) {
            Text(text = "REGISTER")
        }
        val annotation: AnnotatedString = buildAnnotatedString {
            val text = "Already registered? Login here"
            append(text)
            val start = text.indexOf("Login here")
            val end = start + "Login here".length

            addStyle(
                SpanStyle(
                    color = Color.Blue,
                    textDecoration = TextDecoration.Underline
                ),start, end
            )
        }
        ClickableText(text = annotation,
            onClick = {context.startActivity(Intent(context,LoginActivity::class.java))})
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RetrofitTheme {
        CreateAccount(createVM = CreateVM())
    }
}