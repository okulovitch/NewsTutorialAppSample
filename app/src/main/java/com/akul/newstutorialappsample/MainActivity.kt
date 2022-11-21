package com.akul.newstutorialappsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.akul.core.navigate.Route
import com.akul.news_presentation.screens.NewsScreen
import com.akul.newstutorialappsample.navigation.navigate
import com.akul.newstutorialappsample.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Route.NEWS_DEFAULT
                ) {
                    composable(Route.NEWS_DEFAULT) {
                        NewsScreen(onNavigate = navController::navigate)
                    }
                    composable(Route.NEWS_HOT) {

                    }
                    composable(Route.NEWS_FULL_INFO) {

                    }
                    composable(Route.NEWS_HOT_INFO) {

                    }
                    composable(Route.SEARCH) {

                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

}