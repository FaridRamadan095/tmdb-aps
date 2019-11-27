package com.example.proyekjetpack.utils;

import androidx.test.espresso.IdlingRegistry;

import com.jakewharton.espresso.OkHttp3IdlingResource;

import okhttp3.OkHttpClient;

public abstract class OkhttpIdlingResource {
    public static void registerOkhttp(OkHttpClient client){
        IdlingRegistry.getInstance().register(OkHttp3IdlingResource.create("okhttp", client));
    }
}
