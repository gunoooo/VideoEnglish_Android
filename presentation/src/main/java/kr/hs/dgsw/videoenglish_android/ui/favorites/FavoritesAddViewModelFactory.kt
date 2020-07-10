package kr.hs.dgsw.videoenglish_android.ui.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kr.hs.dgsw.domain.usecase.favorites.InsertFavoritesUseCase
import javax.inject.Inject

open class FavoritesAddViewModelFactory @Inject constructor(
    private val insertFavoritesUseCase: InsertFavoritesUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        modelClass.getConstructor(
            InsertFavoritesUseCase::class.java
        ).newInstance(insertFavoritesUseCase)
}