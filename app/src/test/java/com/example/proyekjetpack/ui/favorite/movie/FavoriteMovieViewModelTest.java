package com.example.proyekjetpack.ui.favorite.movie;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.paging.PagedList;

import com.example.proyekjetpack.data.source.CatalogueRepository;
import com.example.proyekjetpack.data.source.remote.response.MovieDetail;
import com.example.proyekjetpack.vo.Resource;
import com.example.utils.FakeDataTmdb;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FavoriteMovieViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
    private FavoriteMovieViewModel viewModel;
    private CatalogueRepository catalogueRepository = mock(CatalogueRepository.class);

    @Before
    public void setUp(){
        viewModel = new FavoriteMovieViewModel(catalogueRepository);
    }

    @Test
    public void getFavorite(){
        MutableLiveData<Resource<PagedList<MovieDetail>>> dataMovie = new MutableLiveData<>();
        PagedList<MovieDetail> pagedList = mock(PagedList.class);

        dataMovie.setValue(Resource.success(pagedList));

        when(catalogueRepository.getFavoriteMoviePaged()).thenReturn(dataMovie);

        Observer<Resource<PagedList<MovieDetail>>> observer = mock(Observer.class);

        viewModel.getFavoritePaged().observeForever(observer);

        verify(observer).onChanged(Resource.success(pagedList));
    }
}