package kr.hs.dgsw.videoenglish_android.ui.main;

import androidx.lifecycle.ViewModelProvider;

import org.jetbrains.annotations.NotNull;

import kr.hs.dgsw.videoenglish_android.base.BaseActivity;
import kr.hs.dgsw.videoenglish_android.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> {

    @NotNull
    @Override
    protected MainViewModel getViewModel() {
        return new ViewModelProvider(this).get(MainViewModel.class);
    }

    @Override
    protected void observerViewModel() {

    }
}
