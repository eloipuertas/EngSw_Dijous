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
import mygame.Controller;

/**
 *
 * @author user
 */
public class ZombieManager implements ZombieManagerInterface {

    private BulletAppState bulletAppState;
    private Node rootNode = new Node("gameRoot");
    private SimpleApplication app;
    private boolean paused;
    private ArrayList<ZombieInterface> zombies = new ArrayList<ZombieInterface>();
    private int[] groups = new int[]{0x00000002, 0x00000004, 0x00000008, 0x00000010, 0x00000020, 0x00000040, 0x00000080, 0x00000100, 0x00000200, 0x00000400, 0x00000800};
    private int colisionGroupCounter = 0;
    private int id = 0;

    public ZombieManager(Application app) {
        /**
         * Set up Physics
         */
        this.app = (SimpleApplication) app;
        bulletAppState = this.app.getStateManager().getState(BulletAppState.class);
        rootNode = this.app.getRootNode();
        //bulletAppState.getPhysicsSpace().enableDebug(app.getAssetManager());
//        for (int i = 0; i < numberZombies; i++) {
//            Zombie z = new Zombie(this.app, 10f * i, 5f, -4f * i, 0.003f * (i + 1));
//            zombies.add(z);
//            addZombieToScene(z);
//        }
        
        //TO DELETE!!!! JUST FOR TESTING, WILL BE CALLED BY TEAM E!!!!!!!!!!!!!!
        /*
        addZombieBasic(new Vector3f(5f, 5f, 0f), new Vector3f(0f, 0f, 1f), difficulty.low);
        addZombieBasic(new Vector3f(15f, 5f, 10f), new Vector3f(1f, 0f, 1f), difficulty.high);
        addZombieBasic(new Vector3f(0f, 5f, 10f), new Vector3f(-1f, 0f, 1f), difficulty.high);
        addZombieBasic(new Vector3f(0f, 5f, 10f), new Vector3f(0f, 0f, -1f), difficulty.low);
        
        addZombieBasic(new Vector3f(20f, 1f, 15f), new Vector3f(0f, 0f, 1f), difficulty.low);
        addZombiePetia(new Vector3f(20f, 1f, 10f), new Vector3f(0f, 0f, 1f), difficulty.high);
        addZombieOriol(new Vector3f(15f, 1f, 20f), new Vector3f(0f, 0f, 1f), difficulty.high);
/**/


        setZombiColission();
        
        
/*
        z = new ZombieBasic(this.app, new Vector3f(15f, 5f, 10f), new Vector3f(1f, 0f, 1f), 0.05f, id);
=======
        /*Zombie z = new Zombie(this.app, new Vector3f(5f, 5f, 0f), new Vector3f(0f, 0f, 1f), 0.05f);
        zombies.add(z);
        addZombieToScene(z);
         
        z = new Zombie(this.app, new Vector3f(15f, 5f, 10f), new Vector3f(1f, 0f, 1f), 0.05f);
>>>>>>> 3bef85e616f26fc3287f58b423a667e9c004b047
        zombies.add(z);
        addZombieToScene(z);
        id++;

        z = new ZombieBasic(this.app, new Vector3f(0f, 5f, 10f), new Vector3f(1f, 0f, 1f), 0.05f, id);
        zombies.add(z);
        addZombieToScene(z);
        id++;

        z = new ZombieBasic(this.app, new Vector3f(0f, 5f, 10f), new Vector3f(-1f, 0f, -1f), 0.05f, id);
        zombies.add(z);
        addZombieToScene(z);
        id++;

        z = new ZombieBasic(this.app, new Vector3f(0f, 5f, 10f), new Vector3f(1f, 0f, -1f), 0.05f, id);
        zombies.add(z);
        addZombieToScene(z);
        id++;

        /**/
        //zombies.get(2).doDamage(100, true);
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

    public void addZombieBasic(Vector3f position, Vector3f viewDirection, difficulty dif) {
        ZombieBasic z = new ZombieBasic(this.app, position, viewDirection, dif, id);
        zombies.add(z);
        addZombieToScene(z);
        id++;
    }

    public void addZombiePetia(Vector3f position, Vector3f viewDirection, difficulty dif) {
        ZombiePetia z = new ZombiePetia(this.app, position, viewDirection, dif, id);
        zombies.add(z);
        addZombieToScene(z);
        id++;
    }

    public void addZombieOriol(Vector3f position, Vector3f viewDirection, difficulty dif) {
        ZombieOriol z = new ZombieOriol(this.app, position, viewDirection, dif, id);
        zombies.add(z);
        addZombieToScene(z);
        id++;
    }

    private void addZombieToScene(Zombie z) {
        z.getControl().setCollisionGroup(groups[colisionGroupCounter]);
        z.getControl().removeCollideWithGroup(groups[colisionGroupCounter]);
        z.getControl().addCollideWithGroup(0x00000001);
        z.getColision().setCollisionGroup(groups[colisionGroupCounter]);
        z.getColision().removeCollideWithGroup(groups[colisionGroupCounter]);
        z.getColision().addCollideWithGroup(0x00000001);
        colisionGroupCounter += 1;
        bulletAppState.getPhysicsSpace().add(z.getControl());
        bulletAppState.getPhysicsSpace().add(z.getColision());


        //bulletAppState.getPhysicsSpace().add(z.getNode().getChild("Zombie"));
        rootNode.attachChild(z.getNode());
        ((Controller) app).getPlayerManager().getShootables().attachChild(z.getNode());
    }

    private void setZombiColission() {
        int i = 0;
        for (ZombieInterface z : zombies) {
            i = 0;
            while (i < colisionGroupCounter) {
                if (z.getColision().getCollisionGroup() != groups[i]) {
                    System.out.println("!!!!" + z.getColision().getCollisionGroup() + " " + groups[i]);
                    z.getColision().addCollideWithGroup(groups[i]);
                }
                i += 1;
            }
        }
    }

    public void update() {
        for (ZombieInterface z : zombies) {
            z.update();

        }
    }

    // @David C. -- Añadido getters & setters del parámetro paused
    public boolean isPaused() {
        return paused;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
        for (ZombieInterface z : zombies) {
            z.setPaused(this.paused);
        }
    }

    public ArrayList<ZombieInterface> getZombies() {
        return zombies;

    }

    public void deleteZombie(Zombie aThis) {
        zombies.remove(aThis);
    }

    public void setDifficulty(difficulty dif) {
        for (ZombieInterface z : zombies) {
            z.setDifficulty(dif);
        }
    }

}
