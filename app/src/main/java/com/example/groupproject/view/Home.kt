/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.groupproject.view

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.groupproject.component.ItemCardLayout
import com.example.groupproject.component.TopBar
import com.example.groupproject.model.Item

@Composable
fun Home(navController: NavHostController, itemList: List<Item>) {
    LazyColumn {
        item {
            TopBar()
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



