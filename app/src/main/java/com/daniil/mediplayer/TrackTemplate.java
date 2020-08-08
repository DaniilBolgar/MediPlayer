package com.daniil.mediplayer;

public class TrackTemplate {

    private String urlLink;
    private String trackPosition;
    private String artistName;
    private String songName;
    private String trackTime;
    private String trackImage;

    public String getUrlLink() {
        return urlLink;
    }

    public void setUrlLink(String urlLink) {
        this.urlLink = urlLink;
    }

    public String getTrackPosition() {
        return trackPosition;
    }

    public void setTrackPosition(String trackPosition) {
        this.trackPosition = trackPosition;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getTrackTime() {
        return trackTime;
    }

    public void setTrackTime(String trackTime) {
        this.trackTime = trackTime;
    }

    public String getTrackImage() {
        return trackImage;
    }

    public void setTrackImage(String trackImage) {
        this.trackImage = trackImage;
    }

    public TrackTemplate() {
    }

    public TrackTemplate(String urlLink, String trackPosition, String artistName, String songName, String trackTime, String trackImage) {
        this.urlLink = urlLink;
        this.trackPosition = trackPosition;
        this.artistName = artistName;
        this.songName = songName;
        this.trackTime = trackTime;
        this.trackImage = trackImage;
    }
}
