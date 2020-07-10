package kr.hs.dgsw.videoenglish_android.ui.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gunwoo.karaoke.domain.usecase.favorites.InsertFavoritesItemUseCase
import kr.hs.dgsw.domain.usecase.favorites.DeleteFavoritesItemUseCase
import kr.hs.dgsw.domain.usecase.favorites.GetFavoritesListUseCase
import javax.inject.Inject

open class FavoritesBottomSheetViewModelFactory @Inject constructor(
        private val getFavoritesListUseCase: GetFavoritesListUseCase,
        private val insertFavoritesItemUseCase: InsertFavoritesItemUseCase,
        private val deleteFavoritesItemUseCase: DeleteFavoritesItemUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        modelClass.getConstructor(
            GetFavoritesListUseCase::class.java,
            InsertFavoritesItemUseCase::class.java,
            DeleteFavoritesItemUseCase::class.java
        ).newInstance(getFavoritesListUseCase, insertFavoritesItemUseCase, deleteFavoritesItemUseCase)
}