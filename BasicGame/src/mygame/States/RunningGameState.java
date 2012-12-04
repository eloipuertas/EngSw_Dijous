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
import com.jme3.asset.plugins.ZipLocator;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.collision.shapes.CollisionShape;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.bullet.util.CollisionShapeFactory;
import com.jme3.collision.CollisionResults;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.light.AmbientLight;
import com.jme3.light.DirectionalLight;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import mygame.Controller;
import mygame.States.Scenario.DamageCollision;
import mygame.States.Scenario.GUIPlayerMain;
import mygame.States.Scenario.ObjectsInGame;
import mygame.States.Scenario.Scenario;
import mygame.States.Scenario.ScenarioInterface;
import mygame.States.Scenario.ScenarioManager;
import mygame.model.character.CharacterMainInterface;
import mygame.model.character.CharacterMainJMonkey;
import mygame.model.zombie.ZombieManager;
import mygame.model.zombie.ZombieManagerInterface;

/**
 *
 * @author David C.
 */
public class RunningGameState extends AbstractAppState implements RunningGameStateInterface{

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
    private ZombieManagerInterface zombieManager;
    private CharacterMainInterface playerManager;
    private ScenarioInterface scenarioManager;
    private ObjectsInGame objetos;
    private DamageCollision damageCollision;
    private int contadorPause = 2;
    private int difficulty; // Facil: 1 ;Medio: 2; Dificil: 3;
    
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
      
        //Scenario
        scenarioManager = new ScenarioManager(this.app);
        ((Controller)app).setScenarioManager(scenarioManager);
             
        //Player
        playerManager = new CharacterMainJMonkey(stateManager, app);
        ((Controller)app).setPlayerManager(playerManager);
        
        //stateManager.attach(player);
        //playerManager.setState(bulletAppState);
        //playerManager.initialize(stateManager, app);
        
        //Zombies
        zombieManager = new ZombieManager(app);
        ((Controller)app).setZombieManager(zombieManager);

        // @David C. -- La iluminación la cargamos en el ScenarioManager
        //setUpLight();
        // @David C. -- Eliminado el keylistener de la clase RunningGameState
        // setUpKeys();
        // @David C. -- El mapa se carga dentro del ScenarioManager en vez de aquí
        // loadMap();
 
    }
    public int getDifficulty() {
        return this.difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

/*
    public void setUpKeys() {
        app.getInputManager().addMapping("Paused", new KeyTrigger(KeyInput.KEY_P));
        app.getInputManager().addListener(this, "Paused");
    }
    
    public void onAction(String name, boolean isPressed, float tpf) {
        if (name.equals("Paused")&& isPressed){               //@Emilio nuevo, para pausar
            isRunningGame = !isRunningGame;   
        }
    }
    */
    public boolean getIsRunningGame() {
        return this.isRunningGame;
    }

    public void setIsRunningGame(boolean IsRunning) {
        this.isRunningGame = IsRunning;
        if (zombieManager != null){
            zombieManager.setPaused(IsRunning);
            }
    }

    public void updateRunningGame() {
        
        
        if (playerManager != null) {
            playerManager.personatgeUpdate();
            
            // @David C -- Update del ScenarioManager
            if (scenarioManager != null){
                scenarioManager.update();
            }
            
            if (zombieManager != null){
                zombieManager.update();
            }
        }

    
/*
=======
	
    public boolean getIsRunningGame() {
        return this.isRunningGame;
    }
	
    public void setIsRunningGame(boolean IsRunning) {
        this.isRunningGame = IsRunning;
    }
	
    // @Emilio añadido update de objetos.
    public void updateRunningGame() {
        if (isRunningGame) {
            if (playerManager != null) {
                playerManager.personatgeUpdate();
                
                if (zombieManager != null) {
                    //zombieManager.update(playerManager.getPlayerPosition());
                }
                
                //update objetos
                if (objetos != null){
                    objetos.update(guiPlayer, playerManager);
                }
                
                if (zombieManager != null ){
					
                }
            }
			
        }
		
>>>>>>> origin/TEAM-G_2
/**/
    }


}
