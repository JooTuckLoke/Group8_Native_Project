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
package com.example.groupproject.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.groupproject.R

@Composable
fun CategoryTag(name: String) {
    val color = if (name == "Computers & Tech") R.color.blue
    else if (name == "Men's fashion") R.color.red
    else if (name == "Beauty & Personal Care") R.color.pink
    else if (name == "Furniture & Home Living") R.color.yellow
    else if (name == "Audio") R.color.green
    else R.color.purple_700
    ChipView(category = name, colorResource = colorResource(id = color))
}

@Composable
fun ChipView(category: String, colorResource: Color) {
    Box(
        modifier = Modifier
            .wrapContentWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(colorResource.copy(.08f))
    ) {
        Text(
            text = category,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(12.dp, 6.dp, 12.dp, 6.dp).align(Alignment.Center),
            style = MaterialTheme.typography.caption,
            color = colorResource
        )
    }
}
