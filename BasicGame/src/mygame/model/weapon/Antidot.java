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

/**
 *
 * @author Rocío
 */
public class Antidot implements WeaponInterface {
    private String id;  // identification
    private String name;  // name of weapon
    private Node weaponShape;   
    private CharacterControl weaponControl;
    private SimpleApplication app;
    private BulletAppState bulletAppState;
    
    // constructor
    public Antidot(SimpleApplication app, BulletAppState bulletAppState, Vector3f position, String id) {
        this.app = app;
        this.bulletAppState = bulletAppState;
        this.id = id;
        name = "Antidot"; // type of weapon is Gun
        
        // creating collision box of gun as cilider shape
        CylinderCollisionShape cilinder = new CylinderCollisionShape(new Vector3f(0.5f,1.5f,0.5f));
        weaponControl = new CharacterControl(cilinder, 1.0f);
        
        //TODO: Add antidot model
        // Loading, scaling and adding control for our weapon.
        weaponShape = (Node) app.getAssetManager().loadModel("Scenes/antidoto.j3o");
        weaponShape.scale(1f);
        weaponShape.addControl(weaponControl);
        weaponShape.setName(name);
        
        // placing our weapon
        weaponControl.setPhysicsLocation(position);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getMunition() {
        return 0;
    }

    public Vector3f getPosition() {
        return weaponControl.getPhysicsLocation();
    }

    public void addWeaponeToScenario() {
        bulletAppState.getPhysicsSpace().add(weaponControl);
        app.getRootNode().attachChild(weaponShape); // attach weapon
        System.out.println("Antidot added to scenario!");  // debugging
    }

    public void deleteFromScenario() {
        app.getRootNode().detachChild(weaponShape); // detach weapon
        bulletAppState.getPhysicsSpace().remove(weaponControl);
        System.out.println("Antidot deleted from scenario!"); // debugging
    }
    
}
