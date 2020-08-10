package com.daniil.mediplayer;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Path;

public interface APIService {
    @GET("/api/playlists/{idplaylist}")
    Call<Track> getPlaylistsTrack(@HeaderMap Map<String, String> headers, @Path("idplaylist") String idplaylist);
}
