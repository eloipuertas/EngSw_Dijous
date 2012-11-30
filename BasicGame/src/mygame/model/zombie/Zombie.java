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
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import java.util.Random;
import mygame.Controller;
import mygame.sound.SoundManager;

/**
 *
 * @author Floyd
 */
public class Zombie implements AnimEventListener, ZombieInterface {

    private static final int DISTFOLLOW = 50;
    private static final int ANGLEFOLLOW = 160;
    private static final int DISTATTACK = 7;
    private static final int DAMAGEDONE = 20;
    private SimpleApplication app;
    private CharacterControl zombieControl;
    //private Node zombieShape;
    private Spatial zombieShape;
    private float speed;
    private float hitpoints;
    private AnimChannel channel;
    private AnimControl control;
    private int state = 0;
    private boolean paused;
    private RigidBodyControl colisions;
    private Node node1;
    private CompoundCollisionShape ccs;
    //for random movement
    boolean randMoveSet = false;
    Random rand = new Random();
    int timeLeft;
    Vector3f moveDirection;
    float xIncrement;
    float zIncrement;

    public Zombie(SimpleApplication app, Vector3f position, Vector3f viewDirection, float speed) {
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
        moveDirection = viewDirection;


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
    
    //By Polit
    public Spatial getZombieShape(){
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

    private void moveZombie() {
        SoundManager.zombieSoundPlay(app.getRootNode()); // Reproduce el sonido de los zombies
        Vector3f zombiePos = zombieControl.getPhysicsLocation();
        Vector3f playerPos = ((Controller) app).getPlayerManager().getPlayerPosition();

        float dist = playerPos.distance(zombiePos);
        float angle = zombieControl.getViewDirection().normalize().angleBetween(playerPos.subtract(zombiePos).normalize());

        if (dist < DISTFOLLOW && angle < (ANGLEFOLLOW * Math.PI / 360)) {
            // follow player
            if (dist < DISTATTACK) { //near the player, attack and stop
                if (state != 2) {
                    //((Controller) app).getPlayerManager().doDamage(DAMAGEDONE); //do damage once every animation!!!
                    channel.setAnim("attack", 0.50f);
                    channel.setLoopMode(LoopMode.DontLoop);
                    System.out.println("attack");
                }
                state = 2;//attack
                zombieControl.setWalkDirection(new Vector3f(0, 0, 0));
                channel.setSpeed(1f);
            } else if (state != 2) {
                state = 1;
                // Si el juego NO esta mutado o pausado ejecutar la siguiente linea
                //SoundManager.zombieSoundSetVolume(app.getRootNode(), 1 / dist);

                Vector3f walkDirection = new Vector3f((playerPos.x - zombiePos.x), 0, (playerPos.z - zombiePos.z));

                zombieControl.setWalkDirection(walkDirection.normalize().mult(speed));
                zombieControl.setViewDirection(walkDirection);
                channel.setSpeed(1f);
            }
        } else {
            //random movement
            state = 1;//move

            if (!randMoveSet) {
                System.out.println("set random move " + moveDirection);
                rand = new Random();
                timeLeft = rand.nextInt(400) + 100;

                xIncrement = (rand.nextFloat() - 0.5f) / 600;
                zIncrement = (rand.nextFloat() - 0.5f) / 600;

                randMoveSet = true;
            } else {
                timeLeft--;
                if (timeLeft <= 0) {
                    randMoveSet = false;
                }
            }

            //changing the move direction
            moveDirection = moveDirection.add(xIncrement, 0f, zIncrement);
            moveDirection = moveDirection.normalize().mult(speed);

            zombieControl.setWalkDirection(moveDirection);
            zombieControl.setViewDirection(moveDirection);
            //zombieControl.setWalkDirection(new Vector3f(0, 0, 0));
        }

        /*
         if (dist < DISTATTACK && angle < (ANGLEFOLLOW * Math.PI / 360)) { //follow!!
         if (state != 2) {
         channel.setAnim("attack", 0.50f);
         channel.setLoopMode(LoopMode.DontLoop);
         System.out.println("attack");
         }
         state = 2;//attack
         zombieControl.setWalkDirection(new Vector3f(0, 0, 0));
         channel.setSpeed(1f);

         } else if (dist < DISTFOLLOW && angle < (ANGLEFOLLOW * Math.PI / 360) && state != 2) {
         state = 1;//move

         } else {
         state = 0;//stand
         //audio_zombie.stop();
         zombieControl.setWalkDirection(new Vector3f(0, 0, 0));
         //channel.setAnim(null);
         //channel.setAnim("stand"); de moment no te animacio stand
         //channel.setAnim("walk");
         }/**/

        SoundManager.zombieSoundSetVolume(app.getRootNode(), 7 / dist);
    }

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

    public void doDamage(int damage, boolean distance) {
        System.out.println("zombie class -> damage done");
        if (distance) { //long range, allways does damage
            hitpoints = hitpoints - damage;
            if (hitpoints <= 0) {
                killZombie();
            }
        } else {
            Vector3f zombiePos = zombieControl.getPhysicsLocation();
            Vector3f playerPos = ((Controller) app).getPlayerManager().getPlayerPosition();

            if (playerPos.distance(zombiePos) < 10) {
                hitpoints = hitpoints - damage;
                if (hitpoints <= 0) {
                    killZombie();
                }
            }
        }
    }

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
