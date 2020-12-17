/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
public class NormalUnitAttack extends UnitAttack{

    public NormalUnitAttack(UnitAttack unitAttack) {
        super(unitAttack);
    }

        

    @Override
    public void PerformAttack(Unit unit, double damage) {
        
        
        unit.acceptDamage(damage);
    }

    
    
    
}
