package com.example.proyekjetpack.utils;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class DiskIOThreadExecutor implements Executor {

    private final Executor mDiskIO;

    DiskIOThreadExecutor(){
        mDiskIO = Executors.newSingleThreadExecutor();
    }

    @Override
    public void execute(Runnable runnable) {
        mDiskIO.execute(runnable);
    }
}
