/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
public class UnitPosition {
    
    private int centerX;
    private int centerY;
    private int radius;

    public int getCenterX() {
        return centerX;
    }

    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public void setCenterY(int centerY) {
        this.centerY = centerY;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
    
    public boolean squareIsOccupied(int x, int y){

        if((centerX + radius >= x && centerX - radius <= x) && (centerY + radius >= y && centerY - radius <= y)){
        
            return true;
        
        }else{
            return false;
        }
        
    
    }
    
}
