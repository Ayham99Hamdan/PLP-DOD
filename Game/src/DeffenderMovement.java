/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
public class DeffenderMovement extends Movement{

    private static DeffenderMovement instance = null;
    private DeffenderMovement(){}
    public static DeffenderMovement getInstance(){
    
        if(instance == null){
        
            instance = new DeffenderMovement();
            
        }
        return instance;
        
    }
    @Override
    public void move(Unit unit) {
      
    }
    
}
