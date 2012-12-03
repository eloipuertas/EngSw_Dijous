/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.States.Scenario;

import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.asset.AssetManager;
import com.jme3.niftygui.NiftyJmeDisplay;
import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.elements.Element;
import de.lessvoid.nifty.elements.render.TextRenderer;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;

/**
 *
 * @author Harpo
 */
public class GUIPlayerMain extends AbstractAppState implements ScreenController {

    private AssetManager assetManager;

    private Nifty nifty;
    private int vida = 100;
    private int municion = 100;
    private Screen screen;
    private Element niftyElement;
    private GUIPlayer guiPlayer;
    
    public GUIPlayerMain(SimpleApplication app) {
 
        this.assetManager  = app.getAssetManager(); 
   
        
        //GUI Menu
        NiftyJmeDisplay niftyDisplay = new NiftyJmeDisplay(assetManager,
                                                      app.getInputManager(),
                                                      app.getAudioRenderer(),
                                                      app.getGuiViewPort());
        nifty = niftyDisplay.getNifty();
        
        
        nifty.fromXml("Interface/RunningGame/GUIrunningGame.xml", "start", this);
        app.getGuiViewPort().addProcessor(niftyDisplay);
        
        this.screen.startScreen();
        guiPlayer = new GUIPlayer( this.screen); 
  
        
    }
    


    public void bind(Nifty nifty, Screen screen) {
        this.nifty = nifty;
        this.screen = screen;
      
       
        
    }

    public void onStartScreen() {
        
    }

    public void onEndScreen() {
     
    }

    public void updateGUI() {
    
    }
    
    //@Emilio nuevo
    public void setSaludGUI(int vida){
        guiPlayer.setSaludGUI(vida);
    }
    public int getSaludGUI(){
        return guiPlayer.getSaludGUI();
    }
}
