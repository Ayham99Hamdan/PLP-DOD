
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
    protected int coins = 150;
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

    
    
    public void loadGame() {
    }

    public void bayUnit() {
        Scanner read = new Scanner(System.in);
        DoDGameManager manager = DoDGameManager.getInstance();
        while (coins > 0) {
            System.out.println("[1]TeslaTank 50\n[2]Sniper 5\n[3]MirageTank 70\n[4]Infantry 3\n[5]GrizzlyTank 50\n[6]NavySeal 10\n[7]TankDestroyer 50"
                    + "\n[8]prismTank 60\n[9]PillBox 150\n[10]PrismTower 150\n[11]Grandcannon 200\n[12]BlackEagle 75\n[13]patriotMissileSystem 175\n[0] exit");
            int choise = read.nextInt();
            if(choise == 0){
                
                return;
            
            }
            System.out.println("please enter X then Y Positions");
            int x = read.nextInt();
            int y = read.nextInt();
            switch (choise) {

                case 1:
                    manager.BayUnit(this, x, y, UnitType.TeslaTank);
                    break;
                case 2:
                    manager.BayUnit(this, x, y, UnitType.Sniper);
                    break;
                case 3:
                    manager.BayUnit(this, x, y, UnitType.MirageTank);
                    break;
                case 4:
                    manager.BayUnit(this, x, y, UnitType.Infantry);
                    break;
                case 5:
                    manager.BayUnit(this, x, y, UnitType.GrizzlyTank);
                    break;
                case 6:
                    manager.BayUnit(this, x, y, UnitType.NavySEAL);
                    break;
                case 7:
                    manager.BayUnit(this, x, y, UnitType.TankDestroyer);
                    break;
                case 8:
                    manager.BayUnit(this, x, y, UnitType.PrismTank);
                    break;
                case 9:
                    manager.BayUnit(this, x, y, UnitType.Pillbox);
                    break;
                case 10:
                    manager.BayUnit(this, x, y, UnitType.PrismTower);
                    break;
                case 11:
                    manager.BayUnit(this, x, y, UnitType.GrandCannon);
                    break;
                case 12:
                    manager.BayUnit(this, x, y, UnitType.BlackEagle);
                    break;
                case 13:
                    manager.BayUnit(this, x, y, UnitType.PatriotMissileSystem);
                    break;
                

                default:
                    break;
            }

        }
    }

}
