package com.nikita.rustoremvp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.nikita.rustoremvp.presentation.categories.CategoriesScreen  // ← ДОБАВЬ ЭТОТ ИМПОРТ
import com.nikita.rustoremvp.presentation.detail.AppDetailScreen
import com.nikita.rustoremvp.presentation.onboarding.OnboardingScreen
import com.nikita.rustoremvp.presentation.store.AppStoreScreen

sealed class Screen(val route: String) {
    object Onboarding : Screen("onboarding")
    object Store : Screen("store")
    object Categories : Screen("categories")
    object Detail : Screen("detail/{appId}") {
        fun createRoute(appId: String) = "detail/$appId"
    }
    object Screenshots : Screen("screenshots/{appId}/{initialIndex}") {  // ← НОВЫЙ ЭКРАН
        fun createRoute(appId: String, initialIndex: Int) = "screenshots/$appId/$initialIndex"
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Onboarding.route
    ) {
        composable(Screen.Onboarding.route) {
            OnboardingScreen(
                onFinish = {
                    navController.navigate(Screen.Store.route) {
                        popUpTo(Screen.Onboarding.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable(Screen.Store.route) {
            AppStoreScreen(
                onAppClick = { app ->
                    navController.navigate(Screen.Detail.createRoute(app.id))
                },
                onCategoriesClick = {
                    navController.navigate(Screen.Categories.route)  // ← ПЕРЕХОД К КАТЕГОРИЯМ
                }
            )
        }

        composable(Screen.Categories.route) {  // ← ДОБАВЬ ЭТОТ ЭКРАН
            CategoriesScreen(
                onCategoryClick = { categoryName ->
                    // Пока просто возвращаемся назад
                    // Можно добавить фильтрацию по категории
                    navController.popBackStack()
                },
                onBack = { navController.popBackStack() }
            )
        }

        composable(
            route = Screen.Detail.route,
            arguments = listOf(navArgument("appId") { type = NavType.StringType })
        ) { backStackEntry ->
            val appId = backStackEntry.arguments?.getString("appId") ?: ""
            AppDetailScreen(
                appId = appId,
                onBack = { navController.popBackStack() }
            )
        }
    }
}