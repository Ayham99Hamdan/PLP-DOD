/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author USER
 */
public class Store extends VBox {

    public ArrayList<GuiPlayer> playerList = new ArrayList();
    private GuiPlayer currentPlayer;
    private Label store = new Label("STORE");
    private static Store instance;

    private Store() {

        super(10);

    }

    public static Store getInstance() {

        if (instance == null) {

            instance = new Store();

        }
        return instance;

    }

    public void getStoreRaedy() throws FileNotFoundException {

        this.setStyle("-fx-border-color: #000;\n"
                + "    -fx-border-width: 1px;\n"
                + "    -fx-border-style: solid;");

        this.getChildren().add(new UnitGui(UnitType.TeslaTank));
        this.getChildren().add(new UnitGui(UnitType.Sniper));
        this.getChildren().add(new UnitGui(UnitType.MirageTank));
        this.getChildren().add(new UnitGui(UnitType.Infantry));
        this.getChildren().add(new UnitGui(UnitType.GrizzlyTank));
        this.getChildren().add(new UnitGui(UnitType.NavySEAL));
        this.getChildren().add(new UnitGui(UnitType.TankDestroyer));
        this.getChildren().add(new UnitGui(UnitType.PrismTank));
        this.getChildren().add(new UnitGui(UnitType.Pillbox));
        this.getChildren().add(new UnitGui(UnitType.PrismTower));
        this.getChildren().add(new UnitGui(UnitType.GrandCannon));
        this.getChildren().add(new UnitGui(UnitType.BlackEagle));
        this.getChildren().add(new UnitGui(UnitType.PatriotMissileSystem));

    }

    public GuiPlayer getCurrentPlayer() {
        currentPlayer = playerList.get(0);//Fix

        if (currentPlayer.bayingStatus) {

            System.out.println(currentPlayer.bayingStatus);
            return currentPlayer;

        } else {

            if (playerList.get(playerList.indexOf(currentPlayer) + 1) != null) {

                currentPlayer = playerList.get(playerList.indexOf(currentPlayer) + 1);
                System.out.println("Sizer");
                return currentPlayer;
            } else {
                System.out.println("Null");
                return null;
            }

        }

    }

}
