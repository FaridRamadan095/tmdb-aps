package com.example.proyekjetpack.utils;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.NoMatchingViewException;
import androidx.test.espresso.ViewAssertion;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class RecyclerViewItemCountAssertion implements ViewAssertion {
    private final int expextedCOunt;

    public RecyclerViewItemCountAssertion(int expextedCOunt) {
        this.expextedCOunt = expextedCOunt;
    }

    @Override
    public void check(View view, NoMatchingViewException noViewFoundException) {
        if (noViewFoundException != null){
            throw noViewFoundException;
        }

        RecyclerView recyclerView = (RecyclerView) view;
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        assertNotNull(adapter);
        assertThat(adapter.getItemCount(), is(expextedCOunt));
    }
}
