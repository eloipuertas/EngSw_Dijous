package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.bullet.BulletAppState;
<<<<<<< HEAD
import com.jme3.util.BufferUtils;
=======
>>>>>>> TEAM-G
import mygame.States.MenuPrincipalState;
import mygame.States.RunningGameState;
import mygame.States.Scenario.ScenarioInterface;
import mygame.model.zombie.ZombieManagerInterface;
import mygame.model.character.CharacterMainInterface;
<<<<<<< HEAD
import mygame.sound.SoundManager;
=======
>>>>>>> TEAM-G


public class Controller extends SimpleApplication {
   
    private MenuPrincipalState menuPrincipal;
    private RunningGameState runningGame;
    
    // Stefan D: For pause
    private boolean isRunning;
    
    // Stefan D.: Interfaces for comunication between map, player and zombies
    private ZombieManagerInterface zombieManager;
    private CharacterMainInterface playerManager;
    private ScenarioInterface scenarioManager;

    public ScenarioInterface getScenarioManager() {
        return scenarioManager;
    }
    
    public void setScenarioManager(ScenarioInterface scenarioManager) {
        this.scenarioManager = scenarioManager;
    }
            
    public ZombieManagerInterface getZombieManager() {
        return zombieManager;
    }

    public void setZombieManager(ZombieManagerInterface zombieManager) {
        this.zombieManager = zombieManager;
    }
        
    public CharacterMainInterface getPlayerManager() {
        return playerManager;
    }

    public void setPlayerManager(CharacterMainInterface playerManager) {
        this.playerManager = playerManager;
    }

    public boolean isIsRunning() {
        return isRunning;
    }

    public void setIsRunning(boolean isRunning) {
        this.isRunning = isRunning;
        runningGame.setIsRunningGame(isRunning);
    }
    //===========================================
    
    public static void main(String[] args) {
        Controller app = new Controller();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        stateManager.attach(new BulletAppState());
    
        //Menu Principal
        menuPrincipal  = new MenuPrincipalState(this);
        
        //Juego
        runningGame  = new RunningGameState(this);
        
        //Mostramos el Menu Principal
        stateManager.attach(menuPrincipal);
        
<<<<<<< HEAD
        //Inicializamos todos los sonidos
        SoundManager.initAudio(this);
        
          
=======
       
  
>>>>>>> TEAM-G
    }
    
  @Override
  public void simpleUpdate(float tpf) {

      //Menu Principal
  /*    if (menuPrincipal.getIsRunningMenuPrincipal() && !stateManager.hasState(menuPrincipal)){
          stateManager.detach(runningGame);
          stateManager.attach(menuPrincipal);
     
      }else   */  
      
      // @David C. -- Modificación de la condición
      if(!menuPrincipal.getIsRunningMenuPrincipal() && stateManager.hasState(menuPrincipal)){
          stateManager.detach(menuPrincipal);
          stateManager.attach(runningGame);
          runningGame.setIsRunningGame(true);
      }
      
      //Running Game
      if (runningGame.getIsRunningGame() && !stateManager.hasState(runningGame)){
          stateManager.detach(menuPrincipal);
          stateManager.attach(runningGame);
        
      }/*else if(!runningGame.getIsRunningGame()  && stateManager.hasState(runningGame)){
          stateManager.detach(runningGame);
          stateManager.attach(menuPrincipal);
          menuPrincipal.setIsRunningMenuPrincipal(true);
      }
      */
      
      runningGame.updateRunningGame();   
    
  }
        //rootNode.attachChild(audio_environment);
}