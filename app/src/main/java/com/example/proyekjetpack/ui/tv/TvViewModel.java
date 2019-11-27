package com.example.proyekjetpack.ui.tv;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.example.proyekjetpack.data.source.CatalogueRepository;
import com.example.proyekjetpack.data.source.remote.response.TvShowModel;
import com.example.proyekjetpack.vo.Resource;

import java.util.List;

public class TvViewModel extends ViewModel {

    private CatalogueRepository catalogueRepository;

    private MutableLiveData<String> mLogin = new MutableLiveData<>();

    public TvViewModel(CatalogueRepository catalogueRepository) {
        this.catalogueRepository = catalogueRepository;
    }

    LiveData<Resource<List<TvShowModel>>> tv = Transformations.switchMap(mLogin,
            data -> catalogueRepository.getAllTvShow());

    void setUsername(String username){
        mLogin.setValue(username);
    }
}
