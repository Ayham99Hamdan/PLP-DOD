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
        int x = 0, y = 0;
        grid.acceptUnitMovement(unit, x, y);

    }

}
