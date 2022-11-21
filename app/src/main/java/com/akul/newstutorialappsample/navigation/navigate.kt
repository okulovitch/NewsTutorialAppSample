package com.akul.newstutorialappsample.navigation

import androidx.navigation.NavController
import com.akul.core.util.UiEvent

fun NavController.navigate(event: UiEvent.Navigate) {
    this.navigate(event.route)
}