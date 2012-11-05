/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.model.zombie;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.control.CharacterControl;
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
    private SimpleApplication  app;
    private ArrayList<Zombie> zombies = new ArrayList<Zombie>();

    public ZombieManager(Application app, int numberZombies) {
        /**
         * Set up Physics
         */
        this.app = (SimpleApplication ) app;
        bulletAppState = this.app.getStateManager().getState(BulletAppState.class);
        rootNode = this.app.getRootNode();

        for (int i = 0; i < numberZombies; i++) {
            Zombie z = new Zombie(this.app, 10f * i, 5f, -4f * i, 0.003f*(i+1));
            zombies.add(z);
            addZombieToScene(z);
        }
    }

    private void addZombieToScene(Zombie z) {
        bulletAppState.getPhysicsSpace().add(z.getControl());
        rootNode.attachChild(z.getNode());
    }

    public void update(Vector3f playerPos) {
        Vector3f viewDirection = new Vector3f();
        Vector3f walkDirection = new Vector3f();
        
        for (Zombie z : zombies) {

            CharacterControl zc = z.getControl();
            Vector3f zombiePos = zc.getPhysicsLocation();
            float xdist = playerPos.x - zombiePos.x;
            float zdist = playerPos.z - zombiePos.z;
            if (((xdist * xdist) + (zdist * zdist)) < 1000) {
                float speed = z.getSpeed();

                walkDirection.set(new Vector3f((playerPos.x - zombiePos.x) * speed, 0, (playerPos.z - zombiePos.z) * speed));
                viewDirection.set(new Vector3f((playerPos.x - zombiePos.x) * speed, 0, (playerPos.z - zombiePos.z) * speed));

                zc.setWalkDirection(walkDirection);
                zc.setViewDirection(viewDirection);
            }else{
                zc.setWalkDirection(new Vector3f(0,0,0));
            }
        }


    }
}
