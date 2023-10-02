package edu.sdccd.cisc191.template;
import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private final List<Song> songs;

    public Playlist() {
        songs = new ArrayList<>();
    }

    // Add a song to the playlist
    public void addSong(Song song) {
        songs.add(song);
    }

    // Remove a song from the playlist
    public void removeSong(Song song) {
        songs.remove(song);
    }

    // Get all songs in the playlist
    public List<Song> getSongs() {
        return songs;
    }

    // Clear all songs from the playlist
    public void clear() {
        songs.clear();
    }

    // Get the number of songs in the playlist
    public int size() {
        return songs.size();
    }

    // Check if the playlist is empty
    public boolean isEmpty() {
        return songs.isEmpty();
    }

}