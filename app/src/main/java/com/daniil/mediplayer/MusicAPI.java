
package com.daniil.mediplayer;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MusicAPI {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("tracks")
    @Expose
    private List<Track> tracks = null;
    @SerializedName("cover_url")
    @Expose
    private String coverUrl;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("rate")
    @Expose
    private Integer rate;
    @SerializedName("is_demo")
    @Expose
    private Boolean isDemo;
    @SerializedName("en_description")
    @Expose
    private String enDescription;
    @SerializedName("en_name")
    @Expose
    private String enName;
    @SerializedName("jamendo_name")
    @Expose
    private String jamendoName;
    @SerializedName("user_id")
    @Expose
    private Object userId;
    @SerializedName("is_updated")
    @Expose
    private Integer isUpdated;
    @SerializedName("archive_url")
    @Expose
    private String archiveUrl;
    @SerializedName("favorite")
    @Expose
    private Boolean favorite;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Boolean getIsDemo() {
        return isDemo;
    }

    public void setIsDemo(Boolean isDemo) {
        this.isDemo = isDemo;
    }

    public String getEnDescription() {
        return enDescription;
    }

    public void setEnDescription(String enDescription) {
        this.enDescription = enDescription;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getJamendoName() {
        return jamendoName;
    }

    public void setJamendoName(String jamendoName) {
        this.jamendoName = jamendoName;
    }

    public Object getUserId() {
        return userId;
    }

    public void setUserId(Object userId) {
        this.userId = userId;
    }

    public Integer getIsUpdated() {
        return isUpdated;
    }

    public void setIsUpdated(Integer isUpdated) {
        this.isUpdated = isUpdated;
    }

    public String getArchiveUrl() {
        return archiveUrl;
    }

    public void setArchiveUrl(String archiveUrl) {
        this.archiveUrl = archiveUrl;
    }

    public Boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

}
