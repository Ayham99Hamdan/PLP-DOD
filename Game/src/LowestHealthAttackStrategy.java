/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
public interface LowestHealthAttackStrategy extends AttackStrategy{

    @Override
    public abstract /* return type must be Unit object*/void prioritizeUnitToAttack(/*Unit referance*/);
    
    
    
}
