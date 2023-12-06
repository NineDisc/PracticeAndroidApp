package com.example.practiceandroid.feature.second

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.practiceandroid.R
import com.example.practiceandroid.ui.PracticeIcon

@Composable
fun SecondScreen() {
    val openDialog = remember {
        mutableStateOf(false)
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(red = 0f, green = 0f, blue = 1f, alpha = 0.3f)
    ) {
        Column(verticalArrangement = Arrangement.Center) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Button(onClick = {
                    openDialog.value = true
                }) {
                    Text(text = "button")
                }
            }
            when {
                openDialog.value -> SecondDialog(onDismissRequest = { openDialog.value = false })
            }

        }
    }
}

@Composable
fun SecondDialog(onDismissRequest: () -> Unit) {
    Dialog(onDismissRequest = { onDismissRequest() }) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,

                modifier = Modifier.fillMaxSize()
            ) {
                Row(modifier = Modifier.align(Alignment.End)) {
                    IconButton(onClick = { onDismissRequest() }) {
                        Icon(imageVector = PracticeIcon.Close, contentDescription = "")
                    }
                }
                Image(
                    painter = painterResource(id = R.drawable.preview_mountain),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Dialog",
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Preview
@Composable
fun SecondScreenPreview() {
    SecondScreen()
}

@Preview
@Composable
fun SecondDialogPreview() {
    SecondDialog {}
}