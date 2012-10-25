package mygame;

import com.jme3.app.SimpleApplication;
import mygame.States.MenuPrincipalState;
import mygame.States.RunningGameState;


public class Main extends SimpleApplication {
   
    private MenuPrincipalState menuPrincipal;
    private RunningGameState runningGame;
    private boolean isRunning;
    
    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    @Override
    public void simpleInitApp() {
    
        //Menu Principal
        menuPrincipal  = new MenuPrincipalState(this);
        
        //Juego
        runningGame  = new RunningGameState(this);
        
        //Mostramos el Menu Principal
        stateManager.attach(menuPrincipal);
  
    }
 
  @Override
  public void simpleUpdate(float tpf) {

      //Menu Principal
      if (menuPrincipal.getIsRunningMenuPrincipal() && !stateManager.hasState(menuPrincipal)){
          stateManager.detach(runningGame);
          stateManager.attach(menuPrincipal);
          
      }else if(!menuPrincipal.getIsRunningMenuPrincipal() && stateManager.hasState(menuPrincipal)){
          stateManager.detach(menuPrincipal);
          stateManager.attach(runningGame);
          runningGame.setIsRunningGame(true);
          isRunning=true;
      }
      
      //Running Game
      if (runningGame.getIsRunningGame() && !stateManager.hasState(runningGame)){
          stateManager.detach(menuPrincipal);
          stateManager.attach(runningGame);
        
      }else if(!runningGame.getIsRunningGame()  && stateManager.hasState(runningGame)){
          stateManager.detach(runningGame);
          stateManager.attach(menuPrincipal);
          menuPrincipal.setIsRunningMenuPrincipal(true);
      }
      
      runningGame.updateRunningGame();
      
     
    
  }
    
}