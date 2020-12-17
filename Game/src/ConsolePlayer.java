
import java.io.BufferedReader;
import java.nio.Buffer;
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
public class ConsolePlayer extends Player {

    protected DoDGameManager manager = DoDGameManager.getInstance();
    @Override
    public void newGame() {
        Scanner read = new Scanner(System.in);
        
        System.out.println("how many Players:");
        int NumberOfPlayer = read.nextInt();
        for (int i = 0; i < NumberOfPlayer; i++) {
            ConsolePlayer player = new ConsolePlayer();
            System.out.println("Player " + (i + 1) + " Please Enter Your Name :");
            String playerName = read.next();
            player.setPlayerName(playerName);
            System.out.println("Select Team You Want To Join In [1]-Deffender [2]-Attacker");
            int teamId = read.nextInt();
            if (teamId == 1) {

                DeffenderTeam Deffender = DeffenderTeam.getInstance();
                player.setTeamId(1);
                Deffender.addPlayerToTeam(player);

            } else {

                AttackerTeam Attacker = AttackerTeam.getInstance();
                player.setTeamId(2);
                Attacker.addPlayerToTeam(player);

            }

        }
        
        DoDGameManager.getInstance().gameInit();
        

    }
    
    

//    public static void main(String args[]) {
//
//        new ConsolePlayer().newGame();
//        
//    }

    @Override
    public void bayUnit() {
        Scanner read = new Scanner(System.in);
        
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
             System.out.println("select Unit Strategy [1]Lowest [2]Highest");
            int strategyId =  read.nextInt();
            switch (choise) {

                case 1:
                    manager.BayUnit(this, x, y, UnitType.TeslaTank, strategyId);
                    break;
                case 2:
                    manager.BayUnit(this, x, y, UnitType.Sniper,strategyId);
                    break;
                case 3:
                    manager.BayUnit(this, x, y, UnitType.MirageTank,strategyId);
                    break;
                case 4:
                    manager.BayUnit(this, x, y, UnitType.Infantry,strategyId);
                    break;
                case 5:
                    manager.BayUnit(this, x, y, UnitType.GrizzlyTank,strategyId);
                    break;
                case 6:
                    manager.BayUnit(this, x, y, UnitType.NavySEAL,strategyId);
                    break;
                case 7:
                    manager.BayUnit(this, x, y, UnitType.TankDestroyer,strategyId);
                    break;
                case 8:
                    manager.BayUnit(this, x, y, UnitType.PrismTank,strategyId);
                    break;
                case 9:
                    manager.BayUnit(this, x, y, UnitType.Pillbox,strategyId);
                    break;
                case 10:
                    manager.BayUnit(this, x, y, UnitType.PrismTower,strategyId);
                    break;
                case 11:
                    manager.BayUnit(this, x, y, UnitType.GrandCannon,strategyId);
                    break;
                case 12:
                    manager.BayUnit(this, x, y, UnitType.BlackEagle,strategyId);
                    break;
                case 13:
                    manager.BayUnit(this, x, y, UnitType.PatriotMissileSystem,strategyId);
                    break;
                

                default:
                    break;
            }

        } 
    }

}
