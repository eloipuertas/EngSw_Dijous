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
import mygame.model.character.CharacterMainInterface;
import mygame.model.weapon.Gun;
import mygame.model.weapon.Antidot;
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
    ArrayList<WeaponInterface> ObjetosAntidoto;
   
    
    
    public ObjectsInGame(SimpleApplication application){
        this.app =application;
        this.bulletAppState = this.app.getStateManager().getState(BulletAppState.class);
        
        //Guardamos los botiquines que creemos en una lista
        ObjetosAntidoto = new ArrayList<WeaponInterface>();
        //ObjetosAntidoto.add(new Antidot(this.app, this.bulletAppState, new Vector3f(141.61f,-0.65f,-79.91f), "antidote"));
        ObjetosAntidoto.add(new Antidot(this.app, this.bulletAppState, new Vector3f(141.61f, 0f,-79.91f), "antidote"));
        ObjetosAntidoto.get(0).addWeaponeToScenario();
        
        //Guardamos los botiquines que creemos en una lista
        ObjetosVida = new ArrayList<ObjVida>();
        ObjetosVida.add(new ObjVida(this.bulletAppState,this.app,1,10.0f,1f,10.0f, 0));
        ObjetosVida.add(new ObjVida(this.bulletAppState,this.app,2,15.0f,1f,17.0f, 1));
        ObjetosVida.get(0).addFirstAidKitToScenario();
        ObjetosVida.get(1).addFirstAidKitToScenario();
        
        //Init weapons
        weaponsList = new ArrayList<WeaponInterface>();
        weaponsList.add(new Gun(this.app, this.bulletAppState, new Vector3f(-25f, 0f, 0f), 1220, "weapon01"));
        weaponsList.get(0).addWeaponeToScenario();
    }
    
   public void update(GUIPlayerMain gui, CharacterMainInterface player){
       
       // grab Antidote Kit near player if there is one
       WeaponInterface antidoto = getAntidotoNearPlayer(player.getPlayerPosition());
       if (antidoto != null) {
            player.addWeapon(antidoto);
            antidoto.deleteFromScenario();
            ObjetosAntidoto.remove(antidoto);
       }
       
       // grab First-Aid Kit near player if there is one
       ObjVida botiquin = getBotiquinNearPlayer(player.getPlayerPosition());
       if (botiquin != null) {
            botiquin.deleteFromScenario();
            ObjetosVida.remove(botiquin);
       }
       
       // grab weapon near player if there is one
       WeaponInterface weapon = getWeaponNearPlayer(player.getPlayerPosition());
       if (weapon != null) {
            player.addWeapon(weapon);
            weapon.deleteFromScenario();
       }
     
    }
    
   
   public WeaponInterface getAntidotoNearPlayer(Vector3f playerPosition) {
       
       for (WeaponInterface antidoto : ObjetosAntidoto) {
           if (antidoto.getPosition().distance(playerPosition) < 5.0f ) {
               return antidoto;
           }
       }
       
       return null;
   }
   
   public ObjVida getBotiquinNearPlayer(Vector3f playerPosition) {
       
       for (ObjVida botiquin : ObjetosVida) {
           if (botiquin.getPosition().distance(playerPosition) < 5.0f ) {
               return botiquin;
           }
       }
       
       return null;
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
