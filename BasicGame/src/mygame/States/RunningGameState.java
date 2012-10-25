/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.States;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.asset.AssetManager;
import com.jme3.bullet.collision.shapes.CompoundCollisionShape;
import com.jme3.bullet.util.CollisionShapeFactory;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import mygame.Main;
import mygame.States.Scenario.GUIPlayer;
import mygame.States.Scenario.Scenario;
import mygame.model.character.CharacterMainJMonkey;

/**
 *
 * @author Harpo
 */
public class RunningGameState extends AbstractAppState{
    private SimpleApplication app;  
    private ViewPort viewPort;
    private AssetManager assetManager;
    private Node rootNode;
    private Node guiNode;
    private Scenario scenario;
    private boolean isRunningGame;
    private GUIPlayer guiPlayer;
    CharacterMainJMonkey player;
    private BulletAppState bulletAppState;
    private RigidBodyControl landscape;
    private CharacterControl playercontrol;
    private Spatial sceneModel;
    
    public static void main(String[] args) {
        Main app = new Main();
        app.start();
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
    
    public void loadMapa(){
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
    
    rootNode.attachChild(sceneModel);
    bulletAppState.getPhysicsSpace().add(landscape);
 
    
    
    }
    
    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
    
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app); 
        this.app = (SimpleApplication)app;
        
        player = new CharacterMainJMonkey();
        stateManager.attach(player);
        
        bulletAppState = new BulletAppState();
        stateManager.attach(bulletAppState);
        player.setState(bulletAppState);
        
        player.initialize(stateManager, this);
               
        setUpLight();
        loadMapa();
        viewPort.setBackgroundColor(new ColorRGBA(0.7f, 0.8f, 1f, 1f));
        flyCam.setMoveSpeed(100);
    }
    
    public boolean getIsRunningGame(){
        return this.isRunningGame;
    }
    
    public void setIsRunningGame(boolean IsRunning){
        this.isRunningGame = IsRunning;
    }
    
    public void updateRunningGame(){
        if(isRunningGame){
            player.personatgeUpdate();
        }
    
    }
}

