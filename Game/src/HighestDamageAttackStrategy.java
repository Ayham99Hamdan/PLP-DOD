
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author USER
 */
public class HighestDamageAttackStrategy implements AttackStrategy {

    /* To implements Singleton design pattern*/
    private static HighestDamageAttackStrategy instance = null;

    public static HighestDamageAttackStrategy getInstance() {

        if (instance == null) {

            instance = new HighestDamageAttackStrategy();

        }
        return instance;

    }

    private HighestDamageAttackStrategy() {
    }

    @Override
    public Unit prioritizeUnitToAttack(List<Unit> list) {

        /*form  this array this function will return referance to the Highest Dammage Unit to select that unit as target and attack it*/
        if (list.isEmpty()) {
            
            
            return null;
            

        }
        Unit Target = list.get(0);
        for (Unit unit : list) {

            if (unit.getProperties().get(2).getPropertyValue() > Target.getProperties().get(2).getPropertyValue()) {

                Target = unit;

            }

        }
        return Target;
    }

}
