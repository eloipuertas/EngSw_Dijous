/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.States.Scenario;

import de.lessvoid.nifty.screen.Screen;

/**
 *
 * @author Harpo
 */
public interface InterfaceGUIPlayer {
    
      void setVidasGUI(int vida);
      int getVidasGUI();
      void setMunicionGUI(int municionNueva);
      int getMunicionGUI();
      void setSaludGUI(int saludNueva);
      int getSaludGUI();
    
    
}
