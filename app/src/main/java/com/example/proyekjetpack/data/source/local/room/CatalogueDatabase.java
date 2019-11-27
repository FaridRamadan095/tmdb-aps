package com.example.proyekjetpack.data.source.local.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.proyekjetpack.data.source.remote.response.DataConverter;
import com.example.proyekjetpack.data.source.remote.response.MovieDetail;
import com.example.proyekjetpack.data.source.remote.response.MovieModel;
import com.example.proyekjetpack.data.source.remote.response.TvShowDetail;
import com.example.proyekjetpack.data.source.remote.response.TvShowModel;

@Database(entities = {MovieDetail.class, MovieModel.class, TvShowModel.class, TvShowDetail.class},
        version = 1,
        exportSchema = false)
@TypeConverters(DataConverter.class)
public abstract class CatalogueDatabase extends RoomDatabase {

    private static CatalogueDatabase INSTANCE;

    public abstract CatalogueDao catalogueDao();

    private static final Object sLock = new Object();

    public static CatalogueDatabase getInstance(Context context){
        synchronized (sLock){
            if (INSTANCE == null){
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        CatalogueDatabase.class, "Catalogue.db")
                        .build();
            }
            return INSTANCE;
        }
    }
}
