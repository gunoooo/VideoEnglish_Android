package kr.hs.dgsw.videoenglish_android.di.module;

import com.gunwoo.karaoke.singsangsung.ui.favorites.FavoritesAddDialog;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import kr.hs.dgsw.videoenglish_android.di.scope.PerFragment;
import kr.hs.dgsw.videoenglish_android.ui.favorites.FavoritesBottomSheetDialog;
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

    @PerFragment
    @ContributesAndroidInjector
    public abstract FavoritesAddDialog bindingFavoritesAddDialog();

    @PerFragment
    @ContributesAndroidInjector
    public abstract FavoritesBottomSheetDialog bindingFavoritesBottomSheetDialog();
}
