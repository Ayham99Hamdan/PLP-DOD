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
    /*main base as unit*/
    private int remainingAttackerUnit;
    private double remainingTime;
    /*list of team */
    private UnitFactory unitFactory;
    
    private DoDGameManager(){}
    
    public static DoDGameManager getInstance(){
    
        if(instance == null){
        
            instance = new DoDGameManager();
            
        }
        return instance;
        
    }

    @Override
    public void onUnitDestroy() {
        
    }
    
    
}
