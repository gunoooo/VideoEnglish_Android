package kr.hs.dgsw.videoenglish_android.di.component;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import kr.hs.dgsw.videoenglish_android.di.module.ActivityBindingModule;
import kr.hs.dgsw.videoenglish_android.di.module.AppModule;
import kr.hs.dgsw.videoenglish_android.di.module.FragmentBindingModule;
import kr.hs.dgsw.videoenglish_android.di.module.NetWorkModule;
import kr.hs.dgsw.videoenglish_android.di.module.RemoteModule;
import kr.hs.dgsw.videoenglish_android.di.module.RepositoryModule;
import kr.hs.dgsw.videoenglish_android.widget.VideoEnglishApplication;

@Singleton
@Component(modules = {
        AppModule.class,
        RemoteModule.class,
        RepositoryModule.class,
        NetWorkModule.class,
        ActivityBindingModule.class,
        FragmentBindingModule.class,
        AndroidSupportInjectionModule.class
})
public interface AppComponent extends AndroidInjector<VideoEnglishApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
