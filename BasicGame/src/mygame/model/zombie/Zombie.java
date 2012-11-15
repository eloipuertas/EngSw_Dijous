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
import com.jme3.bullet.collision.shapes.CollisionShape;
import com.jme3.bullet.control.CharacterControl;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.bullet.util.CollisionShapeFactory;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.audio.AudioNode;
import com.jme3.bullet.collision.shapes.CompoundCollisionShape;
import com.jme3.bullet.collision.shapes.CylinderCollisionShape;
import com.jme3.bullet.control.GhostControl;
import com.jme3.scene.Geometry;
import com.jme3.scene.Mesh;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Cylinder;

/**
 *
 * @author Floyd
 */
public class Zombie implements AnimEventListener {

    private SimpleApplication app;
    private CharacterControl zombieControl;
    private Node zombieShape;
    private AudioNode audio_zombie;
    private float speed;
    private AnimChannel channel;
    private AnimControl control;
    private final int distFollow = 50;
    private final int angleFollow = 160;
    private RigidBodyControl colisions;
    private Node node1;
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
        CompoundCollisionShape ccs=new CompoundCollisionShape();
        ccs.addChildShape(cilinder, new Vector3f(0f,4.2f,0f));
        colisions.setCollisionShape(cilinder);
        colisions.setAngularDamping(0);
        colisions.setFriction(0);
        colisions.setKinematic(true);
        //MODIFICACION PARA EL GRUPO DE LOS ZOMBIES
        zombieShape.setName("Zombie");
        zombieControl.setPhysicsLocation(position);
        

        this.speed = speed;
        initAudio(); // initializes audio
        initAnimation();
    }

    CharacterControl getControl() {
        return zombieControl;
    }
    RigidBodyControl getColision(){
        return colisions;
    }

    Node getNode() {
        return node1;
    }

    private void initAudio() {
        audio_zombie = new AudioNode(app.getAssetManager(), "Sounds/Effects/Zombies1.wav", false);
        audio_zombie.setLooping(true);
        app.getRootNode().attachChild(audio_zombie);

    }

    private void initAnimation() {

        control = zombieShape.getControl(AnimControl.class);
        channel = control.createChannel();
        channel.setAnim("walk");
        //channel.setAnim("stand"); de moment no te animacio stand
    }

    public void update(Vector3f playerPos) {
        Vector3f viewDirection = new Vector3f();
        Vector3f walkDirection = new Vector3f();

        Vector3f zombiePos = zombieControl.getPhysicsLocation();

        float dist = playerPos.distance(zombiePos);
        float angle = zombieControl.getViewDirection().normalize().angleBetween(playerPos.subtract(zombiePos).normalize());

        //System.out.print(zombieControl.getViewDirection()+" ");

        if (dist < distFollow && angle < (angleFollow * Math.PI / 360)) {
            audio_zombie.setVolume(1 / dist);
            audio_zombie.play();

            walkDirection.set(new Vector3f((playerPos.x - zombiePos.x) * speed, 0, (playerPos.z - zombiePos.z) * speed));
            viewDirection.set(new Vector3f((playerPos.x - zombiePos.x) * speed, 0, (playerPos.z - zombiePos.z) * speed));

            zombieControl.setWalkDirection(walkDirection);
            zombieControl.setViewDirection(viewDirection);

            //Animation
            if (!channel.getAnimationName().equals("walk")) {
                channel.setAnim("walk", 0.50f);
                channel.setLoopMode(LoopMode.Loop);
            }
        } else {
            audio_zombie.stop();
            zombieControl.setWalkDirection(new Vector3f(0, 0, 0));
            //channel.setAnim("stand"); de moment no te animacio stand
            channel.setAnim("walk");
        }
    }

    public void onAnimCycleDone(AnimControl control, AnimChannel channel, String animName) {
        if (animName.equals("walk")) {
            //channel.setAnim("stand", 0.50f); de moment no te animacio stand
            channel.setAnim("walk", 0.50f);
            channel.setLoopMode(LoopMode.DontLoop);
            channel.setSpeed(1f);
        }
    }

    public void onAnimChange(AnimControl control, AnimChannel channel, String animName) {
        // unused
    }
}
