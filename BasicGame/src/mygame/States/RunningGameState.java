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
import mygame.States.Scenario.GUIPlayer;
import mygame.States.Scenario.Scenario;

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
    
 
    public RunningGameState (SimpleApplication app){
        this.rootNode     = app.getRootNode();
        this.viewPort      = app.getViewPort();
        this.guiNode       = app.getGuiNode();
        this.assetManager  = app.getAssetManager();  
    }
    
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app); 
        this.app = (SimpleApplication)app;   
 
        //Cargamos el escenario
        scenario = new Scenario(this.app);
        
        //Cargamos la GUI
        guiPlayer = new GUIPlayer(this.app);
    }
    
    public boolean getIsRunningGame(){
        return this.isRunningGame;
    }
    
    public void setIsRunningGame(boolean IsRunning){
        this.isRunningGame = IsRunning;
    }
    
    public void updateRunningGame(){
        if(isRunningGame){
        
        }
    
    }
}
