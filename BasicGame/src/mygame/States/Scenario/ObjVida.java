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

/**
 *
 * @author Harpo
 */
public class ObjVida extends RigidBodyControl implements PhysicsCollisionListener {

    private SimpleApplication app;
    private final Node objShape;
    private final RigidBodyControl landscape;
    private boolean isCollision = false;
    private int contador;
    BulletAppState bulletAppState;
    private int vida = 35;

   
    
    public ObjVida(BulletAppState bulletAppSt, SimpleApplication application,int cont, float posX, float posY, float posZ) {
        
        
        this.app = application;
        this.contador = cont;
        this.bulletAppState = bulletAppSt;
        this.bulletAppState.getPhysicsSpace().addCollisionListener(this);
       
        //Seleccionamos el modelo que será el botiquín
        objShape = (Node) app.getAssetManager().loadModel("Scenes/objetoVida.j3o");
       
        //Guardamos la posición
        this.objShape.setLocalTranslation(new Vector3f(posX, posY, posZ));
       
        //Le asignamos un identificador
        objShape.setName("ObjetoVida"+this.contador);
       
        //Configuramos la colision y lo mostramos
        CollisionShape sceneShape = CollisionShapeFactory.createMeshShape((Node) objShape);
        landscape = new RigidBodyControl(sceneShape, 0);
        objShape.addControl(landscape);
        this.objShape.setLocalScale(2f);
        bulletAppState.getPhysicsSpace().add(landscape);
        this.app.getRootNode().attachChild(objShape);
       
       
    }

    public void collision(PhysicsCollisionEvent event) {
        try{ 
           
            if(event.getNodeA().getName().equals("Personaje") &&  event.getNodeB().getName().equals("ObjetoVida"+this.contador)){
                isCollision = true;
                this.app.getRootNode().detachChildNamed("ObjetoVida"+this.contador);
                this.bulletAppState.getPhysicsSpace().remove(landscape);
            }else if(event.getNodeA().getName().equals("ObjetoVida"+this.contador) &&  event.getNodeB().getName().equals("Personaje")){
                isCollision = true;
                this.app.getRootNode().detachChildNamed("ObjetoVida"+this.contador);
                this.bulletAppState.getPhysicsSpace().remove(landscape);
                
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
       
    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getVida() {
        return vida;
    }   
}
