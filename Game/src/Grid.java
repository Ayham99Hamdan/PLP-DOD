
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author USER
 */
public class Grid {

    public static int CELLS = 10;
    public static int SIZE = 100;
    private static Grid instance = null;
    private Unit[][] allUnit;

    private Grid() {

        allUnit = new Unit[CELLS][CELLS];

    }

    public static Grid getInstance() {

        if (instance == null) {

            instance = new Grid();

        }
        return instance;

    }

    public void addUnit(Unit unit) {

        int cellX = (int) (unit.getPosition().getCenterX() / SIZE);
        int cellY = (int) (unit.getPosition().getCenterY() / SIZE);

        unit.setPrev(null);
        unit.setNext(allUnit[cellX][cellY]);
        allUnit[cellX][cellY] = unit;
        if (unit.getNext() != null) {
            unit.getNext().setPrev(unit);
        }

    }

    private ArrayList<Unit> getAllUnitInRange(Unit unit) {

        ArrayList<Unit> inRange = new ArrayList<Unit>();

        int Range = (int) (unit.getProperties().get(1).getPropertyValue());
        int cellX = (int)(unit.getPosition().getCenterX() / SIZE);
        int cellY = (int) (unit.getPosition().getCenterY() / SIZE);
        Unit unitInThisCell = allUnit[cellX][cellY];
       
        while(unitInThisCell != null){
        
            if(unitInThisCell.getPosition().getCenterX() <= unit.getPosition().getCenterX() + Range || unitInThisCell.getPosition().getCenterX() >= unit.getPosition().getCenterX() - Range){
            
                if(unitInThisCell.getPosition().getCenterY() <= unit.getPosition().getCenterY() + Range || unitInThisCell.getPosition().getCenterY() >= unit.getPosition().getCenterY() - Range){
                
                inRange.add(unitInThisCell); 
                
                }
            
            }
            unitInThisCell = unitInThisCell.getNext();
        }
        return (inRange);

    }

    public boolean acceptUnitMovement(Unit unit, int x, int y) {

        int cellX = (int) (x / SIZE);
        int cellY = (int) (y / SIZE);
        Unit unitInThisCell = allUnit[cellX][cellY];
        while (unitInThisCell != null) {

            if (unitInThisCell.getPosition().squareIsOccupied(x, y)) {

                return false;

            } else {

                unitInThisCell = unitInThisCell.getNext();

            }

        }

        return true;
    }

}
