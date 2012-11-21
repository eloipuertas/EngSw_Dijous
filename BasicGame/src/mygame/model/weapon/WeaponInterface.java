/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.model.weapon;

import com.jme3.math.Vector3f;

/**
 *
 * @author rociotovar
 * @test and comments ernest
 */

// WEAPON interface methods
public interface WeaponInterface {
    
    String getId();
    String getName();
    int getMunition();
    Vector3f getPosition();
    
    void addWeaponeToScenario();
    void deleteFromScenario();
    
}