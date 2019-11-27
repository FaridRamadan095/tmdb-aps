package com.example.proyekjetpack.ui.favorite.movie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.example.proyekjetpack.data.source.CatalogueRepository;
import com.example.proyekjetpack.data.source.remote.response.MovieDetail;
import com.example.proyekjetpack.vo.Resource;

import java.util.List;

public class FavoriteMovieViewModel extends ViewModel {
    private CatalogueRepository catalogueRepository;

    public FavoriteMovieViewModel(CatalogueRepository catalogueRepository) {
        this.catalogueRepository = catalogueRepository;
    }

    LiveData<Resource<List<MovieDetail>>> getFavorite(){
        return catalogueRepository.getFavoriteMovie();
    }

    LiveData<Resource<PagedList<MovieDetail>>> getFavoritePaged(){
        return catalogueRepository.getFavoriteMoviePaged();
    }

    void setFavorite(MovieDetail movieDetail){
        final boolean newState = !movieDetail.isFavorite();
        catalogueRepository.setMovieFavorite(movieDetail, newState);
    }
}
