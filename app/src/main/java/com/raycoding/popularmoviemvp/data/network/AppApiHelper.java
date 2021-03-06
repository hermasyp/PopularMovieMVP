package com.raycoding.popularmoviemvp.data.network;

import android.util.Log;

import com.raycoding.popularmoviemvp.data.network.model.MovieResponse;
import com.rx2androidnetworking.Rx2AndroidNetworking;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 03/05/18.
 */
@Singleton
public class AppApiHelper implements ApiHelper {
    private static final String TAG = "AppApiHelper";

    @Inject
    AppApiHelper() {
    }

    @Override
    public Observable<MovieResponse> getPopularMovies(int page) {
        return Rx2AndroidNetworking.get(ApiEndpoint.getPopularMovieUrl(page))
                .build()
                .getObjectObservable(MovieResponse.class);
    }

    @Override
    public Observable<MovieResponse> getTopRatedMovies(int page) {
        return Rx2AndroidNetworking.get(ApiEndpoint.getTopRatedMovieUrl(page))
                .build()
                .getObjectObservable(MovieResponse.class);
    }
}
