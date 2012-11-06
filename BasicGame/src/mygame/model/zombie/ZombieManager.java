/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.model.zombie;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.bullet.BulletAppState;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class ZombieManager {

    private BulletAppState bulletAppState;
    private Node rootNode = new Node("gameRoot");
    private SimpleApplication app;
    private ArrayList<Zombie> zombies = new ArrayList<Zombie>();

    public ZombieManager(Application app, int numberZombies) {
        /**
         * Set up Physics
         */
        this.app = (SimpleApplication) app;
        bulletAppState = this.app.getStateManager().getState(BulletAppState.class);
        rootNode = this.app.getRootNode();

//        for (int i = 0; i < numberZombies; i++) {
//            Zombie z = new Zombie(this.app, 10f * i, 5f, -4f * i, 0.003f * (i + 1));
//            zombies.add(z);
//            addZombieToScene(z);
//        }

        Zombie z = new Zombie(this.app, new Vector3f(60f, 5f, 0f), new Vector3f(1f, 0f, 1f), 0.003f);
        zombies.add(z);
        addZombieToScene(z);
 
//        z = new Zombie(this.app, new Vector3f(40f, 5f, 40f), 0.006f);
//        zombies.add(z);
//        addZombieToScene(z);
// 
//        z = new Zombie(this.app, new Vector3f(0f, 5f, 60f), 0.01f);
//        zombies.add(z);
//        addZombieToScene(z);
// 
//        z = new Zombie(this.app, new Vector3f(0f, 5f, 65f), 0.015f);
//        zombies.add(z);
//        addZombieToScene(z);
// 
//        z = new Zombie(this.app, new Vector3f(0f, 5f, 70f), 0.009f);
//        zombies.add(z);
//        addZombieToScene(z);
    }

    private void addZombieToScene(Zombie z) {
        bulletAppState.getPhysicsSpace().add(z.getControl());
        rootNode.attachChild(z.getNode());
    }

    public void update(Vector3f playerPos) {
        for (Zombie z : zombies) {
            z.update(playerPos);
        }
    }
}
