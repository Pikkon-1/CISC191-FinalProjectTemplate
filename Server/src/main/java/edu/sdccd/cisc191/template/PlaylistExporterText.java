package edu.sdccd.cisc191.template;

import java.util.List;

// maybe create a text file on your desktop??
public class PlaylistExporterText implements PlaylistExporter {
    @Override
    public String export(Playlist playlist) {
        StringBuilder sb = new StringBuilder();
        List<Song> songs = playlist.getSongs();

        sb.append("Playlist:\n");
        for (Song song : songs) {
            //sb.append(song.getTitle()).append(" - ").append(song.getArtist()).append("\n");
            sb.append(song);
        }

        return sb.toString();
    }
}