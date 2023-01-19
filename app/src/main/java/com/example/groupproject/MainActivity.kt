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
package com.example.groupproject


import BottomBarMain
import BottomNavigationBar
import android.app.Application
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.groupproject.data.Inventory
import com.example.groupproject.ui.theme.MyTheme
import com.example.groupproject.data.InventoryViewModel
@ExperimentalAnimationApi
class MainActivity : AppCompatActivity() {
    //private lateinit var viewModel: InventoryViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //viewModel = ViewModelProvider(this).get(InventoryViewModel::class.java)
        setContent {

            MyTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

                    val owner = LocalViewModelStoreOwner.current

                    owner?.let {
                        val viewModel: InventoryViewModel = viewModel(
                            it,
                            "MainViewModel",
                            InventoryViewModelFactory(
                                LocalContext.current.applicationContext
                                        as Application
                            )
                        )




                     MainView()
                        ScreenSetup(viewModel)

                    }
                }
            }
        }


    }


    class InventoryViewModelFactory(val application: Application) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return InventoryViewModel(application) as T
        }
    }



    @Composable
    fun ScreenSetup(viewModel: InventoryViewModel) {

        val allProducts by viewModel.allInventories.observeAsState(listOf())
        val searchResults by viewModel.searchResults.observeAsState(listOf())

        MainScreen(
            allProducts = allProducts,
            searchResults = searchResults,
            viewModel = viewModel
        )
    }

    @Composable fun MainScreen(
        allProducts: List<Inventory>,
        searchResults: List<Inventory>,
        viewModel: InventoryViewModel
    ) {
        var productName by remember { mutableStateOf("") }
        var productQuantity by remember { mutableStateOf("") }
        var searching by remember { mutableStateOf(false) }

        val onProductTextChange = { text: String ->
            productName = text
        }

        val onQuantityTextChange = { text: String ->
            productQuantity = text
        }
    }
}

@Composable
fun MainView() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) },
        content = { padding -> // We have to pass the scaffold inner padding to our content. That's why we use Box.
            Box(modifier = Modifier.padding(padding)) {
                BottomBarMain(navController = navController)
            }
        }
    )
}


