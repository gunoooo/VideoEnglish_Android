package kr.hs.dgsw.videoenglish_android.widget.recyclerview.favorites;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import kr.hs.dgsw.domain.model.Favorites;
import kr.hs.dgsw.videoenglish_android.R;
import kr.hs.dgsw.videoenglish_android.databinding.ItemFavoritesBinding;
import kr.hs.dgsw.videoenglish_android.widget.SingleLiveEvent;

public class FavoritesListAdapter extends RecyclerView.Adapter<FavoritesListAdapter.FavoritesItemViewHolder>
        implements FavoritesNavigator {

    private List<Favorites> favoritesList;

    private SingleLiveEvent<Favorites> onClickItemEvent = new SingleLiveEvent<>();
    public LiveData<Favorites> getOnClickItemEvent() {
        return onClickItemEvent;
    }
    @Override
    public void onClickItem(Favorites favorites) {
        onClickItemEvent.setValue(favorites);
    }
    private SingleLiveEvent<Favorites> onPlayEvent = new SingleLiveEvent<>();
    public LiveData<Favorites> getOnPlayEvent() {
        return onPlayEvent;
    }
    @Override
    public void onPlay(Favorites favorites) {
        onPlayEvent.setValue(favorites);
    }
    private SingleLiveEvent<Favorites> onFixTitleEvent = new SingleLiveEvent<>();
    public LiveData<Favorites> getOnFixTitleEvent() {
        return onFixTitleEvent;
    }
    @Override
    public void onFixTitle(Favorites favorites) {
        onFixTitleEvent.setValue(favorites);
    }
    private SingleLiveEvent<Favorites> onDeleteEvent = new SingleLiveEvent<>();
    public LiveData<Favorites> getOnDeleteEvent() {
        return onDeleteEvent;
    }
    @Override
    public void onDelete(Favorites favorites) {
        onDeleteEvent.setValue(favorites);
    }

    public FavoritesListAdapter(List<Favorites> favoritesList) {
        this.favoritesList = favoritesList;
    }

    @NonNull
    @Override
    public FavoritesItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FavoritesItemViewHolder(
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.item_favorites, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FavoritesItemViewHolder holder, int position) {
        holder.bind(favoritesList.get(position));
    }

    @Override
    public int getItemCount() {
        return favoritesList.size();
    }

    class FavoritesItemViewHolder extends RecyclerView.ViewHolder {

        private ItemFavoritesBinding binding;
        private FavoritesItemViewModel viewModel = new FavoritesItemViewModel();

        FavoritesItemViewHolder(ItemFavoritesBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(Favorites data) {
            viewModel.bind(data);
            viewModel.setNavigator(FavoritesListAdapter.this);
            binding.setViewModel(viewModel);
        }
    }
}
