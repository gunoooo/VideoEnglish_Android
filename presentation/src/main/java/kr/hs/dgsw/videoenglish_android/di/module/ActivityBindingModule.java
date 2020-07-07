package kr.hs.dgsw.videoenglish_android.di.module;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import kr.hs.dgsw.videoenglish_android.ui.main.MainActivity;
import kr.hs.dgsw.videoenglish_android.di.scope.PerActivity;
import kr.hs.dgsw.videoenglish_android.ui.player.PlayerActivity;

@Module
public abstract class ActivityBindingModule {
    @PerActivity
    @ContributesAndroidInjector
    public abstract MainActivity bindingMainActivity();

    @PerActivity
    @ContributesAndroidInjector
    public abstract PlayerActivity bindingPlayerActivity();
}
