/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.States.Scenario;

import de.lessvoid.nifty.elements.Element;
import de.lessvoid.nifty.elements.render.TextRenderer;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;

/**
 *
 * @author Harpo
 */
public class GUIPlayer{
    
    private int vidas;
    private int municion;
    private int salud;
    private Element elementoNifty;
    private ScreenController screenController;
    private Screen screen;
    
    public GUIPlayer(Screen screen1){
          
        this.screen = screen1;
               
        this.setVidasGUI(3);
        this.setMunicionGUI(1220);
        this.setSaludGUI(100);
     
    }

    
     public void setVidasGUI(int vida){
       
       this.elementoNifty = this.screen.findElementByName("vidas");
       this.elementoNifty.getRenderer(TextRenderer.class).setText("Vidas : "+vida); 
       this.vidas = vida;
    }
 
    public int getVidasGUI(){
        return this.salud;
    }
    
    public void setSaludGUI(int saludNueva){
       
       this.elementoNifty = this.screen.findElementByName("salud");
       this.elementoNifty.getRenderer(TextRenderer.class).setText("Salud : "+saludNueva+"%"); 
       this.salud = saludNueva;
    }
 
    public int getSaludGUI(){
        return this.salud;
    }
    
    public void setMunicionGUI(int municionNueva){
      
      this.elementoNifty = this.screen.findElementByName("municion");
       this.elementoNifty.getRenderer(TextRenderer.class).setText("Munición : "+municionNueva+" balas"); 
       this.municion = municionNueva;
    }
    
    public int getMunicionGUI(){
        return municion;
    }

}
