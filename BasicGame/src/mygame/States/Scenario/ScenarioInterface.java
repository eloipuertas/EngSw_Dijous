/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.States.Scenario;

/**
 *
 * @author Harpo
 */
public interface ScenarioInterface {

    public void update();
    public GUIPlayerMain getGuiPlayer();
    public void setGuiPlayer(GUIPlayerMain guiPlayer);
    public ObjectsInGame getObjetos();
    public void setObjetos(ObjectsInGame objetos);
    public Scenario getScenario();
    public void setScenario(Scenario scenario);
    
}
