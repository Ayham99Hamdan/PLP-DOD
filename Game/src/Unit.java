
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
public class Unit extends Thread{
    
    private Unit _next = null;
    private Unit _prev = null;
    private UnitAttack activeUnitAttack ;
    private Type[] canAttack; 
    private Movement movement;
    private UnitPosition position;
    private Unit targetedUnit;
    private List<UnitDestroyObserver> unitDestroyedObservers;
    private List<UnitProperty> properties;
    private UnitType unitType;
    private UnitDestroyObserver destructionObservers;
    private Player owner;
    private AttackStrategy attackStrategy;
    private Grid grid = Grid.getInstance();
   // public  Thread thisThread = new Thread(this);
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

    public Type[] getCanAttack() {
        return canAttack;
    }

    public void setCanAttack(Type[] canAttack) {
        this.canAttack = canAttack;
    }

    

    public UnitPosition getPosition() {
        return position;
    }

    public void setPosition(UnitPosition position) {
        this.position = position;
    }

    public Movement getMovement() {
        return movement;
    }

    public void setMovement(Movement movement) {
        this.movement = movement;
    }

    public UnitType getUnitType() {
        return unitType;
    }

    public void setUnitType(UnitType unitType) {
        this.unitType = unitType;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }
    
    
    
    public Unit(AttackStrategy attackStrategy, ArrayList<UnitProperty> properties){
    
       
        this.attackStrategy = attackStrategy;
        
        this.properties = properties;
        
        
        this.activeUnitAttack = new NormalUnitAttack(null);
        
        unitDestroyedObservers = new ArrayList();
        
        
    
    }
    
    public void acceptDamage(double damage){
    
        double unitArmor = this.properties.get(1).getPropertyValue();
        double unitHealth = this.properties.get(0).getPropertyValue();
        
        double discountHealth = damage - (damage * unitArmor);
        
        this.properties.get(0).setPropertyValue(unitHealth - discountHealth);
    }
    
    public void attackUnit(){
    
    //this.targetedUnit = attackStrategy.prioritizeUnitToAttack(Grid.getInstance().getAllUnitInRange(this));
    
        
    activeUnitAttack.PerformAttack(targetedUnit, this.getProperties().get(2).getPropertyValue());
    System.out.println("this is health " + targetedUnit.getProperties().get(0).getPropertyValue());
    
    }
    public void addUnitDestroyObserver(UnitDestroyObserver unitDestroyObserver){
    
        unitDestroyedObservers.add(unitDestroyObserver);
    
    }
    public void onDestroy(){
        
        System.out.println("2222222222222222222222222222222222222222222222222");
        DoDGameManager.getInstance().onUnitDestroy(this);
        this.stop();
    }

    public UnitDestroyObserver getDestructionObservers() {
        return destructionObservers;
    }

    public void setDestructionObservers(UnitDestroyObserver destructionObservers) {
        this.destructionObservers = destructionObservers;
    }

    @Override
    public void run() {
        while(true){
            this.targetedUnit = attackStrategy.prioritizeUnitToAttack(Grid.getInstance().getAllUnitInRange(this));
            System.out.println(this.unitType.getName());
            if(properties.get(0).getPropertyValue() <= 0){
                
                
                onDestroy();
            
            }
            if(this.targetedUnit == null){
                movement.move(this);
            
            } else {
                System.out.println(" I am the target");
                attackUnit();
            
            }      
        
        }
        
        
    }
    

}
