
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
public abstract class Player {
    
    protected int teamId;
    protected int coins;
    protected String playerName; 
    
    public abstract void newGame();
    
    public void loadGame(){}
    
    public void bayUnit(){
        Scanner read = new Scanner(System.in);
        DoDGameManager manager = DoDGameManager.getInstance();
        System.out.println("pleas Enter X: ");
        int x = read.nextInt();
        System.out.println("pleas Enter Y: ");
        int y = read.nextInt();
        System.out.println("Tank [1] sniper[2]");
        int UnitName = read.nextInt();
        if(UnitName == 1){
            
            manager.BayUnit(this, x, y, UnitType.TeslaTank);
            
        } else {
            
            manager.BayUnit(this, x, y, UnitType.Sniper);
            
        }
    
    }
    
}
