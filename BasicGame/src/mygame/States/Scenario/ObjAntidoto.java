/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.States.Scenario;

import com.jme3.app.SimpleApplication;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.collision.PhysicsCollisionEvent;
import com.jme3.bullet.collision.PhysicsCollisionListener;
import com.jme3.bullet.collision.shapes.BoxCollisionShape;
import com.jme3.bullet.collision.shapes.CollisionShape;
import com.jme3.bullet.collision.shapes.CylinderCollisionShape;
import com.jme3.bullet.control.CharacterControl;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.bullet.util.CollisionShapeFactory;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import mygame.Controller;

/**
 *
 * @author Harpo
 */
public class ObjAntidoto  {

    private SimpleApplication app;
  

    private int contador;
    private BulletAppState bulletAppState;
    
    private int id;
    private final String name = "Antidoto";
    private boolean antidoto;
    private final CharacterControl antidotoControl;
    private final Node antidotoShape;
    
    public ObjAntidoto(BulletAppState bulletAppSt, SimpleApplication application,int cont, float posX, float posY, float posZ,int id) {
        
        
        this.app = application;
        this.contador = cont;
        this.bulletAppState = bulletAppSt;
        this.id = id;
        
         // type of weapon is Gun
        
        
        // creating collision box of gun as cilider shape
        BoxCollisionShape cilinder = new BoxCollisionShape(new Vector3f(0.5f,1.5f,0.5f));
        antidotoControl = new CharacterControl(cilinder, 1f);
        
        //TODO: Add weapon model
        // Loading, scaling and adding control for our weapon.
        antidotoShape = (Node) app.getAssetManager().loadModel("Scenes/antidoto.j3o");
        antidotoShape.scale(1f);
        antidotoShape.addControl(antidotoControl);
        antidotoShape.setName(name);
        
        
        // placing our weapon
        antidotoControl.setPhysicsLocation(new Vector3f(posX, posY, posZ)); 
        
    }
     public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public boolean isAntidoto() {
        return antidoto;
    }
    
    public Vector3f getPosition() {
        return antidotoControl.getPhysicsLocation();
    }
    
    // Method which adds antidote kit object into Scenario caled in 'ObjectsInGame'
    public void addAntidotoToScenario() {
        bulletAppState.getPhysicsSpace().add(antidotoControl);
        app.getRootNode().attachChild(antidotoShape); // attach weapon
        System.out.println(" added to scenario!");  // debugging
    }
    
    // Method which deletes antidote kit object from Scenario called in 'ObjectsInGame'
    public void deleteFromScenario() {
        app.getRootNode().detachChild(antidotoShape); // detach first-aid kit
        bulletAppState.getPhysicsSpace().remove(antidotoControl);
        //((Controller)app).getScenarioManager().getGuiPlayer().setSaludGUI(((Controller)app).getScenarioManager().getGuiPlayer().getSaludGUI()+this.antidoto);
        System.out.println("antidote kit from scenario!"); // debugging
    }
    
        
}   
