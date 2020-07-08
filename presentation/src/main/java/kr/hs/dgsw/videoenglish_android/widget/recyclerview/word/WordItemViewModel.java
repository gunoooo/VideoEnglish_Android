package kr.hs.dgsw.videoenglish_android.widget.recyclerview.word;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import kr.hs.dgsw.domain.model.Word;
import kr.hs.dgsw.videoenglish_android.base.viewmodel.BaseItemViewModel;

public class WordItemViewModel extends BaseItemViewModel<WordNavigator> {

    private Word word;

    private MutableLiveData<String> english = new MutableLiveData<>();
    public LiveData<String> getEnglish() {
        return english;
    }
    private MutableLiveData<String> korean = new MutableLiveData<>();
    public LiveData<String> getKorean() {
        return korean;
    }

    void bind(Word data) {
        this.word = data;

        english.setValue(word.getEnglish());
        korean.setValue(word.getKorean());
    }
}
