package com.soni.myproject.network;

import com.soni.myproject.network.responses.GetEpisodesResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    @GET("getData")
    Call<GetEpisodesResponse> getEpisodes();
}

