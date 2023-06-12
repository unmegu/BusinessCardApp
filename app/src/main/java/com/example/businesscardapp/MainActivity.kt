package com.example.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Alignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardHoge()
                }
            }
        }
    }
}

@Composable
fun BusinessCardImage(name :String, belongTo :String){
    val image = painterResource(R.drawable.android_logo)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(
                    top = 100.dp
                )
                .size(150.dp)
        )
        Text(
            text = name,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(
                    top = 0.dp
                )
        )
        Text(
            text = belongTo,
            fontSize = 16.sp,
            modifier = Modifier
                .padding(
                    all = 4.dp
                )
        )
    }

}

@Composable
fun ContactText(@DrawableRes id:Int, contact :String){
    Row(
    ) {
        Image (
            painter = painterResource(id),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(30.dp)
                .padding(all = 4.dp)
        )
        Text(
            text = contact
        )
    }
}

@Composable
fun ContactTextList() {
    Column(
        modifier = Modifier.padding(top =100.dp),
    ){
        ContactText(id = R.drawable.android_logo, contact = "Github: @unmegu")
        ContactText(id = R.drawable.android_logo, contact = "Mail: g2123011@fun.ac.jp")
        ContactText(id = R.drawable.android_logo, contact = "hogehogehoge")
    }
}

@Composable
fun BusinessCardHoge(){
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally

            ) {
        BusinessCardImage(name = "Megumi Unno", belongTo = "HakodateSweets")
        ContactTextList()
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardAppTheme {
        BusinessCardHoge()
    }
}