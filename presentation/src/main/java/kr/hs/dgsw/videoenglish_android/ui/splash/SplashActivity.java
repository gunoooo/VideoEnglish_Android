package kr.hs.dgsw.videoenglish_android.ui.splash;

import android.content.Intent;
import android.widget.Toast;

import androidx.lifecycle.ViewModelProvider;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

import kr.hs.dgsw.videoenglish_android.R;
import kr.hs.dgsw.videoenglish_android.base.BaseActivity;
import kr.hs.dgsw.videoenglish_android.databinding.ActivitySplashBinding;
import kr.hs.dgsw.videoenglish_android.ui.main.MainActivity;

public class SplashActivity extends BaseActivity<ActivitySplashBinding, SplashViewModel> {

    @Inject
    SplashViewModelFactory viewModelFactory;

    @NotNull
    @Override
    protected SplashViewModel getViewModel() {
        return new ViewModelProvider(this, viewModelFactory).get(SplashViewModel.class);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void observerViewModel() {
        mViewModel.getOnSuccessEvent().observe(this, o -> startActivity(new Intent(this, MainActivity.class)));
        mViewModel.getOnErrorEvent().observe(this, o -> Toast.makeText(this, R.string.error_start, Toast.LENGTH_LONG).show());
    }
}
