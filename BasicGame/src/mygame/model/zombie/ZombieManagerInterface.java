/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.model.zombie;

import com.jme3.math.Vector3f;
import java.util.ArrayList;

public interface ZombieManagerInterface {

    /**
     * Stefan D. Grup F:
     * Called every tick to update zombies position/animations/actions
     */
    public void update();
    
    /**
     * Stefan D. Grup F:
     * To get all the zombies added to the map, for the colisions with players weapons
     * 
     * @return An array list with all the zombies (Zombie interface is a interface 
     * to the parent zombie, that extends to the classic, Petia, Oriol...
     */
    public ArrayList<ZombieInterface> getZombies();

    public void setPaused(boolean b);

    public void deleteZombie(Zombie aThis);
    
    public enum difficulty{
        low, middle, high
    }
    
    public void addZombieBasic(Vector3f position, Vector3f viewDirection, difficulty dif);
    public void addZombiePetia(Vector3f position, Vector3f viewDirection, difficulty dif);
    public void addZombieOriol(Vector3f position, Vector3f viewDirection, difficulty dif);
    public void addZombieManel(Vector3f position, Vector3f viewDirection, difficulty dif);
    
    public void pene();
    
}
