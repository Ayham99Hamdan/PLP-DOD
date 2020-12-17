

import java.io.FileNotFoundException;
import java.util.ArrayList;
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
public class UnitFactory {
    
    Scanner read = new Scanner(System.in);
    
    public Unit createUnit(UnitType Type , int strategyId) throws FileNotFoundException {
        
        
        AttackStrategy strategy = null;
        
        ArrayList<UnitProperty> propertys = new ArrayList();
        
        
        
        if(strategyId == 1){
            
            strategy = LowestHealthAttackStrategy.getInstance();
        
        } else {
            
            strategy = HighestDamageAttackStrategy.getInstance();
        
        }
        
        propertys.add(new HealthUnitProperty(Type.getMaxHealth()));
        propertys.add(new ArmorUnitProperty(Type.getArmor()));
        propertys.add(new AttackDamageUnitProperty(Type.getAttackDamage()));
        propertys.add(new AttackRangeUnitProperty(Type.getAttackrange()));
        propertys.add(new AttackSpeedUnitProperty(Type.getAttackFrequency()));
        propertys.add(new MovementSpeedUnitProperty(Type.getMovementSpeed()));
        
        
        return (new Unit(strategy ,propertys));
        
        
    }
    
}
