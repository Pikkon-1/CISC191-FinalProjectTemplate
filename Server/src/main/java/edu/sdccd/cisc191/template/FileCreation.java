package edu.sdccd.cisc191.template;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;

public class FileCreation {
    File personalFile;
    private String fullPath;
    private final ObjectMapper objectMapper;


    public FileCreation(){
        objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        PolymorphicTypeValidator ptv = BasicPolymorphicTypeValidator.builder()
                .allowIfSubType("edu.sdccd.cisc191.template.Song")
                .allowIfSubType("edu.sdccd.cisc191.template.CoverSong")
                .allowIfSubType("edu.sdccd.cisc191.template.OriginalSong")
                .allowIfSubType("java.util.ArrayList")
                .build();
        objectMapper.activateDefaultTyping(ptv, ObjectMapper.DefaultTyping.NON_FINAL);

    }

    public String getFilePath(){
        return fullPath;
    }

    // methods //

    void createNewFile(){

        try
        {
            // creates a file on user desktop
            personalFile = new File(System.getProperty("user.home") + "/Desktop/MySongs.json");


            boolean newFileCreated = personalFile.createNewFile();

            //shows user that their saved file was either found and is being used or wasn't and was created
            if (newFileCreated){

                System.out.println("We couldn't find a saved file so we created a new one for you! \n");
            }
            else
            {
              System.out.println("We found your saved file! \n");

            }

            // full path grabbed to be used later
            fullPath = personalFile.getAbsolutePath();

        }
        catch(Exception e)
        {
            e.printStackTrace();

        }


    }



    void addNewOriginalSong(String title, String artist, String key, String progression, String change, String notes,
                      boolean songFinished, boolean songReleased, String collaborators) {

        File file = new File(fullPath);
        try {
            List<Song> songList1;

            if (file.exists() && file.length() > 0) {
                // Read the existing JSON content into songList1
                songList1 = objectMapper.readValue(file, new TypeReference<List<Song>>() {});
            } else {
                // If the file doesn't exist or is empty, create an empty songList1 to be added in later
                songList1 = new ArrayList<>();
            }

            Song newSong = new OriginalSong(title, artist, key, progression, change, notes, songFinished, songReleased, collaborators);


            // Add the new song to the list
            songList1.add(newSong);

            // Write the entire songList1 to the file, including opening and closing brackets
            objectMapper.writeValue(new FileWriter(fullPath), songList1);


            System.out.println("\n" + title + " was saved successfully!\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void addNewCoverSong(String title, String artist, String key, String progression, String change, String notes,
                            int releaseDate, String album, String ugLink) {

        File file = new File(fullPath);
        try {
            List<Song> songList1;

            if (file.exists() && file.length() > 0) {
                // Read the existing JSON content into songList1
                songList1 = objectMapper.readValue(file, new TypeReference<List<Song>>() {});
            } else {
                // If the file doesn't exist or is empty, create an empty songList1 to be added in later
                songList1 = new ArrayList<>();
            }


            Song newSong = new CoverSong(title, artist, key, progression, change, notes, releaseDate, album, ugLink);




            // Add the new song to the list
            songList1.add(newSong);

            // Write the entire songList1 to the file, including opening and closing brackets
            objectMapper.writeValue(new FileWriter(fullPath), songList1);


            System.out.println("\n" + title + " was saved successfully!\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveSongsToFile(List<Song> songs) {
        try {


            // Write the list of songs to the JSON file
            objectMapper.writeValue(new File(fullPath), songs);

            System.out.println("Songs saved successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    List<Song> readFile(){
        List<Song> songsList = new ArrayList<>();
        //System.out.println(fullPath);
        try {

            // read the contents of the JSON file and save it into a lost
            songsList = objectMapper.readValue(new File(fullPath), new TypeReference<List<Song>>() {});

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return songsList;
    }

    /*
    void addNewSong4(String title, String artist, String key, String progression, String change, String notes,
                     int originalOrNot, boolean songFinished, boolean songReleased, String collaborators) {
        // necessary for JSON
        ObjectMapper objectMapper = new ObjectMapper();

        // pretty-printing for the JSON output
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        File file = new File(fullPath);
        try {
            List<Song> songList1;

            if (file.exists() && file.length() > 0) {
                // Read the existing JSON content into songList1
                songList1 = objectMapper.readValue(file, new TypeReference<List<Song>>() {});
            } else {
                // If the file doesn't exist or is empty, create an empty songList1 to be added in later
                songList1 = new ArrayList<>();
            }

            if (originalOrNot == 1){
                Song newSong = new OriginalSong(title, artist, key, progression, change, notes, songFinished, songReleased, collaborators);
            }
            else if (originalOrNot == 2){
                Song newSong = new CoverSong(title, artist, key, progression, change, notes);
            }
            // Create the new song


            // Add the new song to the list
            songList1.add(newSong);

            // Write the entire songList1 to the file, including opening and closing brackets
            objectMapper.writeValue(new FileWriter(fullPath), songList1);


            System.out.println("\n" + title + " was saved successfully!\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

     */
}

