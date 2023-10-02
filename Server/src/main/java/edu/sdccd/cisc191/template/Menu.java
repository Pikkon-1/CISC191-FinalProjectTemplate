package edu.sdccd.cisc191.template;
import java.util.*;

public class Menu {

    Scanner userInput = new Scanner(System.in);

    // methods
    public void intro() {
        System.out.println("Hello welcome to SongThing!" + " Press enter to get started.");

    }

    public void mainMenu(FileCreation files) {


        System.out.println("////// Main Menu /////\n" +
                "Press 0 to add a new song \n" +
                "Press 1 to edit a song \n" +
                "Press 2 to find a song\n" +
                "Press 3 to view entire library \n" +
                "Press 4 to create a playlist\n" +
                "Press 5 to quit application");

        int selection = userInput.nextInt();
        userInput.nextLine();
        if (selection == 0) {
            createASong(files);
        } else if (selection == 1) {

            editASong(files);
        } else if (selection == 2) {
            findASong(files);
        } else if (selection == 3) {
            List<Song> fullList = files.readFile();
            for (Song song : fullList) {
                //printSongContents(song);
                System.out.println(song);

            }
            mainMenu(files);
        } else if (selection == 4) {
            createAPlaylist(files);
        } else if (selection == 5) {
            System.exit(0);
        } else {
            System.out.println("Please enter a valid input.");
        }


    }

    public void createASong(FileCreation files) {
        int originalOrNot;
        while (true) {
            Scanner userInput = new Scanner(System.in);


            System.out.println("What is the title of the song?");
            String title = userInput.nextLine();

            System.out.println("What is the artist name?");
            String artist = userInput.nextLine();

            System.out.println("What is the key of the song?");
            String key = userInput.nextLine();

            System.out.println("What is the progression of the song? (Must be in number system format i.e 'I - IV - V')");
            String progression = userInput.nextLine();

            System.out.println("What is the change in the song?");
            String change = userInput.nextLine();

            System.out.println("Do you have any special notes for this song?");
            String notes = userInput.nextLine();

            // end of song attributes below starts the questions for original song or cover song
            String originalSongQuestion = "Is this an original song (A song created by you and/or friends)?";
            originalOrNot = getValidInput(originalSongQuestion);



        // if user indicates an original song ask the below questions. Question 1 asks if song is finished

        if (originalOrNot == 1) {
            System.out.println("Is the song finished?\nPress 1 for yes and 2 for no");
            int finished = userInput.nextInt();
            //boolean songFinished = finished == 1;
            userInput.nextLine(); // clear

            // confirm that the user inputs a valid input
            while (finished != 1 && finished != 2) {
                System.out.println("Please enter a valid input");
                System.out.println("Is the song finished?\nPress 1 for yes and 2 for no");
                finished = userInput.nextInt();
                userInput.nextLine();// clears the cache
            }
            boolean songFinished = finished == 1;

            // asks if song is released (in the future maybe integrate spotify api)/ no need to ask if song is NOT finished
            boolean songReleased = false;
            if (finished == 1) {
                System.out.println("Have you and/or your friends released the song?\n Press 1 for yes and 2 for no");
                int released = userInput.nextInt();
                userInput.nextLine(); // clear


                // confirm user input is valid
                while (released != 1 && released != 2) {
                    System.out.println("Please enter a valid input");
                    System.out.println("Have you and/or your friends released the song?\nPress 1 for yes and 2 for no");
                    released = userInput.nextInt();
                    userInput.nextLine();// clears the cache
                    // no need to ask
                }
                songReleased = released == 1;

            }

            System.out.println("List all the collaborators on the song(If there are none type 'none') ");
            String collaborators = userInput.nextLine();

            files.addNewOriginalSong(title, artist, key, progression, change, notes,
                    songFinished, songReleased, collaborators);
        }



        // if song is a cover song AKA not original ask the following questions
        if (originalOrNot == 2) {
            System.out.println("What year was the song released?");
            int releaseDate = userInput.nextInt();
            userInput.nextLine();


            System.out.println("What album is this song on?");
            String album = userInput.nextLine();

            System.out.println("If you'd like to post an ultimate guitar link you can here if not type 'none'");
            String ugLink = userInput.nextLine();


            // after this line the song is added anything after concerns the loop
            files.addNewCoverSong(title, artist, key, progression, change, notes,
                    releaseDate, album, ugLink);

        }


        System.out.println("Press 1 to add another song\nPress 2 to return to the main menu");
        int choice = userInput.nextInt();
        userInput.nextLine(); // clears the cache

        if (choice == 1) {
            //userInput.nextLine();
            // Continue adding songs I've found this works best keeping it empty
        } else if (choice == 2) {
            mainMenu(files);
            break; // Exit the loop to return to the main menu
        } else {
            System.out.println("Please enter a valid choice (1 or 2).");
        }
    }

}



/// methods

    public void editASong(FileCreation files){
        StringBuilder sb = new StringBuilder();
        System.out.println("Here is a list of your songs\n");


        List<Song> editList = files.readFile();

            for (Song song : editList){
                printTitleAndArtist(song,sb);

            }

            System.out.println("\n" + sb);
            System.out.println("Please type in the name of the song you would like to edit");
            String songToEdit = userInput.nextLine();
            boolean songFound = false;

            for (Song song : editList) {
                if (songToEdit.equals(song.getTitle())){
                    songFound = true;
                    // add in logic to handle when songs have same name
                    System.out.println("You picked " + song.getTitle()+ "\n");
                    //printSongContents(song);
                    System.out.println(song);
                    System.out.println("\nPress 1 to change the title" +
                            "\nPress 2 to change the artist" +
                            "\nPress 3 to change the key" +
                            "\nPress 4 to change the progression" +
                            "\nPress 5 to change the change" +
                            "\nPress 6 to change the notes" +
                            "\nPress 7 to return to the main menu");
                    int thingToEdit = userInput.nextInt();
                    userInput.nextLine(); // to clear
                    switch (thingToEdit) {
                        case 1:
                            System.out.println("What would you like to change the title to? ");
                            String changedTitle = userInput.nextLine();
                            song.setTitle(changedTitle);
                            break;
                        case 2:
                            System.out.println("What would you like to change the artist to? ");
                            String changedArtist = userInput.nextLine();
                            song.setArtist(changedArtist);
                            break;
                        case 3:
                            System.out.println("What would you like to change the key to? ");
                            String changedKey = userInput.nextLine();
                            song.setKey(changedKey);
                            break;
                        case 4:
                            System.out.println("What would you like to change the progression to? ");
                            String changedProgression = userInput.nextLine();
                            song.setProgression(changedProgression);
                            break;
                        case 5:
                            System.out.println("What would you like to change the change to? ");
                            String changedChange = userInput.nextLine();
                            song.setChange(changedChange);
                            break;
                        case 6:
                            System.out.println("What would you like to change the notes to? ");
                            String changedNotes = userInput.nextLine();
                            song.setNotes(changedNotes);
                            break;
                        case 7:
                            mainMenu(files); // Return to the main menu
                        default:
                            System.out.println("Invalid choice.");
                    }

                    // Save the updated songs list
                    files.saveSongsToFile(editList);
                }
            }

            if (!songFound) {
                System.out.println("No song found with the specified title.");
            }


}
    public void findASong(FileCreation files){

        List<Song> finderList = files.readFile();
        boolean anySongsFound = false;

        System.out.println("How would you like to search for your song?\n" +
                "Press 1 for by Title\nPress 2 for by Artist\n" +
                "Press 3 for by Key\nPress 4 for by Progression\n");
        int choice = userInput.nextInt();
        userInput.nextLine(); // learned that using nextInt() can cause problems with using a nextLine() afterwards
        if (choice == 1){
            System.out.println("Please type in the name of the song: ");
            String songName = userInput.nextLine();
            for (Song song : finderList) {
                if (songName.equals(song.getTitle())){

                    printSongContents(song);
                    anySongsFound = true;
                }
            }
            if (!anySongsFound)
            {
                System.out.println("No songs were found with the title: " + songName);
            }

        }
        if (choice == 2){
            System.out.println("Please type in the name of the artist: ");
            String artistName = userInput.nextLine();
            for (Song song : finderList) {
                if (artistName.equals(song.getArtist())){
                    printSongContents(song);
                    anySongsFound = true;
                }
            }
            if (!anySongsFound)
            {
                System.out.println("No songs were found from the artist: " + artistName);
            }

        }

        if (choice == 3){
            System.out.println("Please type in the Key: ");
            String keyName = userInput.nextLine();
            for (Song song : finderList) {
                if (keyName.equals(song.getKey())){
                    printSongContents(song);
                    anySongsFound = true;
                }
            }
            if (!anySongsFound)
            {
                System.out.println("No songs were found within the key of: " + keyName);
            }

        }

        if (choice == 4){
            System.out.println("Must be in number system format i.e 'I - IV - V' & will search change chords as well ");
            System.out.println("Please type in the chord progression: ");
            String progression = userInput.nextLine();
            for (Song song : finderList) {
                if (progression.equals(song.getProgression()) || progression.equals(song.getChange())){
                    printSongContents(song);
                    anySongsFound = true;
                }
            }
            if (!anySongsFound)
            {
                System.out.println("No songs were found with the progression of: " + progression);
            }

        }

        // return to the main menu/ maybe add logic to ask user if they'd like to find another song
        mainMenu(files);
        anySongsFound = false;

    }


    public void randomSong(FileCreation files){
        List<Song> fullList = files.readFile();

        Random random = new Random();
        int randomNumber = random.nextInt(fullList.size());
        Song randomSong = fullList.get(randomNumber);
        System.out.println("The random song that was chosen is: ");
        printSongContents(randomSong);

    }

    public void createAPlaylist(FileCreation files){
        StringBuilder sb = new StringBuilder();
        Playlist playlist = new Playlist();
        System.out.println("Here is a list of your songs\n");

        List<Song> fullList = files.readFile();

        for (Song song : fullList){
            printTitleAndArtist(song,sb);

        }
        System.out.println("\n" + sb);

        System.out.println("Type in the name of the song you would you like to add to the playlist.");
        String input = userInput.nextLine();

        while (!input.equals("stop".toLowerCase())){
            boolean songFound = false;
            for (Song song : fullList) {
                if (input.equals(song.getTitle())) {
                    playlist.addSong(song);
                    System.out.println("\n" + song.getTitle() + " was added to the playlist!\n");
                    songFound = true;
                    break;
                }
            }
                if (!songFound) {
                    System.out.println("Sorry, the song " + input + " was not found");
                }
                System.out.println("Please enter your next song or type 'stop' to finish the playlist");
                input = userInput.nextLine();


        }
        System.out.println(playlist.getSongs());
        System.out.println("\nThis is your playlist.. what would you like to do?"+
                "\nPress 1 to export the playlist"+
                "\nPress 2 to add more songs the playlist"+
                "\nPress 3 delete a song from the playlist" +
                "\nPress 4 to delete the entire playlist");
        int playlistChoice = userInput.nextInt();
        if (playlistChoice == 1){
            PlaylistExporter exporter = new PlaylistExporterText();

            // Export the playlist to text format
            String exportedText = exporter.export(playlist);

            // Print the exported text
            System.out.println(exportedText);
            mainMenu(files);

        }



    }
    public void printSongContents(Song song){
        System.out.println("Title: " + song.getTitle());
        System.out.println("Artist: " + song.getArtist());
        System.out.println("Key: " + song.getKey());
        System.out.println("Progression: " + song.getProgression());
        System.out.println("Change: " + song.getChange());
        System.out.println("Notes: " + song.getNotes());
        System.out.println();
    }

    public void printTitleAndArtist(Song song, StringBuilder sb){

        int nameSize = song.getTitle().length();
        int artistSize = song.getArtist().length();
        int spaces = 60 - nameSize - artistSize;

        sb.append(song.getTitle());
        for (int x = 0; x < spaces; x++){
            sb.append(" ");
        }
        sb.append(song.getArtist());
        sb.append("\n");

    }

    public int getValidInput(String question ){
        while (true){
            System.out.println(question +"\nPress 1 for yes and 2 for no");
            if(!userInput.hasNextInt()){
                System.out.println("Please enter a valid input");
                userInput.next();
                continue;
            }
            int input = userInput.nextInt();
            if (input != 1 && input != 2) {
                System.out.println("Please enter a valid input");
                continue;
            }
            return input;
        }
    }
}
