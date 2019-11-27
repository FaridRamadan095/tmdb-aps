package com.example.proyekjetpack.ui;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.rule.ActivityTestRule;

import com.example.proyekjetpack.R;
import com.example.proyekjetpack.ui.home.HomeActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.matcher.ViewMatchers.*;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.*;

public class ProyekJetpackTest {

    @Rule
    public ActivityTestRule<HomeActivity> activityTestRule = new ActivityTestRule<>(HomeActivity.class);

    @Test
    public void toDetailMovieActivityTest(){
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        onView(withId(R.id.tvTitleMovie)).check(matches(isDisplayed()));
        onView(withId(R.id.tvTitleMovie)).check(matches(withText("Terminator: Dark Fate")));

    }

    @Test
    public void toDetailTvActivityTest(){

        onView(withId(R.id.action_tv)).perform(click());

        onView(withId(R.id.rv_tv)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_tv)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        onView(withId(R.id.tvTitleTv)).check(matches(isDisplayed()));
        onView(withId(R.id.tvTitleTv)).check(matches(withText("The Simpsons")));
    }
}
