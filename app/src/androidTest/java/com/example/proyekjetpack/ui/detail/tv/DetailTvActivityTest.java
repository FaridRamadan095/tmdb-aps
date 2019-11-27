package com.example.proyekjetpack.ui.detail.tv;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import com.example.proyekjetpack.R;
import com.example.proyekjetpack.data.source.remote.response.GenreModel;
import com.example.proyekjetpack.data.source.remote.response.TvShowDetail;
import com.example.proyekjetpack.data.source.remote.response.TvShowModel;
import com.example.proyekjetpack.utils.FakeDataTmdb;

import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static androidx.test.espresso.matcher.ViewMatchers.*;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;

public class DetailTvActivityTest {
    private TvShowDetail dataTv = FakeDataTmdb.generateTvDetail().get(0);

    private String getGenre(ArrayList<GenreModel> genreModels) {
        List<String> tvGenres = new ArrayList<>();

        for (int i = 0; i<genreModels.size(); i++){
            tvGenres.add(genreModels.get(i).getName());
        }

        return TextUtils.join(", ", tvGenres);
    }

    @Rule
    public ActivityTestRule<DetailTvActivity> activityTestRule = new ActivityTestRule<DetailTvActivity>(DetailTvActivity.class){
        @Override
        protected Intent getActivityIntent() {
            Context targetContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
            Intent result = new Intent(targetContext, DetailTvActivity.class);
            result.putExtra(DetailTvActivity.EXTRA_TV, dataTv.getId());
            return result;
        }
    };

    @Test
    public void loadTv(){
        onView(withId(R.id.tvTitleTv)).check(matches(withText(dataTv.getName())));

        onView(withId(R.id.tvReleaseTv)).check(matches(withText(dataTv.getFirst_air_date())));

        onView(withId(R.id.tvGenreTv)).check(matches(withText(getGenre(dataTv.getGenreModels()))));

        onView(withId(R.id.tvOverviewTv)).check(matches(withText(dataTv.getOverview())));

        onView(withId(R.id.tvGenreTv)).perform(click());

    }

}