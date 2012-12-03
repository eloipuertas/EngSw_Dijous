/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.model.zombie;

import com.jme3.animation.AnimChannel;
import com.jme3.animation.AnimControl;
import com.jme3.animation.AnimEventListener;
import com.jme3.animation.LoopMode;
import com.jme3.app.SimpleApplication;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.collision.shapes.CapsuleCollisionShape;
import com.jme3.bullet.collision.shapes.CompoundCollisionShape;
import com.jme3.bullet.control.CharacterControl;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import java.util.Random;
import mygame.Controller;
import mygame.sound.SoundManager;

/**
 *
 * @author Floyd
 */
public abstract class Zombie implements AnimEventListener, ZombieInterface {

    protected static final int DISTFOLLOW = 50;
    protected static final int DISTDETECT = 20;
    protected static final int ANGLEFOLLOW = 160;
    protected static final int DISTATTACK = 7;
    protected static final int DAMAGEDONE = 20;
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

    protected Zombie(SimpleApplication app, Vector3f position, Vector3f viewDirection, float speed) {
        this.app = app;

        CapsuleCollisionShape cilinder = new CapsuleCollisionShape(1.5f, 2f, 1);
        zombieControl = new CharacterControl(cilinder, 0.1f);
        zombieShape = app.getAssetManager().loadModel("Models/zombie/zombie.mesh.j3o");
        node1 = new Node();
        node1.attachChild(zombieShape);
        zombieShape.move(0f, -2.5f, 0f);
        node1.addControl(zombieControl);

        zombieShape.scale(3f);
        colisions = new RigidBodyControl(1f);
        node1.addControl(colisions);
        ccs = new CompoundCollisionShape();
        ccs.addChildShape(cilinder, new Vector3f(0f, 4.2f, 0f));
        colisions.setCollisionShape(cilinder);
        colisions.setAngularDamping(0);
        colisions.setFriction(0);
        colisions.setKinematic(true);
        //MODIFICACION PARA EL GRUPO DE LOS ZOMBIES
        zombieShape.setName("Zombie");
        zombieControl.setPhysicsLocation(position);
        zombieControl.setViewDirection(viewDirection);


        this.speed = speed;
        this.hitpoints = 100;
        initAnimation();
    }

    public CharacterControl getControl() {
        return zombieControl;
    }

    public RigidBodyControl getColision() {
        return colisions;
    }
    public Spatial getZombieSHape(){
        return zombieShape;
    }
    
    Node getNode() {
        return node1;
    }

    private void initAnimation() {

        control = zombieShape.getControl(AnimControl.class);
        control.addListener(this);
        channel = control.createChannel();
        channel.setAnim("walk");
        channel.setSpeed(0f);
        channel.setAnim("stand");
        channel.setSpeed(1f);
        channel.setLoopMode(LoopMode.Loop);

        //channel.setAnim("stand"); de moment no te animacio stand
    }

    public void update() {
        if (!paused) {
            if (state == 3) { // dying, playing animation (only seting speed if comming back from pause)
                channel.setSpeed(1f);
            } else {
                moveZombie();
            }
        } else {
            //GAME is paused
            SoundManager.zombieSoundPause(app.getRootNode());

            zombieControl.setWalkDirection(new Vector3f(0, 0, 0));
            channel.setSpeed(0f);
        }
    }

    protected abstract void moveZombie();

    public void onAnimCycleDone(AnimControl control, AnimChannel channel, String animName) {

        if (animName.equals("walk") && state == 1) {

            channel.setAnim("walk", 0.50f);
            channel.setLoopMode(LoopMode.DontLoop);
            channel.setSpeed(1f);
        } else if (animName.equals("walk") && state == 0) {

            channel.setAnim("stand", 0.50f);
            channel.setLoopMode(LoopMode.DontLoop);
            channel.setSpeed(1f);
        } else if (animName.equals("stand") && state == 0) {

            channel.setAnim("stand", 0.50f);
            channel.setLoopMode(LoopMode.DontLoop);
            channel.setSpeed(0f);
        } else if (animName.equals("stand") && state == 1) {

            channel.setAnim("walk", 0.50f);
            channel.setLoopMode(LoopMode.DontLoop);
            channel.setSpeed(1f);
        } else if (animName.equals("attack")) {

            channel.setAnim("walk", 0.50f);
            channel.setLoopMode(LoopMode.DontLoop);
            channel.setSpeed(1f);
            state = 0;
        } else if (animName.equals("death")) {
            node1.detachChild(zombieShape);
            app.getRootNode().attachChild(zombieShape);
            zombieShape.setLocalTranslation(colisions.getPhysicsLocation());
            zombieShape.move(0f, -2.5f, 0f);
            node1.removeControl(colisions);
            node1.removeControl(zombieControl);
            this.app.getStateManager().getState(BulletAppState.class).getPhysicsSpace().remove(colisions);
            this.app.getStateManager().getState(BulletAppState.class).getPhysicsSpace().remove(zombieControl);

            ((Controller) app).getZombieManager().deleteZombie(this);
        }
    }

    public void onAnimChange(AnimControl control, AnimChannel channel, String animName) {
        // unused
    }

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

    public void killZombie() {
        state = 3;
        //zombieControl.setFallSpeed(1000000f);    
        channel.setAnim("death");
        channel.setSpeed(0.4f);
        System.out.println("La animacio dura" + channel.getAnimMaxTime());
        channel.setLoopMode(LoopMode.DontLoop);
        System.out.println(((Controller) app).getZombieManager());
    }
}
