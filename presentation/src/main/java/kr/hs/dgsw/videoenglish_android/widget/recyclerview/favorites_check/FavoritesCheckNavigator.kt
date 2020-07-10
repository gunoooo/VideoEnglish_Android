package kr.hs.dgsw.videoenglish_android.widget.recyclerview.favorites_check

import kr.hs.dgsw.domain.model.Favorites

interface FavoritesCheckNavigator {
    fun onCheckItem(favorites: Favorites, isChecked: Boolean)
}