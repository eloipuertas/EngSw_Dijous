/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.model.character;

/**
 *
 * @author rociotovar
 */
public interface Character {
    
    // <editor-fold desc="Getters and Setters">
    
    Position3D getPosition();
    int getNLives();
    double getEnergy();
    
    void setPosition(double x, double y, double z);
    
    // </editor-fold>
    
    void incrementEnergy(double quantity);
    void incrementNLives(int quantity);
    
}
