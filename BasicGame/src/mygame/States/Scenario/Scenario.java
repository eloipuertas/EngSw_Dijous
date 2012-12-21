
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.States.Scenario;

import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.asset.AssetManager;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.collision.shapes.CollisionShape;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.bullet.util.CollisionShapeFactory;
import com.jme3.light.AmbientLight;
import com.jme3.light.DirectionalLight;
import com.jme3.light.PointLight;
import com.jme3.light.SpotLight;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Vector3f;
import com.jme3.post.FilterPostProcessor;
import com.jme3.post.ssao.SSAOFilter;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

/**
 *
 * @author Harpo
 */
public class Scenario {

    private final Node rootNode;
    private final ViewPort viewPort;
    private final AssetManager assetManager;
    private final ColorRGBA backgroundColor = ColorRGBA.Black;
    private Spatial sceneModel;
    private RigidBodyControl landscape;
    private SimpleApplication app;
    private SpotLight spot;
  
    
    public Scenario(SimpleApplication app) {
        this.rootNode = app.getRootNode();
        this.viewPort = app.getViewPort();
        this.assetManager = app.getAssetManager();
        this.app = app;
        //Ponemos el fondo en color azul
        viewPort.setBackgroundColor(backgroundColor);

        //Cargamos el escenario
        sceneModel = assetManager.loadModel("Scenes/montextura.j3o");
        sceneModel.setLocalScale(2f);
        
        // We set up collision detection for the scene by creating a
        // compound collision shape and a static RigidBodyControl with mass zero.
        
        CollisionShape sceneShape =
                CollisionShapeFactory.createMeshShape((Node) sceneModel);
     
        landscape = new RigidBodyControl(sceneShape, 0);
        sceneModel.addControl(landscape);
        sceneModel.setName("Escenario");  
        //rootNode.attachChild(sceneModel);
        this.app.getStateManager().getState(BulletAppState.class).getPhysicsSpace().add(landscape);
        //Cargaremos solo lo que este a cierta distancia del pj
        this.app.getCamera().setFrustumPerspective( 45.0f, (float) 800/ (float) 600, 0.1f,250 );
        setUpLight();
    }
    
    public void setDirectionSpotLight(){
        spot.setPosition(this.app.getCamera().getLocation());               // shine from camera loc
        spot.setDirection(this.app.getCamera().getDirection());
         
    }
    public Spatial getEscenari(){
        return this.sceneModel;
    }
    
    private void setUpLight() {
        spot = new SpotLight();
       
        spot.setSpotRange(100f);
        spot.setSpotInnerAngle(15f * FastMath.DEG_TO_RAD);
        spot.setSpotOuterAngle(35f * FastMath.DEG_TO_RAD);
        spot.setColor(ColorRGBA.White.mult(2.1f));
        spot.setPosition(this.app.getCamera().getLocation());
        //spot.setDirection(this.app.getCamera().getDirection());
        this.rootNode.addLight(spot);
       
        this.rootNode.setShadowMode(this.rootNode.getShadowMode().CastAndReceive);
        
        DirectionalLight dl = new DirectionalLight();
        dl.setColor(ColorRGBA.White.mult(0.3f));
        dl.setDirection(new Vector3f(0.1f, -0.1f, -0.1f).normalizeLocal());
     
        rootNode.addLight(dl);
        
        DirectionalLight dl2 = new DirectionalLight();
        dl2.setColor(ColorRGBA.White.mult(0.2f));
        dl2.setDirection(new Vector3f(0.1f, 0.1f, -0.1f).normalizeLocal());
        rootNode.addLight(dl2);
        
        
        DirectionalLight dl3 = new DirectionalLight();
        dl3.setColor(ColorRGBA.White.mult(0.2f));
        dl3.setDirection(new Vector3f(-0.1f,0.1f, 0.1f).normalizeLocal());
        rootNode.addLight(dl3);
        
        DirectionalLight dl4 = new DirectionalLight();
        dl4.setColor(ColorRGBA.White.mult(0.2f));
        dl4.setDirection(new Vector3f(-0.1f, 0.1f, -0.1f).normalizeLocal());
        rootNode.addLight(dl4);
        
        DirectionalLight dl5 = new DirectionalLight();
        dl5.setColor(ColorRGBA.White.mult(0.2f));
        dl5.setDirection(new Vector3f(0.1f, 0.1f, 0.1f).normalizeLocal());
        rootNode.addLight(dl5);   
        
    }
}
