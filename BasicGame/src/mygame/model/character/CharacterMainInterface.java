/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.model.character;

import com.jme3.math.Vector3f;
import mygame.model.weapon.Gun;
import mygame.model.weapon.WeaponInterface;
import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.bullet.BulletAppState;
/**
 *
 * @author rociotovar
 */

public interface CharacterMainInterface {
    
    // Public methods of our CharacterMainJMonkey Class
    void initialize(AppStateManager stateManager, Application applicooter);
    void setState(BulletAppState state);
    void setUpKeys();
    void onAction(String binding, boolean value, float tpf);
    void personatgeUpdate();
    
    Vector3f getPlayerPosition();
    void addWeapon(WeaponInterface weapon);
    WeaponInterface getCurrentWeapon();
    
    int getNLives();
    double getEnergy();
    void setCurrentWeapon(WeaponInterface weapon);
    void incrementEnergy(double quantity);
    void incrementNLives(int quantity);
}
