package com.daniil.mediplayer;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class PlaylistAdapter extends RecyclerView.Adapter<PlaylistAdapter.CustomViewHolder>{

    private Context context;
    private List<TrackTemplate> trackTemplateList;

    public PlaylistAdapter(Context context, List<TrackTemplate> trackTemplateList){
        this.context = context;
        this.trackTemplateList = trackTemplateList;

    }

    class CustomViewHolder extends RecyclerView.ViewHolder{
        TextView txt_ArtistName;
        TextView txt_SongName;
        TextView txt_trackTime;
        ImageView img_trackImage;
        TextView txt_songPosition;
        ConstraintLayout constraintLayout;

        public final View mview;

        CustomViewHolder(View itemview){
            super(itemview);
            mview = itemview;
            txt_ArtistName = mview.findViewById(R.id.artistname);
            txt_SongName = mview.findViewById(R.id.songname);
            txt_trackTime = mview.findViewById(R.id.tracktime);
            img_trackImage = mview.findViewById(R.id.songimage);
            txt_songPosition = mview.findViewById(R.id.songnumber);
            constraintLayout = mview.findViewById(R.id.constraintLayout_p);

        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewtype){
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recycleview_item, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, final int position) {

        holder.txt_ArtistName.setText(trackTemplateList.get(position).getArtistName());
        holder.txt_SongName.setText(trackTemplateList.get(position).getSongName());
        holder.txt_trackTime.setText(trackTemplateList.get(position).getTrackTime());
        holder.txt_songPosition.setText(trackTemplateList.get(position).getTrackPosition());
        Glide.with(context).load(trackTemplateList.get(position).getTrackImage()).centerCrop().into(holder.img_trackImage);
        Log.d("image",trackTemplateList.get(position).getTrackImage());
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity.class);
                intent.putExtra("song_name", trackTemplateList.get(position).getSongName());
                intent.putExtra("artist_name", trackTemplateList.get(position).getArtistName());
                intent.putExtra("track_time", trackTemplateList.get(position).getTrackTime());
                intent.putExtra("track_image", trackTemplateList.get(position).getTrackImage());
                intent.putExtra("songPosition", trackTemplateList.get(position).getTrackPosition());
                context.startActivity(intent);

                //for each parameter, do the thing above except for song position. also finish the player style in figma
            }
        });
        //finish rest of the variables
    }

    @Override
    public int getItemCount() {
        return trackTemplateList.size();
    }

}
