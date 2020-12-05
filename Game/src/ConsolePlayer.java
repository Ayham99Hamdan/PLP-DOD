
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

    @Override
    public void newGame() {
        Scanner read = new Scanner(System.in);
        
        System.out.println("how many Players:");
        int NumberOfPlayer = read.nextInt();
        for (int i = 0; i < NumberOfPlayer; i++) {
            Player player = new Player();
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
    

    public static void main(String args[]) {

        new ConsolePlayer().newGame();
        
    }

}
