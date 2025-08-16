package com.example.whatsapp.presentation.userregistrationscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsapp.R

@Composable
@Preview(showSystemUi = true)
fun UserRegistrationComposable() {

    /*
    ever value selected in the dropdown needs to be tracked in a state variable
    */
    var expanded by remember {
        mutableStateOf(false)
    }
    var selectedCountry by remember {
        mutableStateOf("India")
    }

    var countryCode by remember {
        mutableStateOf("+91")
    }

    var phoneNumber by remember {
        mutableStateOf("")
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Enter your phone number",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(R.color.wp_dark_green),
            modifier = Modifier.padding(top = 32.dp)
        )

        Text(
            text = buildAnnotatedString {
                append("WhatsApp will need to verify your phone number.  ")

                withStyle(
                    style = SpanStyle(
                        color = colorResource(R.color.wp_dark_green),
                        fontWeight = FontWeight.Normal
                    )
                ) {
                    append("What's\n my number?")
                }
            },
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp),

        )

        //text button for dropdown
        TextButton(onClick = { expanded = true }, modifier = Modifier.fillMaxWidth()) {
            Text(
                text = selectedCountry,
                fontSize = 16.sp,
                color = Color.Black
            )

            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = null,
                tint = colorResource(R.color.wp_dark_green)
            )
        }

        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 64.dp),
            thickness = 2.dp,
            color = colorResource(R.color.wp_light_green)
        )

        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }, modifier = Modifier.fillMaxWidth()) {
            listOf("India", "Nepal", "Bhutan", "Sri Lanka", "Bangladesh").forEach { country ->
                DropdownMenuItem(text = { Text(text = country) }, onClick = {
                    selectedCountry = country
                    expanded = false
                })
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp, vertical = 16.dp), // padding from edges
            horizontalArrangement = Arrangement.spacedBy(16.dp) // used to add space between fields
        ) {
            TextField(
                value = countryCode,
                onValueChange = { countryCode = it },
                modifier = Modifier.width(70.dp),
                singleLine = true,
                textStyle = LocalTextStyle.current.copy(fontSize = 16.sp),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent,
                    unfocusedIndicatorColor = colorResource(R.color.wp_light_green),
                    focusedIndicatorColor = colorResource(R.color.wp_light_green)
                )
            )

            TextField(
                value = phoneNumber,
                onValueChange = { phoneNumber = it },
                placeholder = { Text(text = "Phone number") },
                singleLine = true,
                textStyle = LocalTextStyle.current.copy(fontSize = 16.sp),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent,
                    unfocusedIndicatorColor = colorResource(R.color.wp_light_green),
                    focusedIndicatorColor = colorResource(R.color.wp_light_green)
                ),
                modifier = Modifier.weight(1f) // phone number takes the remaining space
            )
        }

        Text(
            text = "Carrier charges may apply",
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
        )

        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .padding(horizontal = 64.dp, vertical = 16.dp),
            shape = RoundedCornerShape(4.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(R.color.wp_dark_green)
            )
        ) {
            Text(text = "Next", fontSize = 16.sp)
        }
    }
}
