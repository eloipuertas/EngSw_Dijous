/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.model.character;

/**
 *
 * @author rociotovar
 * @test and comments ernest
 */

// Position class implementation. Needed in order to create 
// 3 points position (x,y,z)

public class Position3D {
    
    // <editor-fold desc="Attributes">
    
    public double x;
    public double y;
    public double z;
    
    // </editor-fold>
    
    
    // <editor-fold desc="Constructors">
    
    Position3D () {  // default constructor initializes all to 0
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
    }
    
    // assign arguments
    Position3D (double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    // </editor-fold>
    
    
    // <editor-fold desc="Setters and Getters">     
    
    // Getters and setters for position's attributes
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
