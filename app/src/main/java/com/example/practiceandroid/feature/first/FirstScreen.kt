package com.example.practiceandroid.feature.first

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FirstScreen() {
    var inputText by remember {
        mutableStateOf("")
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(red = 1f, green = 0f, blue = 0f, alpha = 0.3f)
    ) {
        Column() {
            LazyRow(
                contentPadding = PaddingValues(
                    8.dp
                ), horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(textDataList.size) { index ->
                    TextCard(
                        title = textDataList[index].title, description = textDataList[index].text
                    )
                }
            }

            LazyColumn(
                modifier = Modifier.height(190.dp),
                contentPadding = PaddingValues(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(textDataList.size) { index ->
                    TextCard(
                        title = textDataList[index].title, description = textDataList[index].text
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            ) {
                Column() {
                    HeadAndComponent(heading = "AssistChip") {
                        AssistChip(
                            onClick = { },
                            label = { Text(text = "AssistChip") },
                            leadingIcon = {
                                Text(
                                    text = "\uD83D\uDE00"
                                )
                            },
                            trailingIcon = { Text(text = "\uD83D\uDE48") })
                    }
                    HeadAndComponent(heading = "TextField") {
                        TextField(value = inputText, onValueChange = {
                            inputText = it
                        }, label = {
                            Text(text = "Input String")
                        }, singleLine = true)
                    }
                }
            }
        }
    }
}

@Composable
fun HeadAndComponent(heading: String, content: @Composable () -> Unit) {
    Column {
        Text(text = heading)
        content()
    }
}

@Composable
fun TextCard(title: String, description: String) {
    Card(
        modifier = Modifier.fillMaxWidth(), elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = title, fontSize = 20.sp, fontWeight = FontWeight.Bold
            )
            Text(
                text = description, fontSize = 16.sp
            )
        }
    }
}

@Preview
@Composable
fun FirstScreenPreview() {
    FirstScreen()
}

data class TextData(
    val title: String, val text: String
)

val textDataList = listOf(
    TextData(
        title = "タイトル1", text = "テキスト1"
    ), TextData(
        title = "タイトル2", text = "テキスト2"
    ), TextData(
        title = "タイトル3", text = "テキスト3"
    ), TextData(
        title = "タイトル4", text = "テキスト4"
    ), TextData(
        title = "タイトル5", text = "テキスト5"
    ), TextData(
        title = "タイトル6", text = "テキスト6"
    ), TextData(
        title = "タイトル7", text = "テキスト7"
    )
)
