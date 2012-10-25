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
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.niftygui.NiftyJmeDisplay;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;

/**
 *
 * @author Harpo
 */
public class MenuPrincipalState extends AbstractAppState implements ScreenController{
   
    private SimpleApplication app;  
    private ViewPort viewPort;
    private AssetManager assetManager;
    private Node rootNode;
    private Node guiNode;
    private final ColorRGBA backgroundColor = ColorRGBA.Black;
    private Nifty nifty;
    private Screen screen;
    private boolean isRunningMenuPrincipal = true;
    
    public MenuPrincipalState(SimpleApplication app){
        this.rootNode     = app.getRootNode();
        this.viewPort      = app.getViewPort();
        this.guiNode       = app.getGuiNode();
        this.assetManager  = app.getAssetManager();  
    }
    
    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app); 
        this.app = (SimpleApplication)app;   
      
        //Fondo
        viewPort.setBackgroundColor(backgroundColor);
       
    
        //Menu
        NiftyJmeDisplay niftyDisplay = new NiftyJmeDisplay(assetManager,
                                                      this.app.getInputManager(),
                                                      this.app.getAudioRenderer(),
                                                      this.app.getGuiViewPort());
        nifty = niftyDisplay.getNifty();
        nifty.fromXml("Interface/MenuPrincipal/MPrincipal.xml", "start",this);

        // attach the nifty display to the gui view port as a processor
        app.getGuiViewPort().addProcessor(niftyDisplay);
        this.app.getInputManager().setCursorVisible(true);
        
        
        
        
      
        //Cargamos el escenario
        /*Spatial escenario = this.app.getAssetManager().loadModel("Scenes/montextura.j3o" );
        escenario.move(Vector3f.ZERO);
        this.app.getRootNode().attachChild(escenario);
*/

 
   } 
    
    public void newGame(){
       nifty.gotoScreen("end");
       this.app.getInputManager().setCursorVisible(false);
       this.setIsRunningMenuPrincipal(false);
     

    }
    
    public void quitMenu(){
        System.out.println(" -- Aplicación cerrada.");
        this.app.stop();

    }

    public void bind(Nifty nifty, Screen screen) {
        this.nifty = nifty;
        this.screen = screen;
    }

    public void onStartScreen() {
       
    }

    public void onEndScreen() {
       
    }
    
    public boolean getIsRunningMenuPrincipal(){
        
        return this.isRunningMenuPrincipal;
    }
    public void setIsRunningMenuPrincipal(boolean IsRunning){
        this.isRunningMenuPrincipal = IsRunning;
    }
}
