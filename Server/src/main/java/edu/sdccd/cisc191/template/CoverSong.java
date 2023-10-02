package edu.sdccd.cisc191.template;

public class CoverSong extends Song {

    int releaseDate;
    String album;
    String ultimateGuitarLink;

    public CoverSong(){

    }

    public CoverSong(String title, String artist, String key, String progression, String change, String notes,
                     int releaseDate, String album, String ultimateGuitarLink) {
        super(title, artist, key, progression, change, notes);
        this.releaseDate = releaseDate;
        this.album = album;
        this.ultimateGuitarLink = ultimateGuitarLink;
    }

    // Getters and setters
    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getUltimateGuitarLink() {
        return ultimateGuitarLink;
    }

    public void setUltimateGuitarLink(String ultimateGuitarLink) {
        this.ultimateGuitarLink = ultimateGuitarLink;
    }
}

