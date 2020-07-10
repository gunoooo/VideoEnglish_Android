package kr.hs.dgsw.videoenglish_android.widget.recyclerview.favorites_check

import androidx.lifecycle.MutableLiveData
import kr.hs.dgsw.domain.model.Favorites
import kr.hs.dgsw.videoenglish_android.base.viewmodel.BaseItemViewModel

class FavoritesCheckItemViewModel : BaseItemViewModel<FavoritesCheckNavigator>() {

    private lateinit var favorites: Favorites

    val thumbnail = MutableLiveData<String>()
    val title = MutableLiveData<String>()
    val isChecked = MutableLiveData<Boolean>()

    fun bind(data: Favorites) {
        favorites = data

        thumbnail.value = if (favorites.favoritesItemList.isNullOrEmpty()) null else favorites.favoritesItemList!![0].thumbnailUrl
        title.value = favorites.title
        isChecked.value = favorites.isContained
    }

    fun onClickItem() {
        isChecked.value = !isChecked.value!!
        getNavigator().onCheckItem(favorites, isChecked.value!!)
    }
}