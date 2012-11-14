/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.model.character;

import com.jme3.math.Vector3f;
import mygame.model.weapon.Gun;
import mygame.model.weapon.WeaponInterface;

/**
 *
 * @author rociotovar
 */
public interface Character {
    
    // <editor-fold desc="Getters and Setters">
    
    Vector3f getPlayerPosition();
    int getNLives();
    double getEnergy();
    WeaponInterface getCurrentWeapon();
    
    void setCurrentWeapon (WeaponInterface weapon);
    void addWeapon(WeaponInterface weapon);
    
    // </editor-fold>
    
    void incrementEnergy(double quantity);
    void incrementNLives(int quantity);
    
}
