package com.example.proyekjetpack.ui.tv;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.example.proyekjetpack.data.source.CatalogueRepository;
import com.example.proyekjetpack.data.source.remote.response.MovieModel;
import com.example.proyekjetpack.data.source.remote.response.TvShowModel;
import com.example.proyekjetpack.vo.Resource;
import com.example.utils.FakeDataTmdb;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TvViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
    private TvViewModel viewModel;
    private CatalogueRepository catalogueRepository = mock(CatalogueRepository.class);

    @Before
    public void setUp(){
        viewModel = new TvViewModel(catalogueRepository);
    }

    private String USERNAME = "dadhe";

    @Test
    public void getTv(){
        Resource<List<TvShowModel>> resource = Resource.success(FakeDataTmdb.generateTvData());
        MutableLiveData<Resource<List<TvShowModel>>> dataMovie = new MutableLiveData<>();
        dataMovie.setValue(resource);

        when(catalogueRepository.getAllTvShow()).thenReturn(dataMovie);

        Observer<Resource<List<TvShowModel>>> observer = mock(Observer.class);


        viewModel.setUsername(USERNAME);

        viewModel.tv.observeForever(observer);

        verify(observer).onChanged(resource);
    }

}