
import java.util.ArrayList;
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
public class Unit {
    
    private Unit _next = null;
    private Unit _prev = null;
    private UnitAttack activeUnitAttack ;
    private UnitType canAttack; 
    private Movement movement;
    private UnitPosition position;
    private Unit targetedUnit;
    private List<UnitDestroyObserver> unitDestroyedObservers;
    private List<UnitProperty> properties;
    private UnitType unitType;
    private UnitDestroyObserver destructionObservers;
    private Player owner;
    private AttackStrategy attackStrategy;
    public Unit getNext() {
        return _next;
    }

    public void setNext(Unit _next) {
        this._next = _next;
    }

    public List<UnitProperty> getProperties() {
        return properties;
    }

    public void setProperties(ArrayList<UnitProperty> properties) {
        this.properties = properties;
    }

    public Unit getPrev() {
        return _prev;
    }

    public void setPrev(Unit _prev) {
        this._prev = _prev;
    }

    public UnitAttack getActiveUnitAttack() {
        return activeUnitAttack;
    }

    public void setActiveUnitAttack(UnitAttack activeUnitAttack) {
        this.activeUnitAttack = activeUnitAttack;
    }

    public UnitType getCanAttack() {
        return canAttack;
    }

    public void setCanAttack(UnitType canAttack) {
        this.canAttack = canAttack;
    }

    public UnitPosition getPosition() {
        return position;
    }

    public void setPosition(UnitPosition position) {
        this.position = position;
    }
    public Unit(Grid grid, int x, int y, AttackStrategy attackStrategy, Player owner, ArrayList<UnitProperty> propertys,Movement movement, UnitType Type){
    
        this.position.setCenterX(x);
        this.position.setCenterY(y);
        this.attackStrategy = attackStrategy;
        this.owner = owner;
        this.properties = propertys;
        this.movement = movement;
        this.unitType = Type;
    
    }
    
    public void acceptDamage(double damage){
    
        double unitArmor = this.properties.get(1).getPropertyValue();
        double unitHealth = this.properties.get(0).getPropertyValue();
        
        double discountHealth = damage - (damage * unitArmor);
        
        this.properties.get(0).setPropertyValue(unitHealth - discountHealth);
    }

}
