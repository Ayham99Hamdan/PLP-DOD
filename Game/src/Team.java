
import java.util.ArrayList;
import jdk.nashorn.internal.objects.NativeArray;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
public  class Team {
    
    private  ArrayList<Player> players = new ArrayList();
    private ArrayList<UnitPosition >teamUnitsInitializationPositions = new ArrayList();
    
    /**
     *
     * @param player
     */
    public  void addPlayerToTeam(Player player){
    
        players.add(player);
    
    
    }
    
    public boolean initializePositions(ArrayList<UnitPosition> postions){
    
        return teamUnitsInitializationPositions.addAll(postions);
    }
    
    public void getTeamReady(){
    
    for(Player player : players){
    
        
        player.bayUnit();
    
    }
    
    }
     
    
    
}
