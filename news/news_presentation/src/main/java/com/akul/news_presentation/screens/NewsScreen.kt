package com.akul.news_presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.akul.core.navigate.Route
import com.akul.core.util.UiEvent
import com.akul.core_ui.LocalSpacing
import com.akul.news_presentation.components.ActionButton

@Composable
fun NewsScreen(
    onNavigate: (UiEvent.Navigate) -> Unit
) {
    val spacing = LocalSpacing.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(spacing.spaceMedium),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = com.akul.core.R.string.app_name),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h1
        )
        Spacer(modifier = Modifier.height(spacing.spaceMedium))
        ActionButton(
            text = stringResource(id = com.akul.core.R.string.next),
            onClick = { onNavigate(UiEvent.Navigate(Route.NEWS_FULL_INFO)) },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}