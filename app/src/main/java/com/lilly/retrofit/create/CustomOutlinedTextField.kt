package com.lilly.retrofit

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun CustomOutlinedField(
    value: String,
    onValueChange: (String)->Unit,
    placeholder: String,
    isPassword: Boolean = false,
    isPasswordVisible: Boolean = false,
    onVisibilityChange: (Boolean) -> Unit = {},
    //label: String
){
    Column() {
        OutlinedTextField(
            value = value,
            onValueChange = {onValueChange(it)},
            placeholder = {Text(text = placeholder)},
            trailingIcon = {
                if(isPassword){
                    IconButton(onClick = { onVisibilityChange(isPasswordVisible) }) {
                        Icon(imageVector = if(isPasswordVisible) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                            contentDescription = "Toggle Icon")
                    }
                }
            },
            visualTransformation = when{
                isPassword && isPasswordVisible -> VisualTransformation.None
                isPassword -> PasswordVisualTransformation()
                else -> VisualTransformation.None
            }
            //label = label
        )
    }
}