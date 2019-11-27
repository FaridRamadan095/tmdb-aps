package com.example.proyekjetpack.ui.detail.movie;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import com.example.proyekjetpack.R;
import com.example.proyekjetpack.data.source.remote.response.GenreModel;
import com.example.proyekjetpack.data.source.remote.response.MovieDetail;
import com.example.proyekjetpack.data.source.remote.response.MovieModel;
import com.example.proyekjetpack.utils.FakeDataTmdb;

import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static androidx.test.espresso.matcher.ViewMatchers.*;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;

public class DetailMovieActivityTest {
    private MovieDetail dataMovie = FakeDataTmdb.generateMovieDetail().get(0);

    private String getGenre(ArrayList<GenreModel> genreModels) {
        List<String> movieGenres = new ArrayList<>();

        for (int i = 0; i<genreModels.size(); i++){
            movieGenres.add(genreModels.get(i).getName());
        }

        return TextUtils.join(", ", movieGenres);
    }

    @Rule
    public ActivityTestRule<DetailMovieActivity> activityTestRule = new ActivityTestRule<DetailMovieActivity>(DetailMovieActivity.class){
        @Override
        protected Intent getActivityIntent() {
            Context targetContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
            Intent result = new Intent(targetContext, DetailMovieActivity.class);
            result.putExtra(DetailMovieActivity.EXTRA_MOVIE, dataMovie.getId());
            return result;
        }
    };

    @Test
    public void loadMovie(){
        onView(withId(R.id.tvTitleMovie)).check(matches(withText(dataMovie.getTitle())));

        onView(withId(R.id.tvOverviewMovie)).check(matches(withText(dataMovie.getOverview())));

        onView(withId(R.id.tvReleaseMovie)).check(matches(withText(dataMovie.getRelease_date())));

        onView(withId(R.id.tvGenreMovie)).check(matches(withText(getGenre(dataMovie.getGenreModels()))));

        System.out.println(dataMovie.getTitle());

        onView(withId(R.id.imgBackMovie)).perform(click());
    }
}