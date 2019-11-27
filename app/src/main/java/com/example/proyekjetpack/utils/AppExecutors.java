package com.example.proyekjetpack.utils;

import android.os.Handler;
import android.os.Looper;

import androidx.annotation.VisibleForTesting;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AppExecutors {

    private static final int THREAD_COUNT = 3;

    private final Executor diskIO;

    private final Executor netwrokIO;

    private final Executor mainThread;

    @VisibleForTesting
    public AppExecutors(Executor diskIO, Executor netwrokIO, Executor mainThread) {
        this.diskIO = diskIO;
        this.netwrokIO = netwrokIO;
        this.mainThread = mainThread;
    }

    public AppExecutors(){
        this(new DiskIOThreadExecutor(), Executors.newFixedThreadPool(THREAD_COUNT),
                new MainThreadExecutor());
    }

    public Executor diskIO(){
        return diskIO;
    }

    public Executor netwrokIO(){
        return netwrokIO;
    }

    public Executor mainThread(){
        return mainThread;
    }

    private static class MainThreadExecutor implements Executor{

        private final Handler mainThreadHandler = new Handler(Looper.getMainLooper());

        @Override
        public void execute(Runnable runnable) {
            mainThreadHandler.post(runnable);
        }
    }
}
