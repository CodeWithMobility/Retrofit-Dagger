package com.recycler.movieinfo.dagger.components;


import com.recycler.movieinfo.dagger.module.AppModule;
import com.recycler.movieinfo.dagger.module.NetModule;
import com.recycler.movieinfo.ui.HomeActivity;
import com.recycler.movieinfo.ui.fragments.FragmentHome;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Manu on 10/31/2017.
         */

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    void inject(HomeActivity activity);
    void inject(FragmentHome fragment);
}