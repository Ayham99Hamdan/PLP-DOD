
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
public class playerInfo extends StackPane {

    private ArrayList<Group> playerlist = new ArrayList();
    String team[] = {"Deffender", "Attacker"};
    Button btn = new Button("click");
    public playerInfo() throws FileNotFoundException {

        Label GameName = new Label("Destroy Or Deffender");
        GameName.setFont(new Font("tahoma", 40));
        this.setAlignment(GameName, Pos.TOP_CENTER);
        GameName.setTextFill(Color.color(0.5, 0.6, 0.2));
        ImageView Background = new ImageView(new Image(new FileInputStream("C:\\Users\\USER\\Desktop\\java lab\\StartBackground.jpg")));
        Background.setFitWidth(500);
        Background.setFitHeight(500);
        this.getChildren().addAll(Background, GameName);
        Label Name = new Label("Player Name");
        Name.setTextFill(Color.color(0.5, 0.6, 0.2));
        Name.setFont(new Font("tahoma", 20));
        Name.setTranslateX(-100);
        Name.setTranslateY(-120);
        Label Team = new Label("Team");
        this.getChildren().add(Name);
        Team.setTextFill(Color.color(0.5, 0.6, 0.2));
        Team.setFont(new Font("tahoma", 20));

        Team.setTranslateX(0);
        Team.setTranslateY(-120);
        this.getChildren().add(Team);
        for (int i = 0; i < 4; i++) {
            Group player = new Group();
            TextField PlayerName = new TextField();
            PlayerName.setMaxWidth(100);
            player.setTranslateX(-50);
            player.setTranslateY(Name.getTranslateY() - (-30 * (i + 1)));
            ChoiceBox teamChoice = new ChoiceBox(FXCollections.observableArrayList(team));
            teamChoice.setTranslateX(100);
            player.getChildren().addAll(PlayerName, teamChoice);
            this.getChildren().add(player);
            playerlist.add(player);
        }
        
        btn.setTranslateX(200);
        btn.setTranslateY(200);
        
        this.getChildren().add(btn);
    }

    public void handlePlayerinfo() {

        String Name = null;
        int team = -1;
        for (Group member : playerlist) {

            Node node = member.getChildren().get(0);
            if (node instanceof TextField) {

                Name = ((TextField) node).getText();

            }
            node = member.getChildren().get(1);
            if (node instanceof ChoiceBox) {

                team = ((ChoiceBox) node).getSelectionModel().getSelectedIndex();

            }

            if (Name != null && team != -1) {
                GuiPlayer player = new GuiPlayer();
                player.setPlayerName(Name);
                player.setTeamId(team + 1);

                if (player.getTeamId() == 1) {

                    DeffenderTeam Deffender = DeffenderTeam.getInstance();
                    Deffender.addPlayerToTeam(player);

                } else {

                    AttackerTeam Attacker = AttackerTeam.getInstance();
                    Attacker.addPlayerToTeam(player);

                }
               Store.getInstance().playerList.add(player);

            }

        }

    }

}
