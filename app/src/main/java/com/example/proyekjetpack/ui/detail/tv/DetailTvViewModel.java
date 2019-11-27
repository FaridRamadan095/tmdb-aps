package com.example.proyekjetpack.ui.detail.tv;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.example.proyekjetpack.data.TvEntity;
import com.example.proyekjetpack.data.source.CatalogueRepository;
import com.example.proyekjetpack.data.source.remote.response.TvShowDetail;
import com.example.proyekjetpack.data.source.remote.response.TvShowModel;
import com.example.proyekjetpack.utils.DataTmdb;
import com.example.proyekjetpack.vo.Resource;

public class DetailTvViewModel extends ViewModel {
    private String tvId;
    private CatalogueRepository catalogueRepository;
    private MutableLiveData<String> mLogin = new MutableLiveData<>();

    public DetailTvViewModel(CatalogueRepository catalogueRepository) {
        this.catalogueRepository = catalogueRepository;
    }

    LiveData<Resource<TvShowDetail>> tv = Transformations.switchMap(mLogin,
            data -> catalogueRepository.getDetailTv(tvId));

    public String getTvId() {
        return tvId;
    }

    public void setTvId(String tvId) {
        this.tvId = tvId;
    }

    void setUsername(String username){
        mLogin.setValue(username);
    }

    void setFavoriteTv(){
        if (tv.getValue() != null){
            TvShowDetail tvShowDetail = tv.getValue().data;

            if (tvShowDetail != null){

                final boolean newState = !tvShowDetail.isFavorite();
                catalogueRepository.setTvFavorite(tvShowDetail, newState);
            }
        }
    }
}
