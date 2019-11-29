package com.soni.myproject;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.soni.myproject.model.Episode;
import com.soni.myproject.network.ApiService;
import com.soni.myproject.network.RetrofitBuilder;
import com.soni.myproject.network.responses.GetEpisodesResponse;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EpisodeActivity extends AppCompatActivity {
    ApiService service;
    @BindView(R.id.rv_episodes)
    RecyclerView recyclerEpisode;
    private ArrayList<Episode> episodeList;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_episode);
        ButterKnife.bind(this);
        LinearLayoutManager llmService=new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerEpisode.setLayoutManager(llmService);
        recyclerEpisode.setHasFixedSize(true);

        getEpisodes();
    }

    private void getEpisodes(){
        ApiService service = RetrofitBuilder.createService(ApiService.class);
        Call<GetEpisodesResponse> call = service.getEpisodes();
        call.enqueue(new Callback<GetEpisodesResponse>() {
            @Override
            public void onResponse(Call<GetEpisodesResponse> call, Response<GetEpisodesResponse> response) {
                //Log.w(, "onResponse: " + response.body());
                if (response.isSuccessful()) {
                    episodeList = new ArrayList<>();
                    for (Episode episode: response.body().getEpisodes()) {
                        episodeList.add(episode);
                    }
                    EpisodeAdapter episodesAdapter = new EpisodeAdapter(episodeList, EpisodeActivity.this);
                    recyclerEpisode.setAdapter(episodesAdapter);
                } else {
                    Toast toast = Toast.makeText(EpisodeActivity.this, "API Error", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();
                }
            }

            @Override
            public void onFailure(Call<GetEpisodesResponse> call, Throwable t) {
                Toast toast = Toast.makeText(EpisodeActivity.this, "Network Failure", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
            }
        });
    }

}
