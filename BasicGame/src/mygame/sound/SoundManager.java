/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.sound;

import com.jme3.app.SimpleApplication;
import com.jme3.asset.AssetManager;
import com.jme3.audio.AudioNode;
import com.jme3.scene.Node;


/**
 *
 * @author Isa
 */
public class SoundManager {

    public static void initAudio(SimpleApplication app){
        AssetManager assetManager = app.getAssetManager();
        Node rootNode = app.getRootNode();

        // Initialize footsteps
        AudioNode footSteps = new AudioNode(assetManager,
"Sounds/Effects/footsteps.wav",false);
        footSteps.setLooping(true);
        footSteps.setVolume(0.5f);
        footSteps.setName("footSteps");
        rootNode.attachChild(footSteps);

        // Initialize zombies sound
        AudioNode zombieSound = new AudioNode(assetManager,
"Sounds/Effects/Zombies1.wav", false);
        zombieSound.setLooping(true);
        zombieSound.setName("zombieSound");
        rootNode.attachChild(zombieSound);

        // Initiliaze click sound
        AudioNode click = new AudioNode(assetManager,
"Sounds/Effects/button-click.wav",false);
        click.setLooping(true);
        click.setName("click");
        rootNode.attachChild(click);

        // Initialize gothic tune
        AudioNode gothicTune = new AudioNode(assetManager,
"Sounds/Songs/Dark_music_Vampirical.ogg",false);
        gothicTune.setLooping(true);
        gothicTune.setVolume(0.3f);
        gothicTune.setName("gothicTune");
        rootNode.attachChild(gothicTune);
    }

    /* Play the footsteps */
    public static void footStepsPlay(Node rootNode){
        AudioNode footSteps = (AudioNode) rootNode.getChild("footSteps");
        footSteps.play();
    }

    /* Pause the footsteps */
    public static void footStepsPause(Node rootNode){
        AudioNode footSteps = (AudioNode) rootNode.getChild("footSteps");
        footSteps.pause();
    }

    /* Play the ghotic tune (Menu Principal)  */
    public static void gothicTunePlay(Node rootNode){
        AudioNode gothicTune = (AudioNode) rootNode.getChild("gothicTune");
        gothicTune.play();
    }

    /* Pause the ghotic tune (Menu Principal)  */
    public static void gothicTunePause(Node rootNode){
        AudioNode gothicTune = (AudioNode) rootNode.getChild("gothicTune");
        gothicTune.pause();
    }

    /* Play the zombie sounds  */
    public static void zombieSoundPlay(Node rootNode){
        AudioNode zombieSound = (AudioNode) rootNode.getChild("zombieSound");
        zombieSound.play();
    }

    /* Pause the zombie sounds  */
    public static void zombieSoundPause(Node rootNode){
        AudioNode zombieSound = (AudioNode) rootNode.getChild("zombieSound");
        zombieSound.pause();
    }
    
    /* Set volume to the zombie sounds  */
    public static void zombieSoundSetVolume(Node rootNode, float f){
        AudioNode zombieSound = (AudioNode) rootNode.getChild("zombieSound");
        zombieSound.setVolume(f);
    }

    /* Play Click  */
    public static void clickPlayInstance(Node rootNode){
        AudioNode click = (AudioNode) rootNode.getChild("click");
        click.playInstance();
    }

    /* Mute all sounds, set Volume to 0  */
    public static void muteAllSounds(Node rootNode){
        AudioNode click = (AudioNode) rootNode.getChild("click");
        click.setVolume(0);

        AudioNode zombieSound = (AudioNode) rootNode.getChild("zombieSound");
        zombieSound.setVolume(0);

        AudioNode gothicTune = (AudioNode) rootNode.getChild("gothicTune");
        gothicTune.setVolume(0);

        AudioNode footSteps = (AudioNode) rootNode.getChild("footSteps");
        footSteps.setVolume(0);
        
       
    }

    /* Unmute all sounds, set at the initial volume */
    public static void unMuteAllSounds(Node rootNode){
        AudioNode click = (AudioNode) rootNode.getChild("click");
        click.setVolume(1);

        AudioNode zombieSound = (AudioNode) rootNode.getChild("zombieSound");
        zombieSound.setVolume(1);

        AudioNode gothicTune = (AudioNode) rootNode.getChild("gothicTune");
        gothicTune.setVolume(0.3f);

        AudioNode footSteps = (AudioNode) rootNode.getChild("footSteps");
        footSteps.setVolume(0.5f);
    }


}