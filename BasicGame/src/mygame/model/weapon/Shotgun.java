/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.model.weapon;

import com.jme3.app.SimpleApplication;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.collision.shapes.CylinderCollisionShape;
import com.jme3.bullet.control.CharacterControl;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import mygame.model.weapon.WeaponInterface;

/**
 *
 * @author Harpo
 */
public class Shotgun implements WeaponInterface {

       private String id;  // identification
    private String name;  // name of weapon
    private int munition;  // remained munition
    private Node weaponShape;   
    private CharacterControl weaponControl;
    private SimpleApplication app;
    private BulletAppState bulletAppState;
    
    // constructor
    public Shotgun(SimpleApplication app, BulletAppState bulletAppState, Vector3f position, int munition, String id) {
        this.app = app;
        this.bulletAppState = bulletAppState;
        this.id = id;
        name = "MachineGun"; // type of weapon is Gun
        munition = 1220;  // default munition
        
        // creating collision box of gun as cilider shape
        CylinderCollisionShape cilinder = new CylinderCollisionShape(new Vector3f(0.5f,1.5f,1.5f));
        weaponControl = new CharacterControl(cilinder, 1.0f);
        
        //TODO: Add weapon model
        // Loading, scaling and adding control for our weapon.
        weaponShape = (Node) app.getAssetManager().loadModel("Character/Pistola.mesh.xml");
        weaponShape.scale(0.4f);
        weaponShape.addControl(weaponControl);
        weaponShape.setName(name);
        
        // placing our weapon
        weaponControl.setPhysicsLocation(position);
    }
    
    // Setters and getters for MachineGun's attributes: id, name, munition and position
    public String getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public int getMunition() {
        return munition;
    }
    
    public Vector3f getPosition() {
        return weaponControl.getPhysicsLocation();
    }
    
    // Method which adds Gun object into Scenario caled in 'ObjectsInGame'
    public void addWeaponeToScenario() {
        bulletAppState.getPhysicsSpace().add(weaponControl);
        app.getRootNode().attachChild(weaponShape); // attach weapon
        System.out.println("MachineGun added to scenario!");  // debugging
    }
    
    // Method which deletes Gun object from Scenario called in 'ObjectsInGame'
    public void deleteFromScenario() {
        app.getRootNode().detachChild(weaponShape); // detach weapon
        bulletAppState.getPhysicsSpace().remove(weaponControl);
        System.out.println("MachineGun deleted from scenario!"); // debugging
    }
}
