/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.model.zombie;

import com.jme3.animation.AnimChannel;
import com.jme3.animation.AnimControl;
import com.jme3.app.SimpleApplication;
import com.jme3.bullet.collision.shapes.CompoundCollisionShape;
import com.jme3.bullet.control.CharacterControl;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

/**
 *
 * @author Floyd
 */
public abstract class Zombie implements ZombieInterface {

    protected SimpleApplication app;
    protected CharacterControl zombieControl;
    protected Spatial zombieShape;
    protected float speed;
    protected float hitpoints;
    protected AnimChannel channel;
    protected AnimControl control;
    protected int state = 0;
    protected boolean paused;
    protected RigidBodyControl colisions;
    protected Node node1;
    protected CompoundCollisionShape ccs;
    protected int id;

    protected Zombie(SimpleApplication app, Vector3f position, Vector3f viewDirection, int i) {
        this.app = app;
        this.id=i;
    }
    
    public void update() {
        if (!paused) {
            if (state == 3) { // dying, playing animation (only seting speed if comming back from pause)
                channel.setSpeed(1f);
                zombieControl.setWalkDirection(new Vector3f(0, 0, 0));
            } else {
                moveZombie();
            }
        } else {
            //GAME is paused
//            SoundManager.zombieSoundPause(app.getRootNode());

            zombieControl.setWalkDirection(new Vector3f(0, 0, 0));
            channel.setSpeed(0f);
        }
    }

    public CharacterControl getControl() {
        return zombieControl;
    }

    public RigidBodyControl getColision() {
        return colisions;
    }
    public Spatial getZombieShape(){
        return zombieShape;
    }
    
    Node getNode() {
        return node1;
    }

    protected abstract void moveZombie();


    // @David C. -- Añadido getters & setters del parámetro paused
    public void setPaused(boolean paused) {
        this.paused = paused;
    }

    public boolean isPaused() {
        return this.paused;
    }

    public CompoundCollisionShape getShapeForCollision() {
        return ccs;
    }

    public abstract void doDamage(int damage, boolean distance);
}
