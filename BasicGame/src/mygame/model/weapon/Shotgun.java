/*
 * To change this template, choose Tools | Templates
 * aaaaand open the template in the editor.
 * 
 */

// Creating Porra class for our Porra weapon

package mygame.model.weapon;
import com.jme3.app.SimpleApplication;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.collision.shapes.CylinderCollisionShape;
import com.jme3.bullet.control.CharacterControl;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;

/**
 *
 * @author rociotovar
 * @test and comments ernest
 */

public class Shotgun implements WeaponInterface {
    private String id;  // identification
    private String name;  // name of weapon
    private int munition;
    private Node weaponShape;   
    private CharacterControl weaponControl;
    private SimpleApplication app;
    private BulletAppState bulletAppState;
    
    // constructor
    public Shotgun(SimpleApplication app, BulletAppState bulletAppState, Vector3f position, int munition, String id) {
        this.app = app;
        this.bulletAppState = bulletAppState;
        this.id = id;
        name = "Shotgun"; // type of weapon is shotgun
        munition = 1000;
        
        // creating collision box of gun as cilider shape
        CylinderCollisionShape cilinder = new CylinderCollisionShape(new Vector3f(0.5f,1.5f,1.5f));
        weaponControl = new CharacterControl(cilinder, 0.5f);
        
        //TODO: Add weapon model
        // Loading, scaling and adding control for our weapon.
        weaponShape = (Node) app.getAssetManager().loadModel("Character/Arma2.j3o");
        weaponShape.scale(1.5f);
        //weaponShape.move(0f, -2f, 0f);
        weaponShape.addControl(weaponControl);
        weaponShape.setName(name);
        
        // placing our weapon
        weaponControl.setPhysicsLocation(position);
    }
    
    // Setters and getters for Porra's attributes: id, name, munition and position
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
        System.out.println("Shotgun added to scenario!");  // debugging
    }
    
    // Method which deletes Gun object from Scenario called in 'ObjectsInGame'
    public void deleteFromScenario() {
        app.getRootNode().detachChild(weaponShape); // detach weapon
        bulletAppState.getPhysicsSpace().remove(weaponControl);
        System.out.println("Shotgun deleted from scenario!"); // debugging
    }
    
}
