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
import com.jme3.bullet.collision.shapes.CapsuleCollisionShape;
import com.jme3.bullet.control.CharacterControl;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.audio.AudioNode;
import com.jme3.bullet.collision.shapes.CompoundCollisionShape;
import mygame.sound.SoundManager;

/**
 *
 * @author Floyd
 */
public class Zombie implements AnimEventListener, ZombieInterface {

    private SimpleApplication app;
    private CharacterControl zombieControl;
    private Node zombieShape;
    private float speed;
    private AnimChannel channel;
    private AnimControl control;
    private final int distFollow = 50;
    private final int angleFollow = 160;
    
    //MODIFICACION PARA EL GRUPO DE LOS ZOMBIES
    private boolean paused  ;
    
    private RigidBodyControl colisions;
    private Node node1;
    
    private CompoundCollisionShape ccs;
    
    Zombie(SimpleApplication app, Vector3f position, Vector3f viewDirection, float speed) {
        this.app = app;
        CapsuleCollisionShape cilinder = new CapsuleCollisionShape(1.5f,2f, 1);
        zombieControl = new CharacterControl(cilinder, 0.1f);
        zombieShape = (Node) app.getAssetManager().loadModel("Models/zombie/zombie.mesh.j3o");
        node1=new Node();
        node1.attachChild(zombieShape);
        zombieShape.move(0f, -2.5f, 0f);
        node1.addControl(zombieControl);
        
        zombieShape.scale(3f);
        colisions=new RigidBodyControl(1f);
        node1.addControl(colisions);
        ccs=new CompoundCollisionShape();
        ccs.addChildShape(cilinder, new Vector3f(0f,4.2f,0f));
        colisions.setCollisionShape(cilinder);
        colisions.setAngularDamping(0);
        colisions.setFriction(0);
        colisions.setKinematic(true);
        //MODIFICACION PARA EL GRUPO DE LOS ZOMBIES
        zombieShape.setName("Zombie");
        zombieControl.setPhysicsLocation(position);
        

        this.speed = speed;
        initAnimation();
    }

    public CharacterControl getControl() {
        return zombieControl;
    }
    public RigidBodyControl getColision(){
        return colisions;
    }

    Node getNode() {
        return node1;
    }


    private void initAnimation() {

        control = zombieShape.getControl(AnimControl.class);
        channel = control.createChannel();
        channel.setAnim("walk");
        channel.setSpeed(0f);
        channel.setLoopMode(LoopMode.Loop);
        
        //channel.setAnim("stand"); de moment no te animacio stand
    }

    public void update(Vector3f playerPos) {
        Vector3f viewDirection = new Vector3f();
        Vector3f walkDirection = new Vector3f();

        Vector3f zombiePos = zombieControl.getPhysicsLocation();

        float dist = playerPos.distance(zombiePos);
        float angle = zombieControl.getViewDirection().normalize().angleBetween(playerPos.subtract(zombiePos).normalize());

        // @David C. -- Añadido condición del parámetro pause
        if (dist < distFollow && angle < (angleFollow * Math.PI / 360) && !paused  ) {
            
         
            /* @Isa 
             * Si el juego NO esta mutado o pausado ejecutar la siguiente linea
            SoundManager.zombieSoundSetVolume(app.getRootNode(), 1 / dist);          
             */
            
            
            SoundManager.zombieSoundPlay(app.getRootNode()); // Reproduce el sonido de los zombies
            
            walkDirection.set(new Vector3f((playerPos.x - zombiePos.x) * speed, 0, (playerPos.z - zombiePos.z) * speed));
            viewDirection.set(new Vector3f((playerPos.x - zombiePos.x) * speed, 0, (playerPos.z - zombiePos.z) * speed));

            zombieControl.setWalkDirection(walkDirection);
            zombieControl.setViewDirection(viewDirection);

            //Animation
            //if (!channel.getAnimationName().equals("walk")) {
            channel.setSpeed(1f);
            //}
        } else {
            
            //audio_zombie.stop();
            zombieControl.setWalkDirection(new Vector3f(0, 0, 0));
            channel.setSpeed(0f);
            //channel.setAnim(null);
            //channel.setAnim("stand"); de moment no te animacio stand
            //channel.setAnim("walk");
        }
    }

    public void onAnimCycleDone(AnimControl control, AnimChannel channel, String animName) {
        if (animName.equals("walk")) {
            System.out.println("looop");
            //channel.setAnim("stand", 0.50f); de moment no te animacio stand
            channel.setAnim("walk", 0.50f);
            channel.setLoopMode(LoopMode.DontLoop);
            channel.setSpeed(1f);
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
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
