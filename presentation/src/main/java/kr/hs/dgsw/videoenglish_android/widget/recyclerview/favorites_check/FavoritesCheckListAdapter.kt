package kr.hs.dgsw.videoenglish_android.widget.recyclerview.favorites_check

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import kr.hs.dgsw.domain.model.Favorites
import kr.hs.dgsw.videoenglish_android.R
import kr.hs.dgsw.videoenglish_android.databinding.ItemFavoritesCheckBinding
import kr.hs.dgsw.videoenglish_android.widget.SingleLiveEvent

class FavoritesCheckListAdapter(private val favoritesList: List<Favorites>) :
    Adapter<FavoritesCheckListAdapter.FavoritesCheckItemViewHolder>(),
        FavoritesCheckNavigator {

    val onCheckFavoritesEvent = SingleLiveEvent<Favorites>()
    val onUncheckFavoritesEvent = SingleLiveEvent<Favorites>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesCheckItemViewHolder {
        return FavoritesCheckItemViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_favorites_check, parent, false))
    }

    override fun onBindViewHolder(holder: FavoritesCheckItemViewHolder, position: Int) {
        holder.bind(favoritesList[position])
    }

    override fun onCheckItem(favorites: Favorites, isChecked: Boolean) {
        val position = favoritesList.indexOf(favorites)
        favoritesList[position].isContained = isChecked
        notifyItemChanged(position)

        if (isChecked)
            onCheckFavoritesEvent.value = favorites
        else
            onUncheckFavoritesEvent.value = favorites
    }

    override fun getItemCount(): Int {
        return favoritesList.size
    }

    inner class FavoritesCheckItemViewHolder(val binding: ItemFavoritesCheckBinding) : RecyclerView.ViewHolder(binding.root) {

        private val viewModel = FavoritesCheckItemViewModel()

        fun bind(data: Favorites) {
            viewModel.bind(data)
            viewModel.setNavigator(this@FavoritesCheckListAdapter)
            binding.viewModel = viewModel
        }
    }
}