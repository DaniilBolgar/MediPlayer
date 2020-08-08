package com.daniil.mediplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class PlaylistsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TrackTemplate trackTemplate;
    private PlaylistAdapter playlistAdapter;
    private List<TrackTemplate> trackTemplateList;

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


    }
}
