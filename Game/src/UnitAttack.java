/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
public abstract class UnitAttack {
    
    protected UnitAttack unitAttack;
    private AttackResult attackResult;

    protected UnitAttack(UnitAttack unitAttack) {
        this.unitAttack = unitAttack;
    }
    
    public abstract AttackResult PerformAttack(/*UNIT Refeance*/);
    
    
}
