package com.example.proyekjetpack.ui.favorite.tv;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.paging.PagedList;

import com.example.proyekjetpack.data.source.CatalogueRepository;
import com.example.proyekjetpack.data.source.remote.response.MovieDetail;
import com.example.proyekjetpack.data.source.remote.response.TvShowDetail;
import com.example.proyekjetpack.data.source.remote.response.TvShowModel;
import com.example.proyekjetpack.vo.Resource;
import com.example.utils.FakeDataTmdb;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class FavoriteTvViewModelTest {


    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
    private FavoriteTvViewModel viewModel;
    private CatalogueRepository catalogueRepository = mock(CatalogueRepository.class);

    @Before
    public void setUp(){
        viewModel = new FavoriteTvViewModel(catalogueRepository);
    }

    @Test
    public void getFavorite(){
        MutableLiveData<Resource<PagedList<TvShowDetail>>> dataTv = new MutableLiveData<>();
        PagedList<TvShowDetail> pagedList = mock(PagedList.class);

        dataTv.setValue(Resource.success(pagedList));

        when(catalogueRepository.getFavoriteTvPaged()).thenReturn(dataTv);

        Observer<Resource<PagedList<TvShowDetail>>> observer = mock(Observer.class);

        viewModel.getFavoritePaged().observeForever(observer);

        verify(observer).onChanged(Resource.success(pagedList));

    }

}