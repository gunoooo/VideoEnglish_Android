package kr.hs.dgsw.videoenglish_android.di.module;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import kr.hs.dgsw.videoenglish_android.ui.list.ListActivity;
import kr.hs.dgsw.videoenglish_android.ui.main.MainActivity;
import kr.hs.dgsw.videoenglish_android.di.scope.PerActivity;
import kr.hs.dgsw.videoenglish_android.ui.player.PlayerActivity;
import kr.hs.dgsw.videoenglish_android.ui.splash.SplashActivity;

@Module
public abstract class ActivityBindingModule {
    @PerActivity
    @ContributesAndroidInjector
    public abstract SplashActivity bindingSplashActivity();

    @PerActivity
    @ContributesAndroidInjector
    public abstract MainActivity bindingMainActivity();

    @PerActivity
    @ContributesAndroidInjector
    public abstract PlayerActivity bindingPlayerActivity();

    @PerActivity
    @ContributesAndroidInjector
    public abstract ListActivity bindingListActivity();
}
