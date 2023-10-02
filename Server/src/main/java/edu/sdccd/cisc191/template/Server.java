package edu.sdccd.cisc191.template;
import javafx.application.Application;
import javafx.stage.Stage;


public class Server extends Application{
    private static FileCreation files; // Declare files as an instance variable


    public static void main(String[] args) {
        files = new FileCreation();
        files.createNewFile();
        launch(args);

        Menu menu = new Menu();
        // checks for a saved file if none creates one.


        menu.mainMenu(files);

    PlaylistExporter exporter = new PlaylistExporterText();
    exporter.export(new Playlist()); // TODO create playlist
        }



    public void start(Stage primaryStage) throws Exception {
        GUIs GUIManager = new GUIs(primaryStage, files);
        GUIManager.createIntroGUI();

        primaryStage.show();
    }



}


