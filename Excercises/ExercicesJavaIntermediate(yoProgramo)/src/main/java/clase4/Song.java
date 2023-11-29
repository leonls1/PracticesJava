/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase4;

import clase4.states.Regular;
import clase4.states.State;
import java.util.Date;

public class Song {
    
    private String albumName, title, artistName, caption;
    private int albumYear, likes, dislikes, totalViews;
    private State state;
    private Icon icon;
    private Date lastView;
    
    public String getAlbumName() {
        return albumName;
    }
    
    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getArtistName() {
        return artistName;
    }
    
    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }
    
    public String getCaption() {
        return caption;
    }
    
    public void setCaption(String caption) {
        this.caption = caption;
    }
    
    public int getAlbumYear() {
        return albumYear;
    }
    
    public void setAlbumYear(int albumYear) {
        this.albumYear = albumYear;
    }
    
    public int getLikes() {
        return likes;
    }
    
    public void setLikes(int likes) {
        this.likes = likes;
    }
    
    public int getDislikes() {
        return dislikes;
    }
    
    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }
    
    public int getTotalViews() {
        return totalViews;
    }
    
    public void setTotalViews(int totalViews) {
        this.totalViews = totalViews;
    }
    
    
    public Icon getIcon() {
        return icon;
    }
    
    public void setIcon(Icon icon) {
        this.icon = icon;
    }
    
    public Date getLastView() {
        return lastView;
    }
    
    public void setLastView(Date lastView) {
        this.lastView = lastView;
    }
    
    public Song(String albumName, String title, String artistName, int albumYear, int likes, int dislikes, int totalViews, Date lastView) {
        this.albumName = albumName;
        this.title = title;
        this.artistName = artistName;
        this.albumYear = albumYear;
        this.likes = likes;
        this.dislikes = dislikes;
        this.totalViews = totalViews;
        this.lastView = lastView;
        state = new Regular();
        icon = Icon.MUSICAL_NOTE;
        caption = artistName + " - " + albumName + " - " + title;
        
        
    }

    public void setState(State state) {
        this.state = state;
    }
    
    
    public void toBoom() {
        state.toBooom(this);
    }
    
    public void toRegular() {
        state.toRegular(this);
    }
    
    public void toTrend() {
        state.toTrend(this);
        
    }
    
    public void show() {
        System.out.println(getIcon() + getCaption() + "\n");
    }
    
}
