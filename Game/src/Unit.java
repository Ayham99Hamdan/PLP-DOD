
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

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
    private guiUnit Graphic;
    public class guiUnit extends StackPane{
        
        ImageView img ;
        public guiUnit() throws FileNotFoundException {
            System.out.println(unitType.getName());
            img = new ImageView(new Image(new FileInputStream("C:\\Users\\USER\\Desktop\\java lab\\image play\\" + unitType.getName()+ ".jpg")));
            int posX = position.getCenterX()/10 - 500;
            int posY = position.getCenterY()/10 - 500;
            this.setTranslateX(posX);
            this.setTranslateY(posY);
            img.setFitWidth(position.getRadius() * 2);
            img.setFitHeight( position.getRadius() * 2);
            this.setMaxSize(position.getRadius() * 2, position.getRadius() * 2);
            this.getChildren().add(img);
            this.setStyle("-fx-border-color: #000;\n"
                + "    -fx-border-width: 1px;\n"
                + "    -fx-border-style: solid;");
        }
        
        
      
    }
    public Unit getNext() {
        return _next;
    }

    public guiUnit getGraphic() {
        return Graphic;
    }

    public void setGraphic(guiUnit Graphic) {
        this.Graphic = Graphic;
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
    
    
    
    public Unit(AttackStrategy attackStrategy, ArrayList<UnitProperty> properties) throws FileNotFoundException{
    
       
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

    
    }
    public void addUnitDestroyObserver(UnitDestroyObserver unitDestroyObserver){
    
        unitDestroyedObservers.add(unitDestroyObserver);
    
    }
    public void onDestroy() throws FileNotFoundException{
        

        DoDGameManager.getInstance().onUnitDestroy(this);
        this.stop();
    }

    public UnitDestroyObserver getDestructionObservers() {
        return destructionObservers;
    }

    public void setDestructionObservers(UnitDestroyObserver destructionObservers) {
        this.destructionObservers = destructionObservers;
    }
    
    public void craete() throws FileNotFoundException{
    
        Graphic = new guiUnit();
    
    }

    @Override
    public void run() {
        while(true){
            this.targetedUnit = attackStrategy.prioritizeUnitToAttack(Grid.getInstance().getAllUnitInRange(this));
            
            if(properties.get(0).getPropertyValue() <= 0){
                
                
                try {
                    onDestroy();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Unit.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }
            if(this.targetedUnit == null){
                movement.move(this);
            
            } else {
                
                attackUnit();
            
            }      
        
        }
        
        
    }
    

}
