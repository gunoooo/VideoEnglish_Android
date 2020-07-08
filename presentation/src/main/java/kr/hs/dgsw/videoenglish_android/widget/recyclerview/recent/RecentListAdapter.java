package kr.hs.dgsw.videoenglish_android.widget.recyclerview.recent;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import kr.hs.dgsw.domain.model.YoutubeData;
import kr.hs.dgsw.videoenglish_android.R;
import kr.hs.dgsw.videoenglish_android.databinding.ItemRecentBinding;
import kr.hs.dgsw.videoenglish_android.widget.SingleLiveEvent;

public class RecentListAdapter extends RecyclerView.Adapter<RecentListAdapter.RecentItemViewHolder>
        implements RecentNavigator {

    private List<YoutubeData> youtubeDataList;

    private SingleLiveEvent<YoutubeData> onClickItemEvent = new SingleLiveEvent<>();
    public LiveData<YoutubeData> getOnClickItemEvent() {
        return onClickItemEvent;
    }
    @Override
    public void onClickItem(YoutubeData youtubeData) {
        onClickItemEvent.setValue(youtubeData);
    }

    public RecentListAdapter(List<YoutubeData> youtubeDataList) {
        this.youtubeDataList = youtubeDataList;
    }

    @NonNull
    @Override
    public RecentListAdapter.RecentItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecentItemViewHolder(
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.item_recent, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecentListAdapter.RecentItemViewHolder holder, int position) {
        holder.bind(youtubeDataList.get(position));
    }

    @Override
    public int getItemCount() {
        return youtubeDataList.size();
    }

    class RecentItemViewHolder extends RecyclerView.ViewHolder {

        private ItemRecentBinding binding;
        private RecentItemViewModel viewModel = new RecentItemViewModel();

        RecentItemViewHolder(ItemRecentBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(YoutubeData data) {
            viewModel.bind(data);
            viewModel.setNavigator(RecentListAdapter.this);
            binding.setViewModel(viewModel);
        }
    }
}
