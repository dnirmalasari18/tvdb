package com.soni.myproject.network.responses;


import com.soni.myproject.model.Episode;
import com.squareup.moshi.Json;

import java.util.List;

public class GetEpisodesResponse {
    @Json(name = "data")
    List<Episode> episodes;

    public List<Episode> getEpisodes() {
        return episodes;
    }
}
