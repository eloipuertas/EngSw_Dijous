/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.asset.plugins.ZipLocator;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.collision.shapes.CapsuleCollisionShape;
import com.jme3.bullet.collision.shapes.CollisionShape;
import com.jme3.bullet.control.CharacterControl;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.bullet.util.CollisionShapeFactory;
import com.jme3.light.AmbientLight;
import com.jme3.light.DirectionalLight;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Mesh;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;
import java.util.ArrayList;
/**
 *
 * @author user
 */
public class Zombie extends SimpleApplication {
    private BulletAppState bulletAppState;
    private Spatial sceneModel;
    private RigidBodyControl landscape;
    private ArrayList zombies=new ArrayList();
    private Geometry g2;
    private RigidBodyControl c2;
    public static void main(String[] args){
        Zombie app = new Zombie();
        app.start();
    }


  public void simpleInitApp() {
    /** Set up Physics */
    cam.setLocation(new Vector3f(0, 4f, 0f));
    bulletAppState = new BulletAppState();
    stateManager.attach(bulletAppState);
    //bulletAppState.getPhysicsSpace().enableDebug(assetManager);
 
    // We re-use the flyby camera for rotation, while positioning is handled by physics
    viewPort.setBackgroundColor(new ColorRGBA(0.7f, 0.8f, 1f, 1f));
    flyCam.setMoveSpeed(100);
    setUpLight();
    crearZombies();
    // We load the scene from the zip file and adjust its size.
    assetManager.registerLocator("town.zip", ZipLocator.class);
    sceneModel = assetManager.loadModel("main.scene");
    sceneModel.setLocalScale(2f);
 
    // We set up collision detection for the scene by creating a
    // compound collision shape and a static RigidBodyControl with mass zero.
    CollisionShape sceneShape =
            CollisionShapeFactory.createMeshShape((Node) sceneModel);
    landscape = new RigidBodyControl(sceneShape, 0);
    sceneModel.addControl(landscape);
 
    // We set up collision detection for the player by creating
    // a capsule collision shape and a CharacterControl.
    // The CharacterControl offers extra settings for
    // size, stepheight, jumping, falling, and gravity.
    // We also put the player in its starting position.
 
    // We attach the scene and the player to the rootNode and the physics space,
    // to make them appear in the game world.
    rootNode.attachChild(sceneModel);
    bulletAppState.getPhysicsSpace().add(landscape);
  }
 
  private void crearZombies(){
        Box b = new Box(Vector3f.ZERO, 1, 1, 1);
        Geometry g1 = new Geometry("blue cube", b);
        Material mat = new Material(assetManager,
          "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setTexture("ColorMap", 
            assetManager.loadTexture("Textures/Terrain/BrickWall/BrickWall.jpg"));
        
        g1.setMaterial(mat);
        g1.setUserData("Salut", 100);
        g1.setUserData("Velocitat", 1f);
        g1.setUserData("Dany", 10);
        g1.setUserData("Energia", 100);
        g1.setLocalTranslation(0f,10f,-10f);
        RigidBodyControl cos = new RigidBodyControl(1f);
        g1.addControl(cos);
        bulletAppState.getPhysicsSpace().add(cos);
        zombies.add(g1);
        g2=g1;
        c2=cos;
        rootNode.attachChild(g1);
  }
  
  
  private void setUpLight() {
    // We add light so we see the scene
    AmbientLight al = new AmbientLight();
    al.setColor(ColorRGBA.White.mult(1.3f));
    rootNode.addLight(al);
 
    DirectionalLight dl = new DirectionalLight();
    dl.setColor(ColorRGBA.White);
    dl.setDirection(new Vector3f(2.8f, -2.8f, -2.8f).normalizeLocal());
    rootNode.addLight(dl);
  }
  
  public void simpleUpdate(float tpf) {
        // make the player rotate
    Vector3f v1= new Vector3f(10f,0f,0f);
    c2.applyCentralForce(v1);
    }
}
