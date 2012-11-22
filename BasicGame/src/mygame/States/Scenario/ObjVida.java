/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.States.Scenario;

import com.jme3.app.SimpleApplication;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.collision.PhysicsCollisionEvent;
import com.jme3.bullet.collision.PhysicsCollisionListener;
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
public class ObjVida  {

    private SimpleApplication app;
  

    private int contador;
    private BulletAppState bulletAppState;
    private final int vida = 35;
    private int id;
    private final String name = "Botiquin";
    private final CharacterControl botiquinControl;
    private final Node botiquinShape;
    
    public ObjVida(BulletAppState bulletAppSt, SimpleApplication application,int cont, float posX, float posY, float posZ,int id) {
        
        
        this.app = application;
        this.contador = cont;
        this.bulletAppState = bulletAppSt;
        this.id = id;
        
         // type of weapon is Gun
        
        
        // creating collision box of gun as cilider shape
        CylinderCollisionShape cilinder = new CylinderCollisionShape(new Vector3f(0.5f,1.5f,1.5f));
        botiquinControl = new CharacterControl(cilinder, 0.5f);
        
        //TODO: Add weapon model
        // Loading, scaling and adding control for our weapon.

        botiquinShape = (Node) app.getAssetManager().loadModel("Scenes/maleta.j3o");
        botiquinShape.scale(1f);
/*=======
        botiquinShape = (Node) app.getAssetManager().loadModel("Scenes/botiquin.j3o");
        botiquinShape.scale(0.05f);
>>>>>>> origin/TEAM-F/**/
        botiquinShape.addControl(botiquinControl);
        botiquinShape.setName(name);
        
        // placing our weapon
        botiquinControl.setPhysicsLocation(new Vector3f(posX, posY, posZ)); 
        
    }
     public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public int getVida() {
        return vida;
    }
    
    public Vector3f getPosition() {
        return botiquinControl.getPhysicsLocation();
    }
    
    // Method which adds first-aid kit object into Scenario caled in 'ObjectsInGame'
    public void addFirstAidKitToScenario() {
        bulletAppState.getPhysicsSpace().add(botiquinControl);
        app.getRootNode().attachChild(botiquinShape); // attach weapon
        System.out.println(" added to scenario!");  // debugging
    }
    
    // Method which deletes first-aid kit object from Scenario called in 'ObjectsInGame'
    public void deleteFromScenario() {
        app.getRootNode().detachChild(botiquinShape); // detach first-aid kit
        bulletAppState.getPhysicsSpace().remove(botiquinControl);
        ((Controller)app).getScenarioManager().getGuiPlayer().setSaludGUI(((Controller)app).getScenarioManager().getGuiPlayer().getSaludGUI()+this.vida);
        System.out.println("First-aid kit from scenario!"); // debugging
    }
    
        
}   
