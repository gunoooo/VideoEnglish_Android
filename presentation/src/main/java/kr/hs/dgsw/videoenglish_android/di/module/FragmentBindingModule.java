package kr.hs.dgsw.videoenglish_android.di.module;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import kr.hs.dgsw.videoenglish_android.di.scope.PerFragment;
import kr.hs.dgsw.videoenglish_android.ui.home.HomeFragment;
import kr.hs.dgsw.videoenglish_android.ui.locker.LockerFragment;
import kr.hs.dgsw.videoenglish_android.ui.wordbook.WordbookFragment;

@Module
public abstract class FragmentBindingModule {
    @PerFragment
    @ContributesAndroidInjector
    public abstract HomeFragment bindingHomeFragment();

    @PerFragment
    @ContributesAndroidInjector
    public abstract LockerFragment bindingLockerFragment();

    @PerFragment
    @ContributesAndroidInjector
    public abstract WordbookFragment bindingWordbookFragment();
}
