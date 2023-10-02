package edu.sdccd.cisc191.template;

public class OriginalSong extends Song{

    private boolean songFinished;
    private boolean songReleased;
    private String collaborators;

    //// Constructors
    public OriginalSong() {

    }

    public OriginalSong(String title, String artist, String key, String progression, String change, String notes,
                        boolean songFinished, boolean songReleased, String collaborators) {
        super(title, artist, key, progression, change, notes);
        this.songFinished = songFinished;
        this.songReleased = songReleased;
        this.collaborators = collaborators;
    }

    /// method
    public boolean isSongFinished(){
        return songFinished;
    }

    public void setSongFinished(boolean songFinished) {
        this.songFinished = songFinished;
    }

    public boolean isSongReleased(){
        if (!this.songFinished){
            songReleased = false;

        }
        return songReleased;
    }

    public void setSongReleased(boolean songReleased) {
        this.songReleased = songReleased;
    }

    public String getCollaborators() {
        return collaborators;
    }

    public void setCollaborators(String collaborators) {
        this.collaborators = collaborators;
    }



}
