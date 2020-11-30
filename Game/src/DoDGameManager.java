
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
public class DoDGameManager implements UnitDestroyObserver{
    
    private static DoDGameManager instance = null;
    
    private Grid grid;
    private Unit mainBase;
    private int remainingAttackerUnit;
    private double remainingTime;
    private ArrayList<Team> teams;
    private UnitFactory unitFactory;
    
    private DoDGameManager(){
    
        grid = Grid.getInstance();
        teams = new ArrayList();
        DeffenderTeam Deffender = DeffenderTeam.getInstance();
        AttackerTeam Attacker = AttackerTeam.getInstance();
        teams.add(Deffender);
        teams.add(Attacker);
        
    }
    
    public static DoDGameManager getInstance(){
    
        if(instance == null){
        
            instance = new DoDGameManager();
            
        }
        return instance;
        
    }

    @Override
    public void onUnitDestroy() {
        
    }
    
    public void BayUnit(Player player, int X, int Y,UnitType unitType){
    
        grid.addUnit(unitFactory.createUnit(player, X,Y,unitType));
        
    }
    
}
