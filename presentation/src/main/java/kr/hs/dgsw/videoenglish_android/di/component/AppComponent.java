package kr.hs.dgsw.videoenglish_android.di.component;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import kr.hs.dgsw.videoenglish_android.di.module.ActivityBindingModule;
import kr.hs.dgsw.videoenglish_android.widget.VideoEnglishApplication;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ActivityBindingModule.class
})
public interface AppComponent extends AndroidInjector<VideoEnglishApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
