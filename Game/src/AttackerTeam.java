/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
public class AttackerTeam extends Team{
    private static AttackerTeam instance = null;
    private AttackerTeam(){}
    public static AttackerTeam getInstance(){
    
        if(instance == null) {
        
            instance = new AttackerTeam();
        }
        return instance;
        
    }
    
    
}
