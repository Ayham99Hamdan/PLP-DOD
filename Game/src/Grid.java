/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
public class Grid {
    
    public static final int CELLS = 100;
    public static final int ZISE = 100;
    private static Grid instance = null;
    /*all Unit  must be list of unit referance*/ 
    private Grid(){}
    
    public static Grid getInstance(){
    
        if(instance == null){
            
            instance = new Grid();
            
        }
        return instance;
    
    }
    public void addUnit(/*UNit */){
    
    
    }
    
    private /* return type Unit*/ void getAllUnitInRange(/*Unit list*/){}
    
    public boolean acceptUnitMovemet(/*unit want to move*/ int x, int y){
    
    return true;
    }
    
}
