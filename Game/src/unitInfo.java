
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.StackPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author DELL
 */
public class unitInfo extends StackPane {

    private static unitInfo instance;
    public  static  Label Xpos = new Label();
    public  static  Label Ypos = new Label();
    private Button Accept = new Button("Accept");
    private Label playerName = new Label();
    private ToggleGroup group = new ToggleGroup();
    private unitInfo() {

        this.setMaxSize(150, 700);
        this.setTranslateX(400);
        this.setStyle("-fx-border-color: #000;\n"
                + "    -fx-border-width: 1px;\n"
                + "    -fx-border-style: solid;");
        Label label = new Label("Select Strategy");
        label.setTranslateY(-300);
        RadioButton Heighest = new RadioButton("HeighestDamage");
        Heighest.setTranslateY(-250);
        RadioButton Lowest = new RadioButton("LowestHealth");
        Lowest.setTranslateY(-200);
        
        Heighest.setToggleGroup(group);
        Lowest.setToggleGroup(group);
        Lowest.setUserData(1);
        Heighest.setUserData(2);
        Xpos.setTranslateY(-100);
        Ypos.setTranslateY(-50);
        Arena.getInstance().getPositionOnArena();
        Heighest.setSelected(true);
        
        Accept.setTranslateY(100);
        Accept.setPrefWidth(100);
        
        playerName.setTranslateY(150);
        
        
        this.getChildren().addAll(label,Heighest, Lowest,Xpos, Ypos, Accept,playerName);
        this.setDisable(true);
    }
    
    public void acceptUnitInfo(UnitType Type){
        
       playerName.setText("Player Name: " + Store.getInstance().getCurrentPlayer().getPlayerName() + "\n"
                + "Coins: " + Store.getInstance().getCurrentPlayer().getCoins());
        System.out.println(Integer.parseInt(group.getSelectedToggle().getUserData().toString()));
            System.out.println("ayham");
        
        Accept.setOnAction((ActionEvent event) -> {
            
           try {
               Store.getInstance().getCurrentPlayer().bayUnit(Arena.getInstance().getPosX(), Arena.getInstance().getPosY(),Type,Integer.parseInt(group.getSelectedToggle().getUserData().toString()));
           } catch (FileNotFoundException ex) {
               Logger.getLogger(unitInfo.class.getName()).log(Level.SEVERE, null, ex);
           }
            this.setDisable(true);
        });
    
    }

    public static unitInfo getInstance() {

        if (instance == null) {

            instance = new unitInfo();

        }
        return instance;

    }

}
