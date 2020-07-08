package kr.hs.dgsw.videoenglish_android.widget.recyclerview.word;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import kr.hs.dgsw.domain.model.Word;
import kr.hs.dgsw.videoenglish_android.R;
import kr.hs.dgsw.videoenglish_android.databinding.ItemWordBinding;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordItemViewHolder>
        implements WordNavigator {

    private List<Word> wordList;

    public WordListAdapter(List<Word> wordList) {
        this.wordList = wordList;
    }

    @NonNull
    @Override
    public WordItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new WordItemViewHolder(
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.item_word, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull WordItemViewHolder holder, int position) {
        holder.bind(wordList.get(position));
    }

    @Override
    public int getItemCount() {
        return wordList.size();
    }

    class WordItemViewHolder extends RecyclerView.ViewHolder {

        private ItemWordBinding binding;
        private WordItemViewModel viewModel = new WordItemViewModel();

        WordItemViewHolder(ItemWordBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(Word data) {
            viewModel.bind(data);
            viewModel.setNavigator(WordListAdapter.this);
            binding.setViewModel(viewModel);
        }
    }
}
