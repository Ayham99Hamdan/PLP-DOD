
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import static javafx.application.Platform.exit;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class StartPane extends StackPane{
    
        Label GameName = new Label("Destroy Or Deffender");
        Button start = new Button("Start");
        Button exit = new Button("exit");
        public  StartPane() throws FileNotFoundException{
        GameName.setFont(new Font("tahoma", 40));
        this.setAlignment(GameName, Pos.TOP_CENTER);
        GameName.setTextFill(Color.color(0.5, 0.6, 0.2));
        ImageView Background = new ImageView(new Image(new FileInputStream("C:\\Users\\USER\\Desktop\\java lab\\StartBackground.jpg")));
        Background.setFitWidth(500);
        Background.setFitHeight(500);
        
        exit.setTranslateY(80);
        start.setFont(new Font("tahoma", 30));
        start.setTextFill(Color.color(0.5, 0.6, 0.2));
        start.setPrefSize(200, 50);
        start.setStyle("-fx-background-color:#AAA;");
        exit.setFont(new Font("tahoma", 30));
        exit.setTextFill(Color.color(0.5, 0.6, 0.2));
        exit.setPrefSize(200, 50);
        exit.setStyle("-fx-background-color:#AAA;");
        this.getChildren().addAll(Background,GameName, start,exit);
         
        exit.setOnAction((ActionEvent event) -> {
        
            exit();
        
        });
        }
        
}
