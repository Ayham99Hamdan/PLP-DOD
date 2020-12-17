
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

    public static int CELLS = 100;
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

    public ArrayList<Unit> getAllUnitInRange(Unit unit) {

        ArrayList<Unit> inRange = new ArrayList();
        int startCellX;
        int startCellY;
        int endCellX;
        int endCellY;
        double range = unit.getProperties().get(3).getPropertyValue();
        int rangeCell = (int) (range / SIZE);
        int cellX = unit.getPosition().getCenterX() / SIZE;
        int cellY = unit.getPosition().getCenterY() / SIZE;

        if (cellX - rangeCell < 0) {

            startCellX = 0;

        } else {

            startCellX = cellX - rangeCell;
        }

        if (cellX + rangeCell > CELLS) {

            endCellX = CELLS;

        } else {

            endCellX = cellX + rangeCell;

        }
        if (cellY - rangeCell < 0) {

            startCellY = 0;

        } else {

            startCellY = cellY - rangeCell;

        }
        if (cellY + rangeCell > CELLS) {

            endCellY = CELLS;

        } else {

            endCellY = cellY + rangeCell;

        }

        for (int i = startCellX; i < endCellX; i++) {

            for (int j = startCellY; j < endCellY; j++) {

                Unit unitInThisCell = allUnit[i][j];
               
                while (unitInThisCell != null) {
                    /*return him self*/
                    if (unitInThisCell.getOwner().teamId != unit.getOwner().teamId) {
                        if (unitInThisCell.getPosition().getCenterX() <= unit.getPosition().getCenterX() + range && unitInThisCell.getPosition().getCenterX() >= unit.getPosition().getCenterX() - range) {

                            if (unitInThisCell.getPosition().getCenterY() <= unit.getPosition().getCenterY() + range && unitInThisCell.getPosition().getCenterY() >= unit.getPosition().getCenterY() - range) {

                                inRange.add(unitInThisCell);
                                System.err.println(unitInThisCell.getUnitType().getName());

                            }

                        }
                    }
                    unitInThisCell = unitInThisCell.getNext();
                }

            }

        }

        return (inRange);
        /*int Range = (int) (unit.getProperties().get(1).getPropertyValue());
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
         return (inRange);*/
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

    public void start() {

        for (int i = 0; i < CELLS; i++) {
            for (int j = 0; j < CELLS; j++) {
                Unit unit = allUnit[i][j];
                while (unit != null) {
                   

                    unit.start();
                    unit = unit.getNext();

                }
            }
        }
    }

    public void end() {

        for (int i = 0; i < CELLS; i++) {
            for (int j = 0; j < CELLS; j++) {
                Unit unit = allUnit[i][j];
                while (unit != null) {
                    

                    unit.stop();
                    unit = unit.getNext();

                }
            }
        }

    }

    public void notifyAllUnits(Unit destroyedUnit) {

        for (int i = 0; i < CELLS; i++) {
            for (int j = 0; j < CELLS; j++) {
                Unit unit = allUnit[i][j];
                while (unit != null) {

                    unit.addUnitDestroyObserver(destroyedUnit.getDestructionObservers());

                }
            }
        }

    }

    public void removeUnit(Unit unit) {

        int cellX = (int) (unit.getPosition().getCenterX() / SIZE);
        int cellY = (int) (unit.getPosition().getCenterY() / SIZE);

        int X = unit.getPosition().getCenterX();
        int Y = unit.getPosition().getCenterY();

        Unit unitInThisCell = allUnit[cellX][cellY];

        while (unitInThisCell != null) {

            if (unitInThisCell.getPosition().getCenterX() == X && unitInThisCell.getPosition().getCenterY() == Y) {

                if (unitInThisCell.getPrev() == null) {

                    allUnit[cellX][cellY] = unitInThisCell.getNext();
                    if (unitInThisCell.getNext() != null) {
                        unitInThisCell.getNext().setPrev(null);
                    }
                    unitInThisCell.setNext(null);

                } else if (unitInThisCell.getNext() == null) {

                    unitInThisCell.getPrev().setNext(null);
                    unitInThisCell.setPrev(null);

                } else {

                    unitInThisCell.getPrev().setNext(unitInThisCell.getNext());
                    unitInThisCell.getNext().setPrev(unitInThisCell.getPrev());
                    unitInThisCell.setNext(null);
                    unitInThisCell.setPrev(null);

                }

                break;

            } else {

                unitInThisCell = unitInThisCell.getNext();

            }

        }

    }

    public void printBoardInfo(){
    
        Unit unitInThisCell;
        for(int i = 0; i < CELLS; i++){
        
            for(int j = 0; j < CELLS; j++){
                unitInThisCell = allUnit[i][j];
                while(unitInThisCell != null){
                
                    System.out.println(unitInThisCell.getUnitType().getName() + "(" + unitInThisCell.getPosition().getCenterX() + unitInThisCell.getPosition().getCenterY()
                    + ")" + unitInThisCell.getProperties().get(0).getPropertyValue());
                    
                    unitInThisCell = unitInThisCell.getNext();
                
                }
            
            }
        
        }
    
    
    }
}
