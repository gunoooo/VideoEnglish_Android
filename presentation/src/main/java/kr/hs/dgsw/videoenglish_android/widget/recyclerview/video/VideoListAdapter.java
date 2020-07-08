package kr.hs.dgsw.videoenglish_android.widget.recyclerview.video;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import io.reactivex.Single;
import kr.hs.dgsw.domain.model.YoutubeData;
import kr.hs.dgsw.videoenglish_android.R;
import kr.hs.dgsw.videoenglish_android.databinding.ItemVideoBinding;
import kr.hs.dgsw.videoenglish_android.databinding.ItemVideoHorizontalBinding;
import kr.hs.dgsw.videoenglish_android.widget.SingleLiveEvent;

public class VideoListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
        implements VideoNavigator {

    private List<YoutubeData> youtubeDataList;
    private VideoViewType videoViewType;

    private SingleLiveEvent<YoutubeData> onClickItemEvent = new SingleLiveEvent<>();
    public LiveData<YoutubeData> getOnClickItemEvent() {
        return onClickItemEvent;
    }
    @Override
    public void onClickItem(YoutubeData youtubeData) {
        onClickItemEvent.setValue(youtubeData);
    }
    private SingleLiveEvent<YoutubeData> onAddFavoritesEvent = new SingleLiveEvent<>();
    public LiveData<YoutubeData> getOnAddFavoritesEvent() {
        return onAddFavoritesEvent;
    }
    @Override
    public void onAddFavorites(YoutubeData youtubeData) {
        onAddFavoritesEvent.setValue(youtubeData);
    }
    private SingleLiveEvent<YoutubeData> onDeleteFavoritesEvent = new SingleLiveEvent<>();
    public LiveData<YoutubeData> getOnDeleteFavoritesEvent() {
        return onDeleteFavoritesEvent;
    }
    @Override
    public void onDeleteFavorites(YoutubeData youtubeData) {
        onDeleteFavoritesEvent.setValue(youtubeData);
    }
    private SingleLiveEvent<YoutubeData> onHideEvent = new SingleLiveEvent<>();
    public LiveData<YoutubeData> getOnHideEvent() {
        return onHideEvent;
    }
    @Override
    public void onHide(YoutubeData youtubeData) {
        onHideEvent.setValue(youtubeData);
    }
    private SingleLiveEvent<YoutubeData> onDeleteHidingEvent = new SingleLiveEvent<>();
    public LiveData<YoutubeData> getOnDeleteHidingEvent() {
        return onDeleteHidingEvent;
    }
    @Override
    public void onDeleteHiding(YoutubeData youtubeData) {
        onDeleteHidingEvent.setValue(youtubeData);
    }
    private SingleLiveEvent<YoutubeData> onOpenYoutubeEvent = new SingleLiveEvent<>();
    public LiveData<YoutubeData> getOnOpenYoutubeEvent() {
        return onOpenYoutubeEvent;
    }
    @Override
    public void onOpenYoutube(YoutubeData youtubeData) {
        onOpenYoutubeEvent.setValue(youtubeData);
    }
    private SingleLiveEvent<YoutubeData> onShareEvent = new SingleLiveEvent<>();
    public LiveData<YoutubeData> getOnShareEvent() {
        return onShareEvent;
    }
    @Override
    public void onShare(YoutubeData youtubeData) {
        onShareEvent.setValue(youtubeData);
    }

    public VideoListAdapter(List<YoutubeData> youtubeDataList, VideoViewType videoViewType) {
        this.youtubeDataList = youtubeDataList;
        this.videoViewType = videoViewType;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return videoViewType == VideoViewType.HORIZONTAL_FAVORITES ||
                videoViewType == VideoViewType.HORIZONTAL_NORMAL ?
                new VideoHorizontalItemViewHolder(
                        DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                                R.layout.item_video_horizontal, parent, false))
                : new VideoItemViewHolder(DataBindingUtil.inflate(
                        LayoutInflater.from(parent.getContext()),
                                R.layout.item_video, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof VideoItemViewHolder)
            ((VideoItemViewHolder) holder).bind(youtubeDataList.get(position));
        else if (holder instanceof VideoHorizontalItemViewHolder)
            ((VideoHorizontalItemViewHolder) holder).bind(youtubeDataList.get(position));
    }

    @Override
    public int getItemCount() {
        return youtubeDataList.size();
    }

    class VideoItemViewHolder extends RecyclerView.ViewHolder {

        private ItemVideoBinding binding;
        private VideoItemViewModel viewModel = new VideoItemViewModel();

        VideoItemViewHolder(ItemVideoBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(YoutubeData data) {
            viewModel.bind(data, videoViewType);
            viewModel.setNavigator(VideoListAdapter.this);
            binding.setViewModel(viewModel);
        }
    }

    class VideoHorizontalItemViewHolder extends RecyclerView.ViewHolder {

        private ItemVideoHorizontalBinding binding;
        private VideoItemViewModel viewModel = new VideoItemViewModel();

        VideoHorizontalItemViewHolder(ItemVideoHorizontalBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(YoutubeData data) {
            viewModel.bind(data, videoViewType);
            viewModel.setNavigator(VideoListAdapter.this);
            binding.setViewModel(viewModel);
        }
    }
}
