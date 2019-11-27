package com.example.proyekjetpack.ui.detail.movie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.example.proyekjetpack.data.source.CatalogueRepository;
import com.example.proyekjetpack.data.source.remote.response.MovieDetail;
import com.example.proyekjetpack.vo.Resource;

public class DetailMovieViewModel extends ViewModel {
    private String movieId;
    private CatalogueRepository catalogueRepository;
    private MutableLiveData<String> mLogin = new MutableLiveData<>();

    public DetailMovieViewModel(CatalogueRepository catalogueRepository) {
        this.catalogueRepository = catalogueRepository;
    }

    LiveData<Resource<MovieDetail>> movies = Transformations.switchMap(mLogin,
            data -> catalogueRepository.getDetailMovie(movieId));

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    void setUsername(String username){
        mLogin.setValue(username);
    }

    void setFavoriteMovie(){
        if (movies.getValue() != null){
            MovieDetail movieDetail = movies.getValue().data;

            if (movieDetail != null){

                final boolean newState = !movieDetail.isFavorite();
                catalogueRepository.setMovieFavorite(movieDetail, newState);
            }
        }
    }
}
