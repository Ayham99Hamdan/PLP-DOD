/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Platform.exit;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author USER
 */
public class Main extends Application {
    
    StackPane Boardroot = new StackPane();
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        
        StackPane root = new StackPane();
        StartPane start = new StartPane();
        playerInfo info = new playerInfo();
        
        root.getChildren().addAll(start,info);
        Scene initScene = new Scene(root,500,500);
        
        info.setVisible(false);
        primaryStage.setTitle("Destroy Or Deffender");
        primaryStage.setScene(initScene);
        primaryStage.setResizable(false);
        primaryStage.show();
        start.start.setOnAction((ActionEvent event) -> {
            start.setVisible(false);
            info.setVisible(true);
        });
       info.btn.setOnAction((ActionEvent event) -> {
            info.handlePlayerinfo();
            info.setVisible(false);
            
            primaryStage.hide();
            try {
                showArena();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        
        /*
        
        // Start of board
        Arena arena = Arena.getInstance();
        ScrollPane ArenaContainer = new ScrollPane();
        ArenaContainer.setMaxSize(700, 700);
        ArenaContainer.setTranslateX(-50);
        ArenaContainer.setContent(arena);
        arena.getArenaReady();
        
        root.getChildren().add(ArenaContainer);

        // End of Board
        // Start of Store  
        Store store = Store.getInstance();
        ScrollPane StoreContainer = new ScrollPane();
        StoreContainer.setMaxSize(150, 700);
        StoreContainer.setTranslateX(-500);
        StoreContainer.setContent(store);
        
        store.getStoreRaedy();

        root.getChildren().add(StoreContainer);
        // End of Store
        Scene scene = new Scene(root, 1200, 700);
        
        
        primaryStage.setTitle("DoD Game");
        primaryStage.setScene(scene);
        primaryStage.show();
       */
    }
    public void showArena() throws FileNotFoundException{
        
         // Start of board
        Arena arena = Arena.getInstance();
        ScrollPane ArenaContainer = new ScrollPane();
        ArenaContainer.setMaxSize(700, 700);
        ArenaContainer.setTranslateX(-50);
        ArenaContainer.setContent(arena);
        arena.getArenaReady();
        
       

        // End of Board
        // Start of Store  
        Store store = Store.getInstance();
        ScrollPane StoreContainer = new ScrollPane();
        StoreContainer.setMaxSize(150, 700);
        StoreContainer.setTranslateX(-500);
        StoreContainer.setContent(store);
        
        store.getStoreRaedy();
        unitInfo unitinfo = unitInfo.getInstance();
        Boardroot.getChildren().addAll(StoreContainer,ArenaContainer,unitinfo);
        
        Stage SecondStage = new Stage();
        Scene game = new Scene(Boardroot,1200,700);
        SecondStage.setTitle("DoD");
        SecondStage.setScene(game);
        SecondStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
