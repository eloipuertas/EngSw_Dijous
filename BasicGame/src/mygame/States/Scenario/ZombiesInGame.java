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
import mygame.model.zombie.Zombie;
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
        int dificultad = ((Controller)this.app).getRunningGameState(). getDifficulty();
        switch(dificultad){
            case 1: ((Controller)this.app).getZombieManager().addZombiePetia(new Vector3f(141.61f,-0.65f,-79.91f), new Vector3f(0f, 0f, 1f), difficulty.low);
                    ((Controller)this.app).getZombieManager().addZombieBasic(new Vector3f(5f, 5f, 0f), new Vector3f(0f, 0f, 1f), difficulty.low);
                    ((Controller)this.app).getZombieManager().addZombieBasic(new Vector3f(15f, 5f, 10f), new Vector3f(1f, 0f, 1f), difficulty.low);
                    ((Controller)this.app).getZombieManager().addZombieBasic(new Vector3f(0f, 5f, 10f), new Vector3f(1f, 0f, 1f), difficulty.low);
                    ((Controller)this.app).getZombieManager().addZombieBasic(new Vector3f(0f, 5f, 10f), new Vector3f(-1f, 0f, -1f), difficulty.low);
                    ((Controller)this.app).getZombieManager().addZombieBasic(new Vector3f(0f, 5f, 10f), new Vector3f(1f, 0f, -1f), difficulty.low);break;
            case 2: ((Controller)this.app).getZombieManager().addZombiePetia(new Vector3f(141.61f,-0.65f,-79.91f), new Vector3f(0f, 0f, 1f), difficulty.middle);
                     ((Controller)this.app).getZombieManager().addZombieBasic(new Vector3f(5f, 5f, 0f), new Vector3f(0f, 0f, 1f), difficulty.middle);
                    ((Controller)this.app).getZombieManager().addZombieBasic(new Vector3f(15f, 5f, 10f), new Vector3f(1f, 0f, 1f), difficulty.middle);
                    ((Controller)this.app).getZombieManager().addZombieBasic(new Vector3f(0f, 5f, 10f), new Vector3f(1f, 0f, 1f), difficulty.middle);
                    ((Controller)this.app).getZombieManager().addZombieBasic(new Vector3f(0f, 5f, 10f), new Vector3f(-1f, 0f, -1f), difficulty.middle);
                    ((Controller)this.app).getZombieManager().addZombieBasic(new Vector3f(0f, 5f, 10f), new Vector3f(1f, 0f, -1f), difficulty.middle);break;
            case 3: ((Controller)this.app).getZombieManager().addZombiePetia(new Vector3f(141.61f,-0.65f,-79.91f), new Vector3f(0f, 0f, 1f), difficulty.high);
                     ((Controller)this.app).getZombieManager().addZombieBasic(new Vector3f(5f, 5f, 0f), new Vector3f(0f, 0f, 1f), difficulty.high);
                    ((Controller)this.app).getZombieManager().addZombieBasic(new Vector3f(15f, 5f, 10f), new Vector3f(1f, 0f, 1f), difficulty.high);
                    ((Controller)this.app).getZombieManager().addZombieBasic(new Vector3f(0f, 5f, 10f), new Vector3f(1f, 0f, 1f), difficulty.high);
                    ((Controller)this.app).getZombieManager().addZombieBasic(new Vector3f(0f, 5f, 10f), new Vector3f(-1f, 0f, -1f), difficulty.high);
                    ((Controller)this.app).getZombieManager().addZombieBasic(new Vector3f(0f, 5f, 10f), new Vector3f(1f, 0f, -1f), difficulty.high);break;
            default: ((Controller)this.app).getZombieManager().addZombiePetia(new Vector3f(141.61f,-0.65f,-79.91f), new Vector3f(0f, 0f, 1f), difficulty.middle);
                     ((Controller)this.app).getZombieManager().addZombieBasic(new Vector3f(5f, 5f, 0f), new Vector3f(0f, 0f, 1f), difficulty.middle);
                    ((Controller)this.app).getZombieManager().addZombieBasic(new Vector3f(15f, 5f, 10f), new Vector3f(1f, 0f, 1f), difficulty.middle);
                    ((Controller)this.app).getZombieManager().addZombieBasic(new Vector3f(0f, 5f, 10f), new Vector3f(1f, 0f, 1f), difficulty.middle);
                    ((Controller)this.app).getZombieManager().addZombieBasic(new Vector3f(0f, 5f, 10f), new Vector3f(-1f, 0f, -1f), difficulty.middle);
                    ((Controller)this.app).getZombieManager().addZombieBasic(new Vector3f(0f, 5f, 10f), new Vector3f(1f, 0f, -1f), difficulty.middle);break;
        }
    }
    
  
    


  
}
