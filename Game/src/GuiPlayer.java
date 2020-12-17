
import java.io.FileNotFoundException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author DELL
 */
public class GuiPlayer extends Player {

    boolean bayingStatus = true;

    public void bayUnit(int x, int y, UnitType type,int strategyId) throws FileNotFoundException {

        if (this.coins > 0) {
            
           
            if (this.coins >= type.getUnitPrice()) {
                DoDGameManager.getInstance().BayUnit(this, x, y, type,strategyId);
            }

        } else {
        
            this.bayingStatus = false;
        
        }
    }

}
