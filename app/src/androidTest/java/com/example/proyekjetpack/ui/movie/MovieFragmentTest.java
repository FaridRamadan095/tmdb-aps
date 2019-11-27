package com.example.proyekjetpack.ui.movie;

import androidx.test.rule.ActivityTestRule;

import com.example.proyekjetpack.R;
import com.example.proyekjetpack.testing.SingleFragmentActivity;
import com.example.proyekjetpack.utils.RecyclerViewItemCountAssertion;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.*;

public class MovieFragmentTest {

    @Rule
    public ActivityTestRule<SingleFragmentActivity> activityTestRule = new ActivityTestRule<>(SingleFragmentActivity.class);
    private MovieFragment movieFragment = new MovieFragment();

    @Before
    public void setUp(){
        activityTestRule.getActivity().setFragment(movieFragment);
    }


    @Test
    public void loadMovies(){
        onView(withId(R.id.rv_movie)).check(new RecyclerViewItemCountAssertion(20));
    }

}