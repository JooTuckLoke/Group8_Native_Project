package com.example.groupproject.navigation

import androidx.annotation.StringRes
import com.example.groupproject.R

sealed class NavigationItems(var route: String, var icon: Int, var title: String) {
    object Home : NavigationItems("home", R.drawable.home_icon, "Home")
    object Category : NavigationItems("searchPage", R.drawable.search_icon, "Category")
    object Wishlist : NavigationItems("wishlist", R.drawable.wishlist_icon, "Wishlist")
}

sealed class Screen(val route: String, @StringRes val resourceId: Int) {
    object Details : Screen("details", R.string.text_details)
}
