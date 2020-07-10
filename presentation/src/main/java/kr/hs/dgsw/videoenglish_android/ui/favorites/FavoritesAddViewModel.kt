package kr.hs.dgsw.videoenglish_android.ui.favorites

import androidx.lifecycle.MutableLiveData
import io.reactivex.observers.DisposableCompletableObserver
import kr.hs.dgsw.domain.usecase.favorites.InsertFavoritesUseCase
import kr.hs.dgsw.videoenglish_android.base.viewmodel.BaseViewModel
import kr.hs.dgsw.videoenglish_android.widget.SingleLiveEvent

class FavoritesAddViewModel(
    private val insertFavoritesUseCase: InsertFavoritesUseCase
) : BaseViewModel() {

    val title = MutableLiveData<String>()

    val onSuccessInsertEvent = SingleLiveEvent<Unit>()
    val onEmptyEvent = SingleLiveEvent<Unit>()
    val onBackEvent = SingleLiveEvent<Unit>()

    private fun insertFavorites() {
        addDisposable(insertFavoritesUseCase.buildUseCaseObservable(InsertFavoritesUseCase.Params(title.value!!)),
            object : DisposableCompletableObserver() {
                override fun onComplete() {
                    onSuccessInsertEvent.call()
                }

                override fun onError(e: Throwable) {
                    setOnErrorEvent(e)
                }
            })
    }

    fun onClickBack() = onBackEvent.call()

    fun onClickApply() {
        if (title.value.isNullOrBlank())
            onEmptyEvent.call()
        else
            insertFavorites()
    }
}