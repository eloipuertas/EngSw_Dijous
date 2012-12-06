/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.States.Scenario;

import com.jme3.app.SimpleApplication;
import mygame.Controller;

/**
 *
 * @author Harpo
 */
public class ScenarioManager implements ScenarioInterface {
    private SimpleApplication app;
    private GUIPlayerMain guiPlayer;
    private ObjectsInGame objetos;
    private Scenario scenario;
    private ZombiesInGame zombies;

    public GUIPlayerMain getGuiPlayer() {
        return guiPlayer;
    }

    public void setGuiPlayer(GUIPlayerMain guiPlayer) {
        this.guiPlayer = guiPlayer;
    }

    public ObjectsInGame getObjetos() {
        return objetos;
    }

    public void setObjetos(ObjectsInGame objetos) {
        this.objetos = objetos;
    }
    
     public ZombiesInGame getZombies() {
        return zombies;
    }

    public void setZombies(ZombiesInGame zombies) {
        this.zombies = zombies;
    }

    public Scenario getScenario() {
        return scenario;
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }
    
    
    public ScenarioManager(SimpleApplication applicooter) {
        this.app = applicooter;
        
        //Cargamos la GUI
        this.guiPlayer = new GUIPlayerMain(this.app);
        //Cargamos los objetos
        this.objetos = new ObjectsInGame(this.app);
        //Cargamos el escenario
        this.scenario = new Scenario(this.app);
        //Cargamos los zombies especiales
        this.zombies = new ZombiesInGame(this.app);
      
    }
    public void update(){
        if (objetos != null){
                objetos.update(guiPlayer, ((Controller)app).getPlayerManager());
        }
    }
}
