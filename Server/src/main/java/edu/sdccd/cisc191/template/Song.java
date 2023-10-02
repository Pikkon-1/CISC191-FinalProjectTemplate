package edu.sdccd.cisc191.template;

public class Song {


    private String title;
    private String artist;
    private String key;
    private String progression;
    private String change;
    private String notes;

    public Song(){

    }
    public Song(String title, String artist, String key, String progression, String change, String notes) {
        this.title = title;
        this.artist = artist;
        this.key = key;
        this.progression = progression;
        this.change = change;
        this.notes = notes;
    }

    // Getters and setters ()
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getProgression() {
        return progression;
    }

    public void setProgression(String progression) {
        this.progression = progression;
    }

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    // methods
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Title: ").append(getTitle()).append("\n");
        sb.append("Artist: ").append(getArtist()).append("\n");
        sb.append("Key: ").append(getKey()).append("\n");

        sb.append("Progression: ").append(getProgression()).append("\n");
        sb.append("Change: ").append(getChange()).append("\n");
        sb.append("Notes: ").append(getNotes()).append("\n");
        return sb.toString();
    }

}
