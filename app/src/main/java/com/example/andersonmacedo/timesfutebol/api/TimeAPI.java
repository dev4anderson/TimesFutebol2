package com.example.andersonmacedo.timesfutebol.api;

import com.example.andersonmacedo.timesfutebol.model.Time;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by andersonmacedo on 27/11/16.
 */

public interface TimeAPI {

    @GET("/v2/{tipo}")
    Call<List<Time>> findBy(@Path("tipo") String tipo);

}
