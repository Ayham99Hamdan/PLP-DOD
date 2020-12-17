/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import static javafx.scene.control.ContentDisplay.CENTER;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author USER
 */
public class UnitGui extends FlowPane {

    private String Name;
    private Image img;
    public UnitGui(UnitType type) throws FileNotFoundException {
        this.Name = type.getName();
        System.out.println(Name);
        img = new Image(new FileInputStream("C:\\Users\\USER\\Desktop\\java lab\\image play\\" + Name +".jpg"));
        ImageView imageView = new ImageView(img);
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);
        Label unit = new Label(Name, imageView);
        unit.setContentDisplay(ContentDisplay.BOTTOM);
        this.setOrientation(Orientation.HORIZONTAL);
        this.setPrefSize(USE_PREF_SIZE, USE_PREF_SIZE);
        this.setStyle("-fx-border-color: #000;\n"
                + "    -fx-border-width: 1px;\n"
                + "    -fx-border-style: solid;");
        Button bayButton = new Button("Bay Unti");
        bayButton.setStyle("-fx-color: #F00;");
        bayButton.setPrefWidth(100);
        bayButton.setOnAction((event) -> {
  //          owner = Store.getInstance().getCurrentPlayer();
//            Arena.getInstance().getPositionOnArena();
//            int x = Arena.getInstance().getPosX();
//            int y = Arena.getInstance().getPosY();
//            //owner.bayUnit(x, y, UnitType.TeslaTank);
        unitInfo.getInstance().setDisable(false);
        unitInfo.getInstance().acceptUnitInfo(type);
        });
        getChildren().add(unit);
        getChildren().add(bayButton);
    }

}
