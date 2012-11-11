/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mygame.model.character;

/**
 *
 * @author rociotovar
 */
public class CharacterMain implements Character {
    
    // <editor-fold desc="Attributes">
    
    CharacterMainJMonkey jMonkeyModel;
    Position3D position;
    int nLives;
    double energy;
    Weapon[] weapons;
    Weapon currentWeapon;
    
    // </editor-fold>

    
    // <editor-fold desc="Constructors">
    
    CharacterMain () {
        this.jMonkeyModel = new CharacterMainJMonkey();
        
        // TODO: Initialize model...
        
        this.position = new Position3D();
        this.nLives = 3;
        this.energy = 100.0;
        this.weapons = new Weapon[3];
        //weapons[1] = new Folder();
        this.currentWeapon = weapons[1]; // default weapon
    }
    
    // </editor-fold>

    

    // <editor-fold desc="Getters and Setters">
    
    public Position3D getPosition() {
        return this.position;
    }

    public int getNLives() {
        return this.nLives;
    }

    public double getEnergy() {
        return this.energy;
    }
    
    
    public Weapon getCurrentWeapon () {
        return this.currentWeapon;
    }
    
    public void setPosition(double x, double y, double z) {
        this.position.setPosition(x, y, z);
    }
    
    public void setCurrentWeapon(int idWeapon) {
        this.currentWeapon = this.weapons[idWeapon];
    }
    
    // </editor-fold>

    public void incrementEnergy(double quantity) {
        this.energy += quantity;
    }

    public void incrementNLives(int quantity) {
        this.nLives += quantity;
    }
    
    
}
