/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.States.Scenario;

import com.jme3.app.SimpleApplication;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.collision.PhysicsCollisionEvent;
import com.jme3.bullet.collision.PhysicsCollisionListener;
import com.jme3.bullet.collision.shapes.CollisionShape;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.bullet.util.CollisionShapeFactory;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import java.util.Random;

/**
 *
 * @author Harpo
 */
public class DamageCollision extends RigidBodyControl implements PhysicsCollisionListener {

 
    private boolean isCollision = false;
    BulletAppState bulletAppState;
    GUIPlayerMain gui;

    public DamageCollision(BulletAppState bulletAppSt, GUIPlayerMain guiP) {
        this.gui = guiP;
        this.bulletAppState = bulletAppSt;
        this.bulletAppState.getPhysicsSpace().addCollisionListener(this);
       
   
       
       
    }

    public void collision(PhysicsCollisionEvent event) {
        try{ 
           System.out.println(event.getNodeA().getName()+ " " + event.getNodeB().getName());
           
            if(event.getNodeA().getName().equals("Personaje") &&  event.getNodeB().getName().equals("Zombie")){
                isCollision = true;
                gui.setSaludGUI(gui.getSaludGUI()- (int) (Math.random () * (20) + 5));
                isCollision = false;
            }else if(event.getNodeA().getName().equals("Zombie") &&  event.getNodeB().getName().equals("Personaje")){
                isCollision = true;
                gui.setSaludGUI(gui.getSaludGUI()- (int) (Math.random () * (20) + 5));
                isCollision = false;
                
            }else{
                isCollision = false;
            }
            
            
            if (this.isCollision ) System.out.println("Botiquin recogido");
        
        }catch(Exception e){}

    }
       
    public boolean isCollision(){
        return this.isCollision;
     
    }
       
    public void setCollision(boolean collision){
        this.isCollision = collision;
           
    }
       

}
