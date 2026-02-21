package org.delcom.tatasurya_ifs23024.helper

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object SolarSystem : Screen("solar_system")
    object Galaxy : Screen("galaxy")
    object Detail : Screen("detail/{itemId}") {
        fun passId(itemId: Int): String = "detail/$itemId"
    }
}

object RouteHelper {
    const val ARG_ITEM_ID = "itemId"
}