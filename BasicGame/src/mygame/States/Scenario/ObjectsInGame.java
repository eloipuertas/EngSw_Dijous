/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.States.Scenario;

import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.bullet.BulletAppState;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mygame.model.character.CharacterMainJMonkey;
import mygame.model.weapon.Gun;
import mygame.model.weapon.WeaponInterface;

/**
 *
 * @author Harpo
 */
public class ObjectsInGame extends AbstractAppState  {

    private SimpleApplication app;
    private BulletAppState bulletAppState;


    List<ObjVida> ObjetosVida;
    List<WeaponInterface> weaponsList;
   
    
    
    public ObjectsInGame(SimpleApplication application){
        this.app =application;
        this.bulletAppState = this.app.getStateManager().getState(BulletAppState.class);
  
        
        //Guardamos los Objetos de vida que creemos en una lista
        ObjetosVida = new ArrayList<ObjVida>();
        ObjetosVida.add(new ObjVida(this.bulletAppState,this.app,1,10.0f,0f,10.0f));
        ObjetosVida.add(new ObjVida(this.bulletAppState,this.app,2,15.0f,0f,17.0f));
       
        //Init weapons
        weaponsList = new ArrayList<WeaponInterface>();
        weaponsList.add(new Gun(this.app, this.bulletAppState, new Vector3f(-25f, 0f, 0f), 1220, "weapon01"));
        weaponsList.get(0).addWeaponeToScenario();
    }
    
   public void update(GUIPlayerMain gui, CharacterMainJMonkey player){
       
       //comprobamos si alguno de los botiquines ha sido cogido
       for(Iterator iterador = ObjetosVida.listIterator();iterador.hasNext();){
           ObjVida objVidaActual = (ObjVida)iterador.next();
           if (objVidaActual.isCollision()){
                   gui.setSaludGUI(gui.getSaludGUI()+objVidaActual.getVida());
                   objVidaActual.setCollision(false);
                   iterador.remove();
           }
       }
       
       // grab weapon near player if there is one
       WeaponInterface weapon = getWeaponNearPlayer(player.getPlayerPosition());
       if (weapon != null) {
           player.addWeapon(weapon);
           weapon.deleteFromScenario();
       }
     
    }
    
   public WeaponInterface getWeaponNearPlayer(Vector3f playerPosition) {
       
       for (WeaponInterface weapon : weaponsList) {
           if (weapon.getPosition().distance(playerPosition) < 5.0f) {
               return weapon;
           }
       }
       
       return null;
   }

  
}
