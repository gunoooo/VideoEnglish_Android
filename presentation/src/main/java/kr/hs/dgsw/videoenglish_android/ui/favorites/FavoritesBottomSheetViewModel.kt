package kr.hs.dgsw.videoenglish_android.ui.favorites

import com.gunwoo.karaoke.domain.usecase.favorites.InsertFavoritesItemUseCase
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.observers.DisposableSingleObserver
import kr.hs.dgsw.domain.model.Favorites
import kr.hs.dgsw.domain.model.YoutubeData
import kr.hs.dgsw.domain.usecase.favorites.DeleteFavoritesItemUseCase
import kr.hs.dgsw.domain.usecase.favorites.GetFavoritesListUseCase
import kr.hs.dgsw.videoenglish_android.base.viewmodel.BaseViewModel
import kr.hs.dgsw.videoenglish_android.widget.SingleLiveEvent
import kr.hs.dgsw.videoenglish_android.widget.recyclerview.favorites_check.FavoritesCheckListAdapter

class FavoritesBottomSheetViewModel(
        private val getFavoritesListUseCase: GetFavoritesListUseCase,
        private val insertFavoritesItemUseCase: InsertFavoritesItemUseCase,
        private val deleteFavoritesItemUseCase: DeleteFavoritesItemUseCase
) : BaseViewModel() {

    lateinit var youtubeData: YoutubeData

    val favoritesList = ArrayList<Favorites>()

    val favoritesCheckListAdapter = FavoritesCheckListAdapter(favoritesList)

    val onOpenFavoritesAddViewEvent = SingleLiveEvent<Unit>()
    val onCloseEvent = SingleLiveEvent<Unit>()

    fun setFavoritesList() {
        addDisposable(getFavoritesListUseCase.buildUseCaseObservable(GetFavoritesListUseCase.Params(youtubeData.videoId)),
            object : DisposableSingleObserver<List<Favorites>>() {
                override fun onSuccess(t: List<Favorites>) {
                    favoritesList.clear()
                    favoritesList.addAll(t)
                    favoritesCheckListAdapter.notifyDataSetChanged()
                }

                override fun onError(e: Throwable) {
                    setOnErrorEvent(e)
                }
            })
    }

    fun insertFavoritesItem(favoritesId: Int) {
        addDisposable(insertFavoritesItemUseCase.buildUseCaseObservable(InsertFavoritesItemUseCase.Params(youtubeData, favoritesId)),
            object : DisposableCompletableObserver() {
                override fun onComplete() { }

                override fun onError(e: Throwable) {
                    setOnErrorEvent(e)
                }
            })
    }

    fun deleteFavoritesItem(favoritesId: Int) {
        addDisposable(deleteFavoritesItemUseCase.buildUseCaseObservable(DeleteFavoritesItemUseCase.Params(youtubeData, favoritesId)),
            object : DisposableCompletableObserver() {
                override fun onComplete() { }

                override fun onError(e: Throwable) {
                    setOnErrorEvent(e)
                }
            })
    }

    fun onClickClose() { onCloseEvent.call() }

    fun onClickAddFavorites() { onOpenFavoritesAddViewEvent.call() }
}