/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

/**
 *
 * @author DELL
 */
public class Arena extends StackPane{
    
    private static Arena instance;
    
    private int PosX;
    private int PosY;
    private Arena(){}
    public static Arena getInstance(){
    
        if (instance == null) {

            instance = new Arena();

        }
        return instance;

    
    }
    
    public void getArenaReady() throws FileNotFoundException{
    Image img = null;
    this.setPrefSize(1000, 1000);
    
    try{
    img = new Image(new FileInputStream("C:\\Users\\USER\\Desktop\\java lab\\SandMap.jpg"));
    } catch(Exception ex){
        ex.printStackTrace();
    }
    ImageView View = new ImageView(img);
    View.setFitWidth(1000);
    View.setFitHeight(1000);
    
    this.getChildren().add(View);
    
    
    }
    
    public void getPositionOnArena(){
    
        this.setOnMouseClicked(new EventHandler<MouseEvent>(){
        public void handle(MouseEvent event){
            unitInfo.Xpos.setText("X position : " + Integer.toString((int)event.getX() * 10));
            unitInfo.Ypos.setText("Y position : " + Integer.toString((int)event.getY() * 10));
            
            PosX = (int)event.getX() * 10;
            PosY = (int)event.getY() * 10;
            System.out.println(PosX);
            System.out.println(PosY);
            
        }
    
    });
    
    }
    
    public int getPosX(){
    
        return PosX;
    
    }
    public int getPosY(){
    
        return PosY;
    
    }
}
