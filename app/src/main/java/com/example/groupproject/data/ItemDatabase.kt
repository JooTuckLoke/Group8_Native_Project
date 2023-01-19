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
package com.example.groupproject.data

import com.example.groupproject.R
import com.example.groupproject.model.Item
import com.example.groupproject.model.Owner

object ItemDatabase {
    val owner = Owner("See Pao Yeong", "Developer & Pet Lover", R.drawable.see)
    val itemList = listOf(
        Item(
            0,
            "Stereo Amplifier",
            "RM 500",
            "Audio",
            "389m away",
            R.drawable.audio_img_1,
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries,",
            "Good",
            "2020",
            owner
        ),
        Item(
            1,
            "Perfume",
            "RM 35",
            "Beauty & Personal Care",
            "412m away",
            R.drawable.beauty_img_1,
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries,",
            "Poor",
            "2023",
            owner
        ),
        Item(
            2,
            "Pot",
            "RM 250",
            "Furniture & Home Living",
            "879m away",
            R.drawable.furniture_img_1,
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries,",
            "Average",
            "2021",
            owner
        ),
        Item(
            3,
            "Polo Hat",
            "RM 15",
            "Men's fashion",
            "672m away",
            R.drawable.men_img_1,
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries,",
            "Good",
            "2022",
            owner
        ),
        Item(
            4,
            "Laptop Mantap",
            "RM2500",
            "Computers & Tech",
            "982m away",
            R.drawable.tech_img_1,
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries,",
            "Perfect",
            "2021",
            owner
        )
    )
}

