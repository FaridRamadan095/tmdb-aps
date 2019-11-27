package com.example.proyekjetpack.ui.favorite.tv;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.example.proyekjetpack.data.source.CatalogueRepository;
import com.example.proyekjetpack.data.source.remote.response.TvShowDetail;
import com.example.proyekjetpack.vo.Resource;

import java.util.List;

public class FavoriteTvViewModel extends ViewModel {
    private CatalogueRepository catalogueRepository;

    public FavoriteTvViewModel(CatalogueRepository catalogueRepository) {
        this.catalogueRepository = catalogueRepository;
    }

    LiveData<Resource<List<TvShowDetail>>> getFavorite(){
        return catalogueRepository.getFavoriteTv();
    }

    LiveData<Resource<PagedList<TvShowDetail>>> getFavoritePaged(){
        return catalogueRepository.getFavoriteTvPaged();
    }

    void setFavorite(TvShowDetail tvShowDetail){
        final boolean newState = !tvShowDetail.isFavorite();
        catalogueRepository.setTvFavorite(tvShowDetail, newState);
    }
}
