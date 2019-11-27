package com.example.proyekjetpack.ui.favorite.tv;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ShareCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.proyekjetpack.R;
import com.example.proyekjetpack.data.source.remote.response.TvShowDetail;
import com.example.proyekjetpack.viewmodel.ViewModelFactory;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoriteTvFragment extends Fragment implements FavoriteTvFragmentCallback{
    private RecyclerView rvFavorite;
    private ProgressBar progressBar;
    private FavoriteTvViewModel viewModel;
    private List<TvShowDetail> tvshow;
    private FavoriteTvPagerAdapter adapter;


    public FavoriteTvFragment() {
        // Required empty public constructor
    }



    public static Fragment newInstance(){
        return new FavoriteTvFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite_tv, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvFavorite = view.findViewById(R.id.rv_tv);
        progressBar = view.findViewById(R.id.progress_bar);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null){
            viewModel = obtainViewModel(getActivity());

            adapter = new FavoriteTvPagerAdapter(this, getActivity());

            viewModel.getFavoritePaged().observe(this, tv -> {
                if (tv != null){
                    switch (tv.status){
                        case LOADING:
                            progressBar.setVisibility(View.VISIBLE);
                            break;
                        case SUCCESS:
                            progressBar.setVisibility(View.GONE);
                            adapter.submitList(tv.data);
                            adapter.notifyDataSetChanged();
                            break;
                        case ERROR:
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(getContext(), "Terjadi kesalahan", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        itemTouchHelper.attachToRecyclerView(rvFavorite);

        rvFavorite.setLayoutManager(new LinearLayoutManager(getContext()));
        rvFavorite.setHasFixedSize(true);
        rvFavorite.setAdapter(adapter);

    }

    private ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.Callback() {
        @Override
        public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            return makeMovementFlags(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
        }

        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return true;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            if (getView() != null){
                int swipedPosition = viewHolder.getAdapterPosition();
                TvShowDetail tvShowDetail = adapter.getItemById(swipedPosition);
                viewModel.setFavorite(tvShowDetail);
                Snackbar snackbar = Snackbar.make(getView(), "Batalkan menghapus item sebelumnya?", Snackbar.LENGTH_LONG);
                snackbar.setAction("OK", view -> viewModel.setFavorite(tvShowDetail));
                snackbar.show();
            }
        }
    });

    @Override
    public void onShareClick(TvShowDetail tvShowDetail) {
        if (getActivity() != null){
            String mimeType = "text/plain";
            ShareCompat.IntentBuilder
                    .from(getActivity())
                    .setType(mimeType)
                    .setChooserTitle("Bagikan aplikasi ini sekarang")
                    .setText(String.format("Segera tonton film " + tvShowDetail.getName()))
                    .startChooser();
        }
    }

    @NonNull
    private static FavoriteTvViewModel obtainViewModel(FragmentActivity activity){
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
        return ViewModelProviders.of(activity, factory).get(FavoriteTvViewModel.class);
    }
}
