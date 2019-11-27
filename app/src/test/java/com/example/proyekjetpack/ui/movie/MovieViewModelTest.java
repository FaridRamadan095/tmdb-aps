package com.example.proyekjetpack.ui.movie;

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

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MovieViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
    private MovieViewModel viewModel;
    private CatalogueRepository catalogueRepository = mock(CatalogueRepository.class);

    private String USERNAME = "dadhe";

    @Before
    public void setUp(){
        viewModel = new MovieViewModel(catalogueRepository);
    }

    @Test
    public void getMovies(){
        Resource<List<MovieModel>> resource = Resource.success(FakeDataTmdb.generateMovieData());
        MutableLiveData<Resource<List<MovieModel>>> dataMovie = new MutableLiveData<>();
        dataMovie.setValue(resource);

        when(catalogueRepository.getAllMovies()).thenReturn(dataMovie);

        Observer<Resource<List<MovieModel>>> observer = mock(Observer.class);

        viewModel.setUsername(USERNAME);

        viewModel.movies.observeForever(observer);

        verify(observer).onChanged(resource);
    }

}