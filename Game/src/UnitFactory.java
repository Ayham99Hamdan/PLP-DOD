

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
    
    public Unit createUnit(Player player , int x, int y, UnitType unitType) {
    
        AttackStrategy strategy = null;
        
        ArrayList<UnitProperty> propertys = new ArrayList();
        
        Movement movement;
        System.out.println("Lowest [1] highest[2]");
        
        int strategyId = read.nextInt();
        if(strategyId == 1){
            
            strategy = LowestHealthAttackStrategy.getInstance();
        
        } else {
            
            strategy = HighestDamageAttackStrategy.getInstance();
        
        }
        if(player.teamId == 1){
        
            movement = DeffenderMovement.getInstance();
            
        } else {
        
            movement = AttackerMovement.getInstance();
            
        }
        
        if(unitType == UnitType.TeslaTank){
        
           propertys.add(new HealthUnitProperty(100));
           propertys.add(new ArmorUnitProperty(100));
           propertys.add(new AttackSpeedUnitProperty(100));
           propertys.add(new AttackRangeUnitProperty(100));
           
           return new Unit(Grid.getInstance(), x, y, strategy,player, propertys, movement, UnitType.TeslaTank);
            
        } else{
        
            
            propertys.add(new HealthUnitProperty(50));
           propertys.add(new ArmorUnitProperty(50));
           propertys.add(new AttackSpeedUnitProperty(50));
           propertys.add(new AttackRangeUnitProperty(50));
           
           return new Unit(Grid.getInstance(), x, y, strategy, player, propertys, movement, UnitType.Sniper);
           
        }
        
        
        
    }
    
}
