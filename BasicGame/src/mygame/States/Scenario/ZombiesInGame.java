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
import mygame.States.RunningGameState;
import mygame.States.RunningGameStateInterface;
import mygame.model.character.CharacterMainInterface;
import mygame.model.weapon.Gun;
import mygame.model.weapon.WeaponInterface;
import mygame.model.zombie.Zombie;
import mygame.model.zombie.ZombieManagerInterface.difficulty;
import mygame.model.zombie.ZombieManagerInterface;

/**
 *
 * @author Harpo
 */
public class ZombiesInGame extends AbstractAppState  {

    private SimpleApplication app;
    private BulletAppState bulletAppState;
    private ZombieManagerInterface zombieManagerInterface;


    
    //List<WeaponInterface> weaponsList;
    //ArrayList<ObjAntidoto> ObjetosAntidoto;
   
    /*public ZombieManagerInterface getZombieManagerInterface() {
        return zombieManagerInterface;
    }
    
    public void setZombieManagerInterface(ZombieManagerInterface ZombieManagerInterface) {
        this.zombieManagerInterface = ZombieManagerInterface;
    }*/
    
    public ZombiesInGame(SimpleApplication application){
        this.app =application;
        this.bulletAppState = this.app.getStateManager().getState(BulletAppState.class);
        System.out.println("AUN NO HA PETAAADOOOOOOOOOO");
        //zombieManagerInterface.pene();  
    } 
}
