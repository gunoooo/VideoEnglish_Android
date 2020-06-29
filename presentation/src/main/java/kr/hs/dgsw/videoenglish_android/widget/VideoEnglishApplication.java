package kr.hs.dgsw.videoenglish_android.widget;

import android.app.Activity;

import javax.inject.Inject;

import dagger.android.*;
import kr.hs.dgsw.videoenglish_android.di.component.DaggerAppComponent;

public class VideoEnglishApplication extends DaggerApplication implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> activityInjector;

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
    }

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return activityInjector;
    }
}
