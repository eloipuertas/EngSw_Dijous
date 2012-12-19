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
            case 1: ((Controller)this.app).getZombieManager().addZombiePetia(new Vector3f(-70.72f,49.86f,103.16f), new Vector3f(0f, 0f, 1f), difficulty.low);
                    ((Controller)this.app).getZombieManager().addZombieBasic(new Vector3f(127.22f, 3.55f,-154.05f), new Vector3f(0f, 0f, 1f), difficulty.low);
                    ((Controller)this.app).getZombieManager().addZombieBasic(new Vector3f(16.27f, -4.58f, -9.63f), new Vector3f(1f, 0f, 1f), difficulty.low);
                    ((Controller)this.app).getZombieManager().addZombieBasic(new Vector3f(17.78f, -4.59f, 55.15f), new Vector3f(1f, 0f, 1f), difficulty.low);
                    ((Controller)this.app).getZombieManager().addZombieBasic(new Vector3f(42.89f, 19.16f, -294.70f), new Vector3f(-1f, 0f, -1f), difficulty.low);
                    ((Controller)this.app).getZombieManager().addZombieBasic(new Vector3f(143.02f, -4.04f, -104.88f), new Vector3f(1f, 0f, -1f), difficulty.low);
                    ((Controller)this.app).getZombieManager().addZombieBasic(new Vector3f(81.64f, 49.44f, 105.77f), new Vector3f(1f, 0f, -1f), difficulty.low);
                    ((Controller)this.app).getZombieManager().addZombieBasic(new Vector3f(87.37f, 49.44f, -130.40f), new Vector3f(1f, 0f, -1f), difficulty.low);
                    ((Controller)this.app).getZombieManager().addZombieOriol(new Vector3f(-121.61f, 101.62f, 77.53f), new Vector3f(0f, 0f, 1f), difficulty.low);
                    break;
            case 2: ((Controller)this.app).getZombieManager().addZombiePetia(new Vector3f(-70.72f,49.86f,103.16f), new Vector3f(0f, 0f, 1f), difficulty.middle);
                    ((Controller)this.app).getZombieManager().addZombieBasic(new Vector3f(127.22f, 3.55f,-154.05f), new Vector3f(0f, 0f, 1f), difficulty.middle);
                    ((Controller)this.app).getZombieManager().addZombieBasic(new Vector3f(16.27f, -4.58f, -9.63f), new Vector3f(1f, 0f, 1f), difficulty.middle);
                    ((Controller)this.app).getZombieManager().addZombieBasic(new Vector3f(17.78f, -4.59f, 55.15f), new Vector3f(1f, 0f, 1f), difficulty.middle);
                    ((Controller)this.app).getZombieManager().addZombieBasic(new Vector3f(42.89f, 19.16f, -294.70f), new Vector3f(-1f, 0f, -1f), difficulty.middle);
                    ((Controller)this.app).getZombieManager().addZombieBasic(new Vector3f(143.02f, -4.04f, -104.88f), new Vector3f(1f, 0f, -1f), difficulty.middle);
                    ((Controller)this.app).getZombieManager().addZombieBasic(new Vector3f(81.64f, 49.44f, 105.77f), new Vector3f(1f, 0f, -1f), difficulty.middle);
                    ((Controller)this.app).getZombieManager().addZombieBasic(new Vector3f(87.37f, 49.44f, -130.40f), new Vector3f(1f, 0f, -1f), difficulty.middle);
                    ((Controller)this.app).getZombieManager().addZombieOriol(new Vector3f(-121.61f, 101.62f, 77.53f), new Vector3f(0f, 0f, 1f), difficulty.middle);
                            break;
            case 3: ((Controller)this.app).getZombieManager().addZombiePetia(new Vector3f(-70.72f,49.86f,103.16f), new Vector3f(0f, 0f, 1f), difficulty.high);
                    ((Controller)this.app).getZombieManager().addZombieBasic(new Vector3f(127.22f, 3.55f,-154.05f), new Vector3f(0f, 0f, 1f), difficulty.high);
                    ((Controller)this.app).getZombieManager().addZombieBasic(new Vector3f(16.27f, -4.58f, -9.63f), new Vector3f(1f, 0f, 1f), difficulty.high);
                    ((Controller)this.app).getZombieManager().addZombieBasic(new Vector3f(17.78f, -4.59f, 55.15f), new Vector3f(1f, 0f, 1f), difficulty.high);
                    ((Controller)this.app).getZombieManager().addZombieBasic(new Vector3f(42.89f, 19.16f, -294.70f), new Vector3f(-1f, 0f, -1f), difficulty.high);
                    ((Controller)this.app).getZombieManager().addZombieBasic(new Vector3f(143.02f, -4.04f, -104.88f), new Vector3f(1f, 0f, -1f), difficulty.high);
                    ((Controller)this.app).getZombieManager().addZombieBasic(new Vector3f(81.64f, 49.44f, 105.77f), new Vector3f(1f, 0f, -1f), difficulty.high);
                    ((Controller)this.app).getZombieManager().addZombieBasic(new Vector3f(87.37f, 49.44f, -130.40f), new Vector3f(1f, 0f, -1f), difficulty.high);
                    ((Controller)this.app).getZombieManager().addZombieOriol(new Vector3f(-121.61f, 101.62f, 77.53f), new Vector3f(0f, 0f, 1f), difficulty.high);
                    break;
            default:((Controller)this.app).getZombieManager().addZombiePetia(new Vector3f(-70.72f,49.86f,103.16f), new Vector3f(0f, 0f, 1f), difficulty.middle);
                    ((Controller)this.app).getZombieManager().addZombieBasic(new Vector3f(127.22f, 3.55f,-154.05f), new Vector3f(0f, 0f, 1f), difficulty.middle);
                    ((Controller)this.app).getZombieManager().addZombieBasic(new Vector3f(16.27f, -4.58f, -9.63f), new Vector3f(1f, 0f, 1f), difficulty.middle);
                    ((Controller)this.app).getZombieManager().addZombieBasic(new Vector3f(17.78f, -4.59f, 55.15f), new Vector3f(1f, 0f, 1f), difficulty.middle);
                    ((Controller)this.app).getZombieManager().addZombieBasic(new Vector3f(42.89f, 19.16f, -294.70f), new Vector3f(-1f, 0f, -1f), difficulty.middle);
                    ((Controller)this.app).getZombieManager().addZombieBasic(new Vector3f(143.02f, -4.04f, -104.88f), new Vector3f(1f, 0f, -1f), difficulty.middle);
                    ((Controller)this.app).getZombieManager().addZombieBasic(new Vector3f(81.64f, 49.44f, 105.77f), new Vector3f(1f, 0f, -1f), difficulty.middle);
                    ((Controller)this.app).getZombieManager().addZombieBasic(new Vector3f(87.37f, 49.44f, -130.40f), new Vector3f(1f, 0f, -1f), difficulty.middle);
                    ((Controller)this.app).getZombieManager().addZombieOriol(new Vector3f(-121.61f, 101.62f, 77.53f), new Vector3f(0f, 0f, 1f), difficulty.middle);
                    break;
       
        }
    }
    
  
    


  
}
