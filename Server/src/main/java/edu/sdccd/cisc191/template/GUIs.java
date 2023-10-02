package edu.sdccd.cisc191.template;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GUIs implements EventHandler<ActionEvent>  {
    private final Stage primaryStage;
    private final FileCreation files;
    private Button startButton;
    private Button quitButton;
    private Button addSongButton;
    private Button editSongButton;
    private Button findSongButton;
    private Button submitButton;
    private Button cancelButton;
    private Button exitButton;

    private TextField titleText;
    private TextField artistText;
    private TextField keyText;
    private TextField progressionText;
    private TextField changeText;
    private TextArea notesText;

    //FileCreation files = new FileCreation();



    public GUIs(Stage primaryStage, FileCreation files) {
        this.primaryStage = primaryStage;
        this.files = files;
    }

    /// Add song(doneish), edit song(doneish), find song(doneish), view library, create a playlist(maybe put in view??), quit(doneish)
    public void createIntroGUI() {

        //System.out.println(files.getFilePath());
        BorderPane layout = new BorderPane();

        // Create a label for the welcome message
        Label welcomeLabel = new Label("Welcome to SongThing");
        // Set the label at the top of the layout
        layout.setTop(welcomeLabel);


        startButton = new Button("Start");
        startButton.setOnAction(this);
        // Set the button at the bottom of the layout
        layout.setBottom(startButton);

        Scene introScene = new Scene(layout, 500, 500);

        primaryStage.setScene(introScene);
        //primaryStage.show();
    }

    private void menu() {
        // Create content for scene 2
        addSongButton = new Button("Add a New Song");
        editSongButton = new Button("Edit a Song");
        findSongButton = new Button("Find a Song");
        Button viewLibraryButton = new Button("View Entire Library");
        Button createPlaylistButton = new Button("Create a Playlist");
        quitButton = new Button("Quit Application");
        quitButton.setOnAction(this);
        editSongButton.setOnAction(this);
        addSongButton.setOnAction(this);
        findSongButton.setOnAction(this);

        // Create a VBox layout to hold the buttons
        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(
                addSongButton, editSongButton, findSongButton,
                viewLibraryButton, createPlaylistButton, quitButton
        );

        // Create a scene and set it in the stage
        Scene scene = new Scene(vbox, 500, 500);
        primaryStage.setScene(scene);


        //StackPane layout = new StackPane(backButton);
        //Scene scene2 = new Scene(layout, 500, 400);

        // Switch to scene 2
        primaryStage.setScene(scene);
    }

    private void addSongScreen(){
        //Labels and texts for the various attributes
        Text titleLabel = new Text("Title");

        titleText = new TextField();

        Text artistLabel = new Text("Artist");

        artistText = new TextField();

        Text keyLabel = new Text("Key");

        keyText = new TextField();

        Text progressionLabel = new Text("Chords");

        progressionText = new TextField();

        Text changeLabel = new Text("Change");

        changeText = new TextField();

        Text notesLabel = new Text("Notes");

        notesText = new TextArea();

        submitButton = new Button("Submit");
        cancelButton = new Button("Back");

        //maybe do genre later??

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(500, 500);

        gridPane.setPadding(new Insets(10, 10, 10, 10));

        gridPane.setVgap(5);
        gridPane.setHgap(5);

        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(titleLabel, 0, 0);
        gridPane.add(titleText, 1, 0);
        gridPane.add(artistLabel, 0, 1);
        gridPane.add(artistText, 1, 1);
        gridPane.add(keyLabel, 0, 2);
        gridPane.add(keyText, 1, 2);
        gridPane.add(progressionLabel, 0, 3);
        gridPane.add(progressionText, 1, 3);
        gridPane.add(changeLabel, 0, 4);
        gridPane.add(changeText, 1, 4);
        gridPane.add(notesLabel, 0, 5);
        gridPane.add(notesText, 1, 5);

        // pop ups?
        gridPane.add(submitButton, 1, 6);
        gridPane.add(cancelButton, 0, 6);
        submitButton.setOnAction(this);
        cancelButton.setOnAction(this);


        Scene scene = new Scene(gridPane, 600, 500);


        primaryStage.setScene(scene);

        // Set the title and show the stage
        primaryStage.setTitle("Song adding Form");

    }

    private void editSongScreen(){
        //labels and text fields
        Label songNameLabel = new Label("Song Name:");
        TextField songSearch = new TextField();

        //text area for the results
        TextArea resultTextArea = new TextArea();
        resultTextArea.setPromptText("Search results will appear here...");
        resultTextArea.setEditable(false);

        // search button and an exit button
        Button searchButton = new Button("Search");
        exitButton = new Button("Exit");

        //HBox for exit and search buttons at the bottom of the screen
        HBox buttonBox = new HBox(10); // 10 pixels spacing between components
        buttonBox.setAlignment(Pos.CENTER_RIGHT); // Align buttons to the right
        buttonBox.getChildren().addAll(exitButton, searchButton);

        // vBox code
        VBox vbox = new VBox(10); // 10 pixels spacing between components
        vbox.setPadding(new Insets(20)); // 20 pixels padding around the layout
        vbox.getChildren().addAll(songNameLabel, songSearch, resultTextArea, buttonBox);

        exitButton.setOnAction(this);
        // the main scene
        Scene scene = new Scene(vbox, 500, 500);

        // stage
        primaryStage.setTitle("Edit a Song");
        primaryStage.setScene(scene);

        //stage.show();

    }

    public void findSongScreen() {

        Label songNameLabel = new Label("Song Name:");
        TextField songSearch = new TextField();


        TextArea resultTextArea = new TextArea();
        resultTextArea.setPromptText("Search results will appear here...");
        resultTextArea.setEditable(false);


        Button searchButton = new Button("Search");
        exitButton = new Button("Exit");

        // Create an HBox for exit and search buttons at the bottom
        HBox buttonBox = new HBox(10); // 10 pixels spacing between components
        buttonBox.setAlignment(Pos.CENTER_RIGHT); // Align buttons to the right
        buttonBox.getChildren().addAll(exitButton, searchButton);


        VBox vbox = new VBox(10); // 10 pixels spacing between components
        vbox.setPadding(new Insets(20)); // 20 pixels padding around the layout
        vbox.getChildren().addAll(songNameLabel, songSearch, resultTextArea, buttonBox);

        exitButton.setOnAction(this);

        Scene scene = new Scene(vbox, 500, 500);


        primaryStage.setTitle("Edit a Song");
        primaryStage.setScene(scene);

        //stage.show();


    }


    public void createAPlaylist(){
        // Create labels and text fields
        Label songNameLabel = new Label("Song Name:");
        TextField songSearch = new TextField();

        // Create a text area for displaying results
        TextArea resultTextArea = new TextArea();
        resultTextArea.setPromptText("Search results will appear here...");
        resultTextArea.setEditable(false);

        // Create a search button and an exit button
        Button searchButton = new Button("Search");
        exitButton = new Button("Exit");

        // Create an HBox for exit and search buttons at the bottom
        HBox buttonBox = new HBox(10); // 10 pixels spacing between components
        buttonBox.setAlignment(Pos.CENTER_RIGHT); // Align buttons to the right
        buttonBox.getChildren().addAll(exitButton, searchButton);

        // vBox code
        VBox vbox = new VBox(10); // 10 pixels spacing between components
        vbox.setPadding(new Insets(20)); // 20 pixels padding around the layout
        vbox.getChildren().addAll(songNameLabel, songSearch, resultTextArea, buttonBox);

        exitButton.setOnAction(this);
        // Create the main scene
        Scene scene = new Scene(vbox, 400, 300);

        // Create a stage and set the scene
        primaryStage.setTitle("Edit a Song");
        primaryStage.setScene(scene);

        //stage.show();

    }

    /// handle button presses
    @Override
    public void handle(ActionEvent event) {

        // intro buttons
        if (event.getSource() == startButton || event.getSource() == cancelButton || event.getSource() == exitButton) {
            menu();
        }

        if (event.getSource() == quitButton) {
            primaryStage.close();

        }

        // menu buttons
        if (event.getSource() == addSongButton) {
            addSongScreen();
        }

        if (event.getSource() == editSongButton){
            editSongScreen();
        }

        if (event.getSource() == findSongButton){
            findSongScreen();
        }

        if (event.getSource() == submitButton) {
            files.addNewOriginalSong(titleText.getText(), artistText.getText(), keyText.getText(), progressionText.getText(), changeText.getText(), notesText.getText(),
                    true, true, "Jackson");

        }
        if (event.getSource() == cancelButton) {
            menu();

        }
    }


    /// methods
    public void addSong(){
        System.out.println("hello");
        System.out.println(files.getFilePath());
        System.out.println("bye");
        String title = titleText.getText();
        String artist = artistText.getText();
        String key = keyText.getText();
        String progression = progressionText.getText();
        String change = changeText.getText();
        String notes = notesText.getText();
        //files.addNewSong4(title, artist, key, progression, change, notes);
    }

    public void theUsualScreen(String title){
        // Create labels and text fields
        Label songNameLabel = new Label("Song Name:");
        TextField songSearch = new TextField();

        // Create a text area for displaying results
        TextArea resultTextArea = new TextArea();
        resultTextArea.setPromptText("Search results will appear here...");
        resultTextArea.setEditable(false);

        // Create a search button and an exit button
        Button searchButton = new Button("Search");
        exitButton = new Button("Exit");

        // Create an HBox for exit and search buttons at the bottom
        HBox buttonBox = new HBox(10); // 10 pixels spacing between components
        buttonBox.setAlignment(Pos.CENTER_RIGHT); // Align buttons to the right
        buttonBox.getChildren().addAll(exitButton, searchButton);

        // vBox code
        VBox vbox = new VBox(10); // 10 pixels spacing between components
        vbox.setPadding(new Insets(20)); // 20 pixels padding around the layout
        vbox.getChildren().addAll(songNameLabel, songSearch, resultTextArea, buttonBox);

        exitButton.setOnAction(this);
        // Create the main scene
        Scene scene = new Scene(vbox, 400, 300);

        // Create a stage and set the scene
        primaryStage.setTitle(title);
        primaryStage.setScene(scene);

        //stage.show();

    }

}
