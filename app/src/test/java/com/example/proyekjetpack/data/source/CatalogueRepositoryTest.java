package com.example.proyekjetpack.data.source;

import android.util.Log;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.PagedList;

import com.example.proyekjetpack.data.source.local.LocalRepository;
import com.example.proyekjetpack.data.source.remote.RemoteRepository;
import com.example.proyekjetpack.data.source.remote.response.MovieDetail;
import com.example.proyekjetpack.data.source.remote.response.MovieModel;
import com.example.proyekjetpack.data.source.remote.response.MovieResponse;
import com.example.proyekjetpack.data.source.remote.response.TvShowDetail;
import com.example.proyekjetpack.data.source.remote.response.TvShowModel;
import com.example.proyekjetpack.vo.Resource;
import com.example.utils.FakeDataTmdb;
import com.example.utils.InstantAppExecutors;
import com.example.utils.LiveDataTestUtil;
import com.example.utils.PagedListUtill;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

public class CatalogueRepositoryTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private RemoteRepository remote = Mockito.mock(RemoteRepository.class);


    private ArrayList<MovieModel> movieResponse = FakeDataTmdb.generateMovieData();
    private int idMovieint = movieResponse.get(0).getId();

    private String idMovie = String.valueOf(idMovieint);

    private MovieDetail detailMovie = FakeDataTmdb.generateDetailMovie(idMovie);

    private ArrayList<TvShowModel> tvResponse = FakeDataTmdb.generateTvData();
    private int idTvint = tvResponse.get(0).getId();

    private TvShowDetail detailTv = FakeDataTmdb.genereateDetailTv(idTvint);
    private String idTv = String.valueOf(idTvint);

    private List<MovieDetail> movieDetails = FakeDataTmdb.generateMovieDetail();
    private List<TvShowDetail> tvShowDetails = FakeDataTmdb.generateTvDetail();

    private LocalRepository local = Mockito.mock(LocalRepository.class);
    private InstantAppExecutors instantAppExecutors = Mockito.mock(InstantAppExecutors.class);
    private FakeCatalogueRepository catalogueRepository = new FakeCatalogueRepository(local, remote, instantAppExecutors);


    @Before
    public void setUp(){

    }

    @After
    public void tearDown(){

    }

    @Test
    public void getAllMovies(){
        MutableLiveData<List<MovieModel>> dummyMovie = new MutableLiveData<>();
        dummyMovie.setValue(FakeDataTmdb.generateMovieData());

        when(local.getAllMovies()).thenReturn(dummyMovie);

        Resource<List<MovieModel>> result = LiveDataTestUtil.getValue(catalogueRepository.getAllMovies());

        verify(local).getAllMovies();
        assertNotNull(result.data);
        assertEquals(movieResponse.size(), result.data.size());

    }

    @Test
    public void getAllTv(){
        MutableLiveData<List<TvShowModel>> dummyTv = new MutableLiveData<>();
        dummyTv.setValue(FakeDataTmdb.generateTvData());

        when(local.getAllTv()).thenReturn(dummyTv);

        Resource<List<TvShowModel>> result = LiveDataTestUtil.getValue(catalogueRepository.getAllTvShow());

        verify(local).getAllTv();
        assertNotNull(result.data);
        assertEquals(tvResponse.size(), result.data.size());
    }

    @Test
    public void getDetailMovies(){
        MutableLiveData<MovieDetail> dummyMovie = new MutableLiveData<>();
        dummyMovie.setValue(FakeDataTmdb.generateDetailMovie(idMovie));

        when(local.getDetailMovie(idMovie)).thenReturn(dummyMovie);

        Resource<MovieDetail> result = LiveDataTestUtil.getValue(catalogueRepository.getDetailMovie(idMovie));

        verify(local).getDetailMovie(idMovie);
        assertNotNull(result.data);
        assertEquals(detailMovie.getTitle(), result.data.getTitle());
    }

    @Test
    public void getDetailTv(){
        MutableLiveData<TvShowDetail> dummyTv = new MutableLiveData<>();
        dummyTv.setValue(FakeDataTmdb.genereateDetailTv(idTvint));

        when(local.getDetailTv(idTv)).thenReturn(dummyTv);

        Resource<TvShowDetail> result = LiveDataTestUtil.getValue(catalogueRepository.getDetailTv(idTv));

        verify(local).getDetailTv(idTv);
        assertNotNull(result.data);
        assertEquals(detailTv.getName(), result.data.getName());
    }

    @Test
    public void getFavoriteMovie(){

        DataSource.Factory<Integer, MovieDetail> dataSourceFactory = mock(DataSource.Factory.class);

        when(local.getFavoriteMoviePaged()).thenReturn(dataSourceFactory);
        catalogueRepository.getFavoriteMoviePaged();
        Resource<PagedList<MovieDetail>> result = Resource.success(PagedListUtill.mockPagedList(movieDetails));

        verify(local).getFavoriteMoviePaged();
        assertNotNull(result.data);
        assertEquals(movieResponse.size(), result.data.size());
    }

    @Test
    public void getFavoriteTv(){
        DataSource.Factory<Integer, TvShowDetail> dataSourceFactory = mock(DataSource.Factory.class);

        when(local.getFavoriteTvPaged()).thenReturn(dataSourceFactory);
        catalogueRepository.getFavoriteTvPaged();
        Resource<PagedList<TvShowDetail>> result = Resource.success(PagedListUtill.mockPagedList(tvShowDetails));

        verify(local).getFavoriteTvPaged();
        assertNotNull(result.data);
        assertEquals(movieResponse.size(), result.data.size());
    }

}