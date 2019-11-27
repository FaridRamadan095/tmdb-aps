package com.example.proyekjetpack.di;

import android.app.Application;

import com.example.proyekjetpack.data.source.CatalogueRepository;
import com.example.proyekjetpack.data.source.local.LocalRepository;
import com.example.proyekjetpack.data.source.local.room.CatalogueDatabase;
import com.example.proyekjetpack.data.source.remote.RemoteRepository;
import com.example.proyekjetpack.utils.AppExecutors;

public class Injection {
    public static CatalogueRepository providerRepository(Application application){
        CatalogueDatabase database = CatalogueDatabase.getInstance(application);

        LocalRepository localRepository = LocalRepository.getInstance(database.catalogueDao());
        RemoteRepository remoteRepository = RemoteRepository.getInstance();
        AppExecutors appExecutors = new AppExecutors();

        return CatalogueRepository.getInstance(localRepository, remoteRepository, appExecutors);
    }
}
