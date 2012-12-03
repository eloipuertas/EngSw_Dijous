/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.model.zombie;

import com.jme3.bullet.collision.shapes.CompoundCollisionShape;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.math.Vector3f;
import com.jme3.scene.Spatial;

/**
 *
 * @author Floyd
 */
public interface ZombieInterface {

    /**
     * Stefan D. Grup F: For zombie manager
     * @param vector3f 
     */
    public void update();
    
    /**
     * Stefan D. Grup F: For zombie manager
     * @return 
     */
    public RigidBodyControl getColision();
    
    /**
     * Stefan D. Grup F:
     * Called every tick to update zombies position/animations/actions
     * IMO pause is not necessary since you just can stop calling update!!
     * 
     * @return Collision shape, I hope that's what you need team G, to add to shotables
     */
    public CompoundCollisionShape getShapeForCollision();
    
    /**
     * Stefan D. Grup F:
     * Called to do damage to a specific zombie
     * 
     * @param damage how much damage?
     * @param distance for mele weapons false, for long range weapons true
     */
    public void doDamage(int damage, boolean distance);

    public void setPaused(boolean paused);
    
    public Spatial getZombieShape();
    
}
