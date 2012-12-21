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
import com.jme3.input.KeyInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.math.ColorRGBA;
import com.jme3.niftygui.NiftyJmeDisplay;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Node;
import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;
import mygame.Controller;
import mygame.sound.SoundManager;

/**
 *
 * @author Harpo
 */
public class MenuPrincipalState extends AbstractAppState implements ScreenController,
        ActionListener, MenuPrincipalStateInterface
{
   
    private SimpleApplication app;  
    private ViewPort viewPort;
    private AssetManager assetManager;
    private Node rootNode;
    private Node guiNode;
    private final ColorRGBA backgroundColor = ColorRGBA.Black;
    private Nifty nifty;
    private Screen screen;
    private boolean isRunningMenuPrincipal = true;
    private boolean enPantalla = false;
    private boolean icono = false;
    private int difficulty = 2;

    public int getDificulty() {
        return difficulty;
    }

    public void setDificulty(int dificulty) {
        this.difficulty = dificulty;
    }

    
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
        
        setUpKeys();
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
        
        SoundManager.gothicTunePlay(rootNode); // Play Ghotic Tune
        
        // STEFAN!! tengo error de java memory
        //initAudio();
        //--
     

       
   } 
    
    // @Emilio nuevo.
    public void setUpKeys() {
        app.getInputManager().addMapping("pausa", new KeyTrigger(KeyInput.KEY_P));
        app.getInputManager().addMapping("mute", new KeyTrigger(KeyInput.KEY_M));
        app.getInputManager().addListener(this, "pausa");
        app.getInputManager().addListener(this, "mute");
    }
    
    /*
     * @Emilio cambiar funcion usando el booleanos isPressed en vez de ifs
     * guarreras.
     */
    public void onAction(String name, boolean isPressed, float tpf) {
        if (name.equals("pausa")){
            if(!enPantalla && isPressed){
                    enPantalla = true;
                    pause();
            }else{
                if(isPressed){
                    enPantalla = false;
                    newGame();
                }
            }
        } 
        if (name.equals("mute")){
           if(!icono && isPressed){
                    icono = true;
                    mute();
            }else{
                if(isPressed){
                    icono = false;
                    nifty.gotoScreen("end");
                }
            } 
        }
    }
     public void showOptionsMenu(){
        
        // STEFAN!! tengo error de java memory
       //audio_theme.pause(); // Pausa la cancion para entrar en el juego
       //audio_click.playInstance();// Suena el click
        //--
        
     
       SoundManager.clickPlayInstance(rootNode); // Play click
       nifty.gotoScreen("menuOpciones");
       
       //this.setIsRunningMenuPrincipal(false);
    }
    
     
    public void menuGameOver(){
        nifty.gotoScreen("muerto");
    }
    
    public void menuWin(){
        nifty.gotoScreen("win");
    }
    public void opcionNivelFacil(){
       //SoundManager.clickPlayInstance(rootNode); // Play click
       nifty.gotoScreen("start");
       this.difficulty = 1;
       
    }
    public void opcionNivelMedio(){
       SoundManager.clickPlayInstance(rootNode); // Play click
       nifty.gotoScreen("start");
       this.difficulty = 2;
    }
    public void opcionNivelDificil(){
       SoundManager.clickPlayInstance(rootNode); // Play click
       nifty.gotoScreen("start");
       this.difficulty = 3;
    }
     
    public void quitMenuOpciones(){
      
       SoundManager.clickPlayInstance(rootNode); // Play click
       nifty.gotoScreen("start");
    }
    
    
    public void newGame(){
        
        // STEFAN!! tengo error de java memory
       //audio_theme.pause(); // Pausa la cancion para entrar en el juego
       //audio_click.playInstance();// Suena el click
        //--
        
       SoundManager.gothicTunePause(rootNode); // Pause Ghotic Tune
       SoundManager.clickPlayInstance(rootNode); // Play click
       nifty.gotoScreen("end");
       this.app.getInputManager().setCursorVisible(false);
       this.setIsRunningMenuPrincipal(false);
       ((Controller)app).getRunningGameState().setDifficulty(difficulty);
       
    }
    
    /* @Emilio muestra menú pausa, pero no pausa el juego solo el movimiento
    / del personaje
    */
    public void pause(){
        nifty.gotoScreen("pausa");
        //this.app.getInputManager().setCursorVisible(true);
        this.setIsRunningMenuPrincipal(false);
    }
    
    public void mute(){
        nifty.gotoScreen("mute");
    }
    
    public void quitMenu() throws InterruptedException{
        SoundManager.gothicTunePause(rootNode); // Pause Ghotic Tune
        SoundManager.clickPlayInstance(rootNode); // Play click
        System.out.println(" -- Aplicación cerrada.");
        Thread.currentThread().sleep(1000); // Sleep de un segundo que da tiempo al sonido para que se reproduzca
        this.app.stop();
    }
    
    // @Emilio de momento esto no es necesario
    /*public void ayuda(){
        nifty.gotoScreen("ayuda");
        this.app.getInputManager().setCursorVisible(false);
        this.setIsRunningMenuPrincipal(false);
    }*/

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
