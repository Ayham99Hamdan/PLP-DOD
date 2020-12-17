
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author USER
 */
public class Player {

    protected int teamId;
    protected int coins = 50;
    protected String playerName;
    
    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void newGame() {
    }

    public int getCoins() {
        return coins;
    }

    
    
    public void loadGame() {
    }

    public void bayUnit() {
        
    }

}
