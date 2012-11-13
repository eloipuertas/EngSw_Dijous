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
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.collision.shapes.CollisionShape;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.bullet.util.CollisionShapeFactory;
import com.jme3.collision.CollisionResults;
import com.jme3.light.AmbientLight;
import com.jme3.light.DirectionalLight;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import mygame.States.Scenario.DamageCollision;
import mygame.States.Scenario.GUIPlayerMain;
import mygame.States.Scenario.ObjectsInGame;
import mygame.States.Scenario.Scenario;
import mygame.model.character.CharacterMainJMonkey;
import mygame.model.zombie.ZombieManager;

/**
 *
 * @author Harpo
 */
public class RunningGameState extends AbstractAppState {
	
    private SimpleApplication app;
    private ViewPort viewPort;
    private AssetManager assetManager;
    private Node rootNode;
    private Node guiNode;
    private Scenario scenario;
    private boolean isRunningGame;
    private GUIPlayerMain guiPlayer;
    private Spatial sceneModel;
    private RigidBodyControl landscape;
    private BulletAppState bulletAppState;
    private ZombieManager zombieManager;
    CharacterMainJMonkey player;
    private ObjectsInGame objetos;
    private DamageCollision damageCollision;
	
    public RunningGameState(SimpleApplication app)  {
        this.rootNode = app.getRootNode();
        this.viewPort = app.getViewPort();
        this.guiNode = app.getGuiNode();
        this.assetManager = app.getAssetManager();
    }
	
    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
        this.app = (SimpleApplication) app;
        bulletAppState = app.getStateManager().getState(BulletAppState.class);
        //Cargamos el escenario
        //scenario = new Scenario(this.app);
		
        //Cargamos la GUI
        guiPlayer = new GUIPlayerMain(this.app);
        //Cargamos los objetos
        objetos = new ObjectsInGame(this.app);
        //Cargamos el controlador de daño por colisiones
        damageCollision = new DamageCollision(this.bulletAppState,guiPlayer);
        
        //Player
        player = new CharacterMainJMonkey();
        //stateManager.attach(player);
        stateManager.attach(bulletAppState);
        player.setState(bulletAppState);
        player.initialize(stateManager, app);
        
        //Zombies
        zombieManager = new ZombieManager(app, 3);
		
        setUpLight();
        loadMap();
		
    }
	
    public void loadMap() {
        sceneModel = assetManager.loadModel("Scenes/montextura.j3o");
        sceneModel.setLocalScale(2f);
		
        // We set up collision detection for the scene by creating a
        // compound collision shape and a static RigidBodyControl with mass zero.
        
        CollisionShape sceneShape =
		CollisionShapeFactory.createMeshShape((Node) sceneModel);
        landscape = new RigidBodyControl(sceneShape, 0);
        sceneModel.addControl(landscape);
        sceneModel.setName("Escenario");  
        rootNode.attachChild(sceneModel);
        bulletAppState.getPhysicsSpace().add(landscape);
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
	
    public boolean getIsRunningGame() {
        return this.isRunningGame;
    }
	
    public void setIsRunningGame(boolean IsRunning) {
        this.isRunningGame = IsRunning;
    }
	
    // @Emilio añadido update de objetos.
    public void updateRunningGame() {
        if (isRunningGame) {
            if (player != null) {
                player.personatgeUpdate();
                if (zombieManager != null) {
                    zombieManager.update(player.getPlayerPosition());
                }
                //update objetos
                if (objetos != null){
                    objetos.update(guiPlayer);
                }
                if (zombieManager != null ){
					
                }
            }
			
        }
		
    }
}
