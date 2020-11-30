
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
public class ConsolePlayer extends Player{

    @Override
    public void  newGame() {
        Scanner read = new Scanner(System.in);
        System.out.println("Welcome to DOD Game");
        System.out.println("Please Enter Your Name :");
        this.playerName = read.nextLine();
        System.out.println("Select Team You Want To Join In [1]-Deffender [2]-Attacker");
        this.teamId = read.nextInt();
        if(teamId == 1){
            
            DeffenderTeam Deffender = DeffenderTeam.getInstance();
            Deffender.addPlayerToTeam(this);
            
        } else {
        
            AttackerTeam Attacker = AttackerTeam.getInstance();
            Attacker.addPlayerToTeam(this);
            
        
        }
        
       
    }
    public static void main(String args[]){
    
        new ConsolePlayer().newGame();
    }
    
    
    
}
