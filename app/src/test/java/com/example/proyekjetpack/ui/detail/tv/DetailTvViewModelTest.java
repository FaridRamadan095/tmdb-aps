package com.example.proyekjetpack.ui.detail.tv;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.example.proyekjetpack.data.TvEntity;
import com.example.proyekjetpack.data.source.CatalogueRepository;
import com.example.proyekjetpack.data.source.remote.response.MovieDetail;
import com.example.proyekjetpack.data.source.remote.response.TvShowDetail;
import com.example.proyekjetpack.data.source.remote.response.TvShowModel;
import com.example.proyekjetpack.vo.Resource;
import com.example.utils.FakeDataTmdb;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class DetailTvViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private DetailTvViewModel viewModel;
    private TvShowDetail dummyTv = FakeDataTmdb.generateTvDetail().get(0);
    private CatalogueRepository catalogueRepository = mock(CatalogueRepository.class);
    private String tvId = String.valueOf(dummyTv.getId());

    private String USERNAME = "dadhe";

    @Before
    public void setUp(){
        viewModel = new DetailTvViewModel(catalogueRepository);
        viewModel.setTvId(tvId);
    }

    @Test
    public void getTv(){
        Resource<TvShowDetail> resource = Resource.success(FakeDataTmdb.generateDetailTvData(dummyTv, true));
        MutableLiveData<Resource<TvShowDetail>> tv = new MutableLiveData<>();
        tv.setValue(resource);

        when(catalogueRepository.getDetailTv(tvId)).thenReturn(tv);

        Observer<Resource<TvShowDetail>> observer = mock(Observer.class);
        viewModel.tv.observeForever(observer);

        viewModel.setUsername(USERNAME);

        verify(observer).onChanged(resource);
    }

}
