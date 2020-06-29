package kr.hs.dgsw.videoenglish_android.di.module;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import kr.hs.dgsw.videoenglish_android.ui.main.MainActivity;
import kr.hs.dgsw.videoenglish_android.di.scope.PerActivity;

@Module
public abstract class ActivityBindingModule {
    @PerActivity
    @ContributesAndroidInjector
    public abstract MainActivity bindingMainActivity();
}
