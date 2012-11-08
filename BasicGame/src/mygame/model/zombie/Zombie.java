/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.model.zombie;

import com.jme3.app.SimpleApplication;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.collision.shapes.CapsuleCollisionShape;
import com.jme3.bullet.collision.shapes.CollisionShape;
import com.jme3.bullet.control.CharacterControl;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.bullet.util.CollisionShapeFactory;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;

/**
 *
 * @author Floyd
 */
public class Zombie {
    
    private CharacterControl zombieControl;
    private Node zombieShape;
    
    private float speed;

    Zombie(SimpleApplication app,float x, float y, float z, float speed) {   
        CapsuleCollisionShape capsule = new CapsuleCollisionShape(3f, 4f);
        zombieControl = new CharacterControl(capsule, 0.01f);
        zombieShape = (Node) app.getAssetManager().loadModel("Models/Oto/Oto.mesh.xml");

        zombieShape.addControl(zombieControl);
        
        //MODIFICACION PARA EL GRUPO DE LOS ZOMBIES
        zombieShape.setName("Zombie");
        
        
        zombieControl.setPhysicsLocation(new Vector3f(x, y, z));
       
        this.speed = speed;
    }

    CharacterControl getControl() {
        return zombieControl;
    }

    Node getNode() {
        return zombieShape;
    }
    
    public float getSpeed() {
        return speed;
    }
}
