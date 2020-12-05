/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
public class DeffenderTeam extends Team{
    private static DeffenderTeam instance = null;
    private DeffenderTeam(){}
    public static DeffenderTeam getInstance(){
    
        if(instance == null) {
        
            instance = new DeffenderTeam();
        }
        return instance;
        
    }
    public Player DeffenderPlayerForMainBase(){
    
        Player pl = new Player();
        pl.setTeamId(1);
        return pl;
    
    }
}
