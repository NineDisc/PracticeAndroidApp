package com.example.practiceandroid.feature.first

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FirstScreen() {
    //TODO 実装
    Surface(modifier = Modifier
        .fillMaxSize()
        .padding(bottom = 80.dp), color = Color.Red) {
        Column {
            LazyRow {
                items(textDataList.size) { index ->
                    TextCard(
                        title = textDataList[index].title,
                        description = textDataList[index].text
                    )
                }
            }

            LazyColumn {
                items(textDataList.size) { index ->
                    TextCard(
                        title = textDataList[index].title,
                        description = textDataList[index].text
                    )

                }
            }
        }

    }
}

@Composable
fun TextCard(title: String, description: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = description,
                fontSize = 16.sp
            )
        }
    }
}

data class TextData(
    val title: String,
    val text: String
)

val textDataList = listOf(
    TextData(
        title = "タイトル1",
        text = "テキスト1"
    ),
    TextData(
        title = "タイトル2",
        text = "テキスト2"
    ),
    TextData(
        title = "タイトル3",
        text = "テキスト3"
    ),
    TextData(
        title = "タイトル4",
        text = "テキスト4"
    ),
    TextData(
        title = "タイトル5",
        text = "テキスト5"
    ),
    TextData(
        title = "タイトル6",
        text = "テキスト6"
    ),
    TextData(
        title = "タイトル7",
        text = "テキスト7"
    )
)
