/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.States.Scenario;

import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.bullet.BulletAppState;
import com.jme3.math.Vector3f;
import java.util.ArrayList;
import java.util.List;
import mygame.Controller;
import mygame.model.character.CharacterMainInterface;
import mygame.model.weapon.Gun;
import mygame.model.weapon.WeaponInterface;
import mygame.model.zombie.ZombieManagerInterface.difficulty;

/**
 *
 * @author Harpo
 */
public class ZombiesInGame extends AbstractAppState  {

    private SimpleApplication app;
    private BulletAppState bulletAppState;
   
    
    
    public ZombiesInGame(SimpleApplication application){
        this.app =application;
        this.bulletAppState = this.app.getStateManager().getState(BulletAppState.class);
        
        //((Controller)this.app).getZombieManager().addZombieBasic(new Vector3f(5f, 5f, 0f), new Vector3f(0f, 0f, 1f), difficulty.low);
        ((Controller)this.app).getZombieManager().pene();
        
    }
    
  
    


  
}
