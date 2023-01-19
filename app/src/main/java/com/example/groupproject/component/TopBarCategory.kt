package com.example.groupproject.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.groupproject.R

@Composable
fun TopBarCategory() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Category Tab",
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.h5,
                color = MaterialTheme.colors.surface
            )

            Spacer(modifier = Modifier.height(8.dp))


            ScrollableTabRow(
                selectedTabIndex = 0,

                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(8.dp),
                backgroundColor = Color.White,
                contentColorFor(backgroundColor = Color.White),
                edgePadding = 0.dp
                )
            {
                Button(

                    onClick = { /* Do something! */ },
                    modifier = Modifier
                        .padding(8.dp)
                        .defaultMinSize(minWidth = 8.dp, minHeight = 1.dp),
                    colors = ButtonDefaults.textButtonColors(
                        backgroundColor = colorResource(id = R.color.blue),
                        contentColor = Color.White
                    )

                ) {
                    Text("All")
                }

                Button(

                    onClick = { /* Do something! */ },
                    modifier = Modifier
                        .padding(8.dp)
                        .defaultMinSize(minWidth = 8.dp, minHeight = 1.dp),
                    colors = ButtonDefaults.textButtonColors(
                        backgroundColor = colorResource(id = R.color.blue),
                        contentColor = Color.White
                    )

                ) {
                    Text("Audio Products")
                }
                Button(
                    onClick = { /* Do something! */ },
                    modifier = Modifier
                        .padding(8.dp)
                        .defaultMinSize(minWidth = 8.dp, minHeight = 1.dp),
                    colors = ButtonDefaults.textButtonColors(
                        backgroundColor = colorResource(id = R.color.blue),
                        contentColor = Color.White
                    )
                ) {
                    Text("Beauty & Personal Care")
                }
                Button(
                    onClick = { /* Do something! */ },
                    modifier = Modifier
                        .padding(8.dp)
                        .defaultMinSize(minWidth = 8.dp, minHeight = 1.dp),
                    colors = ButtonDefaults.textButtonColors(
                        backgroundColor = colorResource(id = R.color.blue),
                        contentColor = Color.White
                    )
                ) {
                    Text("Computer & Technology")
                }
                Button(
                    onClick = { /* Do something! */ },
                    modifier = Modifier
                        .padding(8.dp)
                        .defaultMinSize(minWidth = 8.dp, minHeight = 1.dp),
                    colors = ButtonDefaults.textButtonColors(
                        backgroundColor = colorResource(id = R.color.blue),
                        contentColor = Color.White
                    )
                ) {
                    Text("Furniture & Home Living")
                }
                Button(
                    onClick = { /* Do something! */ },
                    modifier = Modifier
                        .padding(8.dp)
                        .defaultMinSize(minWidth = 8.dp, minHeight = 1.dp),
                    colors = ButtonDefaults.textButtonColors(
                        backgroundColor = colorResource(id = R.color.blue),
                        contentColor = Color.White
                    )
                ) {
                    Text("Men's Fashion")
                }
            }
        }
    }
}