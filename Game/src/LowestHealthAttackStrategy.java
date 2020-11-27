/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
public class LowestHealthAttackStrategy implements AttackStrategy{
    
    /* To implements Singleton design pattern*/
    private static LowestHealthAttackStrategy instance = null;
    
    public static LowestHealthAttackStrategy getInstance (){
    
        if(instance == null) {
        
            instance = new LowestHealthAttackStrategy();
            
        }
        return instance;
    
    }  
    private LowestHealthAttackStrategy(){}
    @Override
    public  /* return type must be Unit object*/void prioritizeUnitToAttack(/*Unit referance*/){
    
        /*form  this array this function will return referance to the Lowest Health Unit to select that unit as target and attack it*/
        
        
    }
    
    
    
}
