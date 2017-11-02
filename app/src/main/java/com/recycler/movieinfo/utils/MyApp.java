package com.recycler.movieinfo.utils;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.recycler.movieinfo.dagger.components.DaggerNetComponent;
import com.recycler.movieinfo.dagger.components.NetComponent;
import com.recycler.movieinfo.dagger.module.AppModule;
import com.recycler.movieinfo.dagger.module.NetModule;
import com.recycler.movieinfo.network.HttpConstants;

/**
 * Created by Manu on 10/31/2017.
 */

public class MyApp extends Application {

    private NetComponent mNetComponent;
    @Override
    public void onCreate() {
        super.onCreate();

        mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule(HttpConstants.BASE_URL))
                .build();
        Fresco.initialize(this);

    }

    public NetComponent getNetComponent() {
        return mNetComponent;
    }
}
