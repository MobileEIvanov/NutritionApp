package com.playground.nutrition;

import android.content.Context;

import com.playground.nutrition.data.Repository;
import com.playground.nutrition.data.remote.RecipeServiceAPI;
import com.playground.nutrition.data.db.RecipesDatabase;
import com.playground.nutrition.data.db.LocalDataSource;
import com.playground.nutrition.data.remote.RemoteDataSource;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by emil.ivanov on 10/17/18.
 */
public class Injector {

    /**
     * NETWORK RELATED INJECTIONS
     */
    private static final String BASE_URL = "http://www.recipepuppy.com/";

    private static OkHttpClient providesHttpClient() {
        HttpLoggingInterceptor logger = new HttpLoggingInterceptor();
        logger.setLevel(HttpLoggingInterceptor.Level.BASIC);

        return new OkHttpClient.Builder().addInterceptor(logger).build();
    }

    private static Retrofit providesRetrofit() {

        return new Retrofit.Builder().
                baseUrl(BASE_URL)
                .client(providesHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static RecipeServiceAPI createServiceApi() {
        return providesRetrofit()
                .create(RecipeServiceAPI.class);
    }

    public static RemoteDataSource provideRemoteDatasource() {
        return new RemoteDataSource(createServiceApi());
    }


    public static Repository provideRepository(Context context) {
        return new Repository(context);
    }


    public static RecipesDatabase providesDatabase(Context context) {
        return RecipesDatabase.getInstance(context);
    }

    public static LocalDataSource provideLocalDatasource(Context context) {
        return new LocalDataSource(context);
    }


}
