package com.recycler.movieinfo.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.recycler.movieinfo.R;
import com.recycler.movieinfo.model.MoviesDetailModel;
import com.recycler.movieinfo.model.PopularMoviesModel;
import com.recycler.movieinfo.network.HttpConstants;
import com.recycler.movieinfo.network.RestApi;
import com.recycler.movieinfo.storage.PreferenceManager;
import com.recycler.movieinfo.storage.SqliteManager;
import com.recycler.movieinfo.ui.adapter.MovieListAdapter;
import com.recycler.movieinfo.utils.MyApp;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Manu on 10/31/2017.
 */

public class FragmentHome extends Fragment {

    @Inject
    PreferenceManager preferenceManager;
    @Inject
    SqliteManager sqliteManager;
    @Inject
    Retrofit retrofit;

    private View rootView;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_home,container, false);
        ((MyApp)getActivity().getApplication()).getNetComponent().inject(this);

        recyclerView = rootView.findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        getMovies();
        return rootView;
    }



    private void getMovies(){
        Call<PopularMoviesModel> countries = retrofit.create(RestApi.class).getPopularMovies(HttpConstants.API_KEY);
        //Enque the call
        countries.enqueue(new Callback<PopularMoviesModel>() {
            @Override
            public void onResponse(Call<PopularMoviesModel> call, Response<PopularMoviesModel> response) {
                //Set the response to the textview
                Log.e("Title === > ", response.body().getTotal_pages()+"\n");
                if (response.body().getResults().size() > 0) {
                    MovieListAdapter adapter = new MovieListAdapter(getActivity(), response.body().getResults(),0);
                    recyclerView.setAdapter(adapter);
                    insertDataToDB(response.body());
                }
            }

            @Override
            public void onFailure(Call<PopularMoviesModel> call, Throwable t) {
                //Set the error to the textview
            }
        });
    }

    private void insertDataToDB(PopularMoviesModel popularMoviesModel) {

        for (PopularMoviesModel.ResultsEntity resultsEntity : popularMoviesModel.getResults()) {
            MoviesDetailModel moviesDetailModel = new MoviesDetailModel();
            moviesDetailModel.setId(resultsEntity.getId());
            moviesDetailModel.setTitle(resultsEntity.getTitle());
            moviesDetailModel.setRelease_date(resultsEntity.getRelease_date());
            moviesDetailModel.setOriginal_title(resultsEntity.getOriginal_title());
            moviesDetailModel.setOverview(resultsEntity.getOverview());
            moviesDetailModel.setVote_count(resultsEntity.getVote_count());
            moviesDetailModel.setVote_average(resultsEntity.getVote_average());
            //  moviesDetailModel.setBudget(resultsEntity.getBudget());
            //  moviesDetailModel.setRevenue(resultsEntity.getTitle());
            //   moviesDetailModel.setGenres(resultsEntity.getTitle());
            //  moviesDetailModel.setStatus(resultsEntity.getTitle());
            moviesDetailModel.setPopularity(resultsEntity.getPopularity());
            // moviesDetailModel.setHomepage(resultsEntity.getTitle());
            moviesDetailModel.setPoster_path(resultsEntity.getPoster_path());
            moviesDetailModel.setBackdrop_path(resultsEntity.getBackdrop_path());

            sqliteManager.addMovies(moviesDetailModel,0);
        }

    }
}
