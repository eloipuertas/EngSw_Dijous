/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.States.Scenario;

import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.bullet.BulletAppState;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Harpo
 */
public class ObjectsInGame extends AbstractAppState  {

    private SimpleApplication app;
    private BulletAppState bulletAppState;


    List<ObjVida> ObjetosVida;
   
    
    
    public ObjectsInGame(SimpleApplication application){
        this.app =application;
        this.bulletAppState = this.app.getStateManager().getState(BulletAppState.class);
  
        
        //Guardamos los Objetos de vida que creemos en una lista
        ObjetosVida = new ArrayList<ObjVida>();
        ObjetosVida.add(new ObjVida(this.bulletAppState,this.app,1,10.0f,0f,10.0f));
        ObjetosVida.add(new ObjVida(this.bulletAppState,this.app,2,15.0f,0f,17.0f));
       
        
        
      
    
    }
    
   public void update(GUIPlayerMain gui){
       
       //comprobamos si alguno de los botiquines ha sido cogido
       for(Iterator iterador = ObjetosVida.listIterator();iterador.hasNext();){
           ObjVida objVidaActual = (ObjVida)iterador.next();
           if (objVidaActual.isCollision()){
                   gui.setSaludGUI(gui.getSaludGUI()+objVidaActual.getVida());
                   objVidaActual.setCollision(false);
                   iterador.remove();
           }
       }
     
    }
    


  
}
