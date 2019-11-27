package com.example.proyekjetpack.ui.movie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.example.proyekjetpack.data.source.CatalogueRepository;
import com.example.proyekjetpack.data.source.remote.response.MovieDetail;
import com.example.proyekjetpack.data.source.remote.response.MovieModel;
import com.example.proyekjetpack.vo.Resource;

import java.util.List;

public class MovieViewModel extends ViewModel {
    private CatalogueRepository catalogueRepository;

    private MutableLiveData<String> mLogin = new MutableLiveData<>();

    public MovieViewModel(CatalogueRepository mCatalogueRepository){
        this.catalogueRepository = mCatalogueRepository;
    }

    LiveData<Resource<List<MovieModel>>> movies = Transformations.switchMap(mLogin,
            data -> catalogueRepository.getAllMovies());

    void setUsername(String username){
        mLogin.setValue(username);
    }
}
