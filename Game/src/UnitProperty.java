/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
public   class UnitProperty {
    
    private double propertyValue;
    
    public UnitProperty(double Value){
        
        this.propertyValue = Value;
    
    };
    // I Think It must have Getter and setter to handle this attribute
    public double getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(double propertyValue) {
        this.propertyValue = propertyValue;
    }

}
