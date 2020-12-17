/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
public class AttackerMovement extends Movement {

    private static AttackerMovement instance = null;

    private AttackerMovement() {
    }

    public static AttackerMovement getInstance() {

        if (instance == null) {

            instance = new AttackerMovement();

        }
        return instance;

    }

    @Override
    public void move(Unit unit) {

        Grid grid = Grid.getInstance();
        int x = unit.getPosition().getCenterX();
        int y = unit.getPosition().getCenterY();
        int speed = (int) unit.getProperties().get(5).getPropertyValue();
        Unit mainbase = DoDGameManager.getInstance().getMainBase();/**/
        
        if(mainbase.getPosition().getCenterX() < x && grid.acceptUnitMovement(unit, x - speed, y)){
        
        x = x - speed;
        
        } else if(grid.acceptUnitMovement(unit, x + speed, y)) {
        
        x = x + speed;
        
        }
        if(mainbase.getPosition().getCenterY() < y && grid.acceptUnitMovement(unit, x , y - speed)){
        
        y = y - speed;
        
        } else if(grid.acceptUnitMovement(unit, x , y + speed)) {
        
        y = y + speed;
        
        }
        
        grid.removeUnit(unit);
        unit.getPosition().setCenterX(x);
        unit.getPosition().setCenterY(y);
        grid.addUnit(unit);
        

    }

}
