/*
 * To change this template, choose Tools | Templates
 * aaaaand open the template in the editor.
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
 * @author rociotovar
 */
public class Gun implements WeaponInterface {
    private String id;
    private String name;
    private int munition;
    private Node weaponShape;
    private CharacterControl weaponControl;
    private SimpleApplication app;
    private BulletAppState bulletAppState;
    
    public Gun(SimpleApplication app, BulletAppState bulletAppState, Vector3f position, int munition, String id) {
        this.app = app;
        this.bulletAppState = bulletAppState;
        this.id = id;
        name = "Gun";
        munition = 1220;
        
        CylinderCollisionShape cilinder = new CylinderCollisionShape(new Vector3f(0.5f,1.5f,1.5f));
        weaponControl = new CharacterControl(cilinder, 0.5f);
        
        //TODO: Add weapon model
        weaponShape = (Node) app.getAssetManager().loadModel("Models/Elephant/Elephant.mesh.xml");
        weaponShape.scale(0.05f);
        weaponShape.addControl(weaponControl);
        weaponShape.setName(name);
        
        weaponControl.setPhysicsLocation(position);
    }
    
    
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
    
    public void addWeaponeToScenario() {
        bulletAppState.getPhysicsSpace().add(weaponControl);
        app.getRootNode().attachChild(weaponShape);
        System.out.println("Gun added to scenario!");
    }
    
    public void deleteFromScenario() {
        app.getRootNode().detachChild(weaponShape);
        bulletAppState.getPhysicsSpace().remove(weaponControl);
        System.out.println("Gun deleted from scenario!");
    }
    
}
