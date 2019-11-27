package com.example.proyekjetpack.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.proyekjetpack.data.source.CatalogueRepository;
import com.example.proyekjetpack.di.Injection;
import com.example.proyekjetpack.ui.favorite.movie.FavoriteMovieViewModel;
import com.example.proyekjetpack.ui.favorite.tv.FavoriteTvViewModel;
import com.example.proyekjetpack.ui.movie.MovieViewModel;
import com.example.proyekjetpack.ui.tv.TvViewModel;
import com.example.proyekjetpack.ui.detail.movie.DetailMovieViewModel;
import com.example.proyekjetpack.ui.detail.tv.DetailTvViewModel;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private static volatile ViewModelFactory INSTANCE;

    private final CatalogueRepository mCatalogueRpository;

    public ViewModelFactory(CatalogueRepository mCatalogueRpository) {
        this.mCatalogueRpository = mCatalogueRpository;
    }

    public static ViewModelFactory getInstance(Application application){
        if (INSTANCE == null){
            synchronized (ViewModelFactory.class){
                if (INSTANCE == null){
                    INSTANCE = new ViewModelFactory(Injection.providerRepository(application));
                }
            }
        }
        return INSTANCE;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MovieViewModel.class)){
            return (T) new MovieViewModel(mCatalogueRpository);
        }else if (modelClass.isAssignableFrom(TvViewModel.class)){
            return (T) new TvViewModel(mCatalogueRpository);
        }else if (modelClass.isAssignableFrom(DetailMovieViewModel.class)){
            return (T) new DetailMovieViewModel(mCatalogueRpository);
        }else if (modelClass.isAssignableFrom(DetailTvViewModel.class)){
            return (T) new DetailTvViewModel(mCatalogueRpository);
        }else if (modelClass.isAssignableFrom(FavoriteMovieViewModel.class)){
            return (T) new FavoriteMovieViewModel(mCatalogueRpository);
        }else if (modelClass.isAssignableFrom(FavoriteTvViewModel.class)){
            return (T) new FavoriteTvViewModel(mCatalogueRpository);
        }
        throw new IllegalArgumentException("Unkown ViewModel class: " + modelClass.getName());
    }
}
