package com.example.proyekjetpack.ui.detail.movie;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.example.proyekjetpack.data.source.CatalogueRepository;
import com.example.proyekjetpack.data.source.remote.response.MovieDetail;
import com.example.proyekjetpack.data.source.remote.response.MovieModel;
import com.example.proyekjetpack.vo.Resource;
import com.example.utils.FakeDataTmdb;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DetailMovieViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private DetailMovieViewModel viewModel;
    private CatalogueRepository catalogueRepository = mock(CatalogueRepository.class);
    private MovieDetail dummyMovie = FakeDataTmdb.generateMovieDetail().get(0);
    private String movieId = String.valueOf(dummyMovie.getId());

    private String USERNAME = "dadhe";

    @Before
    public void setUp(){
        viewModel = new DetailMovieViewModel(catalogueRepository);
        viewModel.setMovieId(movieId);
        viewModel.setFavoriteMovie();
    }

    @Test
    public void getMovie(){
        Resource<MovieDetail> resource = Resource.success(FakeDataTmdb.generateDetailMovieData(dummyMovie, true));
        MutableLiveData<Resource<MovieDetail>> movies = new MutableLiveData<>();
        movies.setValue(resource);

        when(catalogueRepository.getDetailMovie(movieId)).thenReturn(movies);

        Observer<Resource<MovieDetail>> observer = mock(Observer.class);
        viewModel.movies.observeForever(observer);

        viewModel.setUsername(USERNAME);

        verify(observer).onChanged(resource);

    }

}