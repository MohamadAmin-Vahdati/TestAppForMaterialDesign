package com.mavp.testapp;

public class Album {

    private String AlbumName, SingerName , AlbumAbout;
    private int numOfSongs , AlbumPic;

    public Album(String AlbumName, int numOfSongs, String SingerName,int AlbumPic,String AlbumAbout) {
        this.AlbumName = AlbumName;
        this.numOfSongs = numOfSongs;
        this.SingerName = SingerName;
        this.AlbumPic = AlbumPic ;
        this.AlbumAbout = AlbumAbout ;
    }

    public String getAlbumName() {
        return AlbumName;
    }

    public void setAlbumName(String albumName) {
        AlbumName = albumName;
    }

    public String getSingerName() {
        return SingerName;
    }

    public void setSingerName(String singerName) {
        SingerName = singerName;
    }

    public int getNumOfSongs() {
        return numOfSongs;
    }

    public void setNumOfSongs(int numOfSongs) {
        this.numOfSongs = numOfSongs;
    }

    public int getAlbumPic() {
        return AlbumPic;
    }

    public void setAlbumPic(int albumPic) {
        AlbumPic = albumPic;
    }

    public String getAlbumAbout() {
        return AlbumAbout;
    }

    public void setAlbumAbout(String albumAbout) {
        AlbumAbout = albumAbout;
    }
}
