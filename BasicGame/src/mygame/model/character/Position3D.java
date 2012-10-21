/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.model.character;

/**
 *
 * @author rociotovar
 */
public class Position3D {
    
    // <editor-fold desc="Attributes">
    
    public double x;
    public double y;
    public double z;
    
    // </editor-fold>
    
    
    // <editor-fold desc="Constructors">
    
    Position3D () {
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
    }
    
    Position3D (double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    // </editor-fold>
    
    
    // <editor-fold desc="Setters and Getters">     
    
    public void setPosition (double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public Position3D getPosition () {
        return this;
    }
    
    // </editor-fold>
    
}
