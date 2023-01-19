package com.example.groupproject.view

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.groupproject.component.*
import com.example.groupproject.model.Item

@Composable
fun Category(navController: NavHostController, itemList: List<Item>) {
    LazyColumn {
        item {
            TopBarCategory(

            )
            Spacer(modifier = Modifier.height(8.dp))
        }
        items(itemList) {
            itemList.forEach {
                ItemCardLayout(
                    it,
                    onItemClicked = { item ->
                        navController.navigate("details/${item.id}/${item.name}/${item.location}")
                    }
                )
            }
        }
    }
}