package com.example.proyekjetpack.ui.tv;

import androidx.test.rule.ActivityTestRule;

import com.example.proyekjetpack.R;
import com.example.proyekjetpack.testing.SingleFragmentActivity;
import com.example.proyekjetpack.utils.RecyclerViewItemCountAssertion;

import static androidx.test.espresso.matcher.ViewMatchers.*;
import static androidx.test.espresso.Espresso.onView;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class TvFragmentTest {
    @Rule
    public ActivityTestRule<SingleFragmentActivity> activityTestRule = new ActivityTestRule<>(SingleFragmentActivity.class);
    private TvFragment tvFragment = new TvFragment();

    @Before
    public void setUp(){
        activityTestRule.getActivity().setFragment(tvFragment);
    }

    @Test
    public void loadTv(){
        onView(withId(R.id.rv_tv)).check(new RecyclerViewItemCountAssertion(20));
    }
}