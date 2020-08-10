package com.daniil.mediplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlaylistsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TrackTemplate trackTemplate;
    private PlaylistAdapter playlistAdapter;
    private List<TrackTemplate> trackTemplateList;
    private APIService mAPIservice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlists);
        recyclerView = findViewById(R.id.songList);
        trackTemplateList = new ArrayList<>();

        trackTemplateList.add(new TrackTemplate("link","1","Ed Sheeran","Shape of You","3:52","https://upload.wikimedia.org/wikipedia/ru/4/4f/Shape_of_You_single_cover.jpg"));
        trackTemplateList.add(new TrackTemplate("link","2","Ed Sheeran","Shape of You","3:52","https://upload.wikimedia.org/wikipedia/ru/4/4f/Shape_of_You_single_cover.jpg"));
        trackTemplateList.add(new TrackTemplate("link","3","Ed Sheeran","Shape of You","3:52","https://upload.wikimedia.org/wikipedia/ru/4/4f/Shape_of_You_single_cover.jpg"));
        //create multiple tracks (about 10)

        Log.d("list",trackTemplateList.get(0).getTrackPosition());
        playlistAdapter = new PlaylistAdapter(this, trackTemplateList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(playlistAdapter);
        mAPIservice = APIUtils.getAPIService();
        Map<String, String> map = new HashMap<>();
        map.put("Content-Type", "application/json");
        map.put("Authorization", "Bearer " + "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6IjI1OTZjMmY2ZjljMTAwYzE1ZWE4MThkMzQ5ZjM5YzZmN2Y5NTA5M2EyMjcyY2VmMDMzOGYzYjA2MDgyNGQxNjdjZDk1ZGY3YmM5YmVkNDI4In0.eyJhdWQiOiI3Ii" +
                "wianRpIjoiMjU5NmMyZjZmOWMxMDBjMTVlYTgxOGQzNDlmMzljNmY3Zjk1MDkzYTIyNzJjZWYwMzM4ZjNiMDYwODI0ZDE2N2NkOTVkZjdiYzliZWQ0MjgiLCJpYXQiOjE1OTcwODgzMTUsIm5iZiI6MTU5NzA4ODMxNSwiZXhwIjoxNjI4NjI0MzE1LCJzdWIiOiIxMDc3Iiwic2NvcGVzIjpb" +
                "XX0.TsCkSv35mUfNlS_QtvN3eJXxWaelZ20ixVdiHQnJ6QDxEPpUvEQ_rqZ3GCTBVy4lRSjh3EdC8Icb38ALDZXkzFXQHU-cxa3coTvoFwT-b3mFK9dbZAAyyPm3u_OEL9NRlBNTd_J-9t0g3uqhGd7sfq7KPzBIYKq3_KJPMg-IWkyiKg8R_jsF4dOpqK199qHToU3AmRa4j0jJZ50WAX2NWd_FHTvrxm6" +
                "pNjjBL6UFOHdv3w1xZx0FcEg6w2QB_PL71CEq9AnKEcz9PrUikCE6GqdZSS5MBkKMiiyX_-uNGPma95KbxX7-Bh32FvcgmRCJ2qx6kyoWCn_UPFy-Y8ynUQiIkBMsw5RV79yjhYtiydrNJeBnHlqn5a7uEFq8W6-ATFZQ7MIR_8c444YHs8OVqCrm2Vne-i74JCLerMvcY2x8QIA66-xFLDjXYKitO9wJBvJyUJFsk" +
                "ubsUMi3WYnn9wJvMCwbWKbgrVsTJKO2sPcMd2g72QgZ7hqFK8HKW5nF_qQO3bmdBZZYJ--tRXlwbiEweD7L9aOx05oEFmFTdGIAgGen6wDVwV0m1_66YpBIWa-g7dsl9HVnwbo2sRamaxNFIxUYfmJlsuOuQOrZSaI19CZGRvhQSQ9cQMVIZWi79nVk5jh-6oZhIzBxrzPGEdVRkNSNVwQvYOMyxoAJiXs");
        mAPIservice.getPlaylistsTrack(map,"1").enqueue(new Callback<Track>() {
            @Override
            public void onResponse(Call<Track> call, Response<Track> response) {
                if(response.isSuccessful()){
                    Log.d("getplaylist","success!");
                }
            }

            @Override
            public void onFailure(Call<Track> call, Throwable t) {

            }
        });
    }
}
