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
"Sounds/Songs/Dark_music_Vampirical.ogg",true);
        gothicTune.setVolume(0.3f);
        gothicTune.setName("gothicTune");
        rootNode.attachChild(gothicTune);
    
      // Initialize zombie footstep
        AudioNode zombieFootstep = new AudioNode(assetManager,
"Sounds/Effects/footStepZombie.wav",false);
        zombieFootstep.setLooping(true);
        zombieFootstep.setVolume(0.1f);
        zombieFootstep.setName("zombieFootstep");
        rootNode.attachChild(zombieFootstep);
        
        // Initiliaze zombie hurt
        AudioNode zombieHurt = new AudioNode(assetManager,
"Sounds/Effects/zombieHurt.wav",false);
        zombieHurt.setLooping(true);
        zombieHurt.setName("zombieHurt");
        zombieHurt.setVolume(0.2f);
        rootNode.attachChild(zombieHurt);
        
        // Initiliaze zombie hurt
        AudioNode zombieDie = new AudioNode(assetManager,
"Sounds/Effects/zombieDie.wav",false);
        zombieDie.setLooping(true);
        zombieDie.setName("zombieDie");
        zombieDie.setVolume(0.4f);
        rootNode.attachChild(zombieDie);
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
    public static void zombieSoundSetVolume(Node rootNode, float vol){
        AudioNode zombieSound = (AudioNode) rootNode.getChild("zombieSound");
        zombieSound.setVolume(vol);
    }

    /* Play Click  */
    public static void clickPlayInstance(Node rootNode){
        AudioNode click = (AudioNode) rootNode.getChild("click");
        click.playInstance();
    }
    
    
       /* Play the zombie footsteps */
    public static void zombieFootStepsPlay(Node rootNode){
        AudioNode zombieFootstep = (AudioNode) rootNode.getChild("zombieFootstep");
        zombieFootstep.play();
    }

    /* Pause the zombie  footsteps */
    public static void zombieFootStepsPause(Node rootNode){
        AudioNode zombieFootstep = (AudioNode) rootNode.getChild("zombieFootstep");
        zombieFootstep.pause();
    }
    
    /* Set volume to the zombie sounds  */
    public static void zombieFootStepsSetVolume(Node rootNode, float vol){
        AudioNode zombieFootstep = (AudioNode) rootNode.getChild("zombieFootstep");
        zombieFootstep.setVolume(vol);
    }
    
    /* Play zombie hurt  */
    public static void zombieHurtPlayInstance(Node rootNode){
        AudioNode zombieHurt = (AudioNode) rootNode.getChild("zombieHurt");
        zombieHurt.playInstance();
    }
    
    /* Play zombie die  */
    public static void zombieDiePlayInstance(Node rootNode){
        AudioNode zombieDie = (AudioNode) rootNode.getChild("zombieDie");
        zombieDie.playInstance();
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
        
        AudioNode zombieFootstep = (AudioNode) rootNode.getChild("zombieFootstep");
        zombieFootstep.setVolume(0);
        
        AudioNode zombieHurt = (AudioNode) rootNode.getChild("zombieHurt");
        zombieHurt.setVolume(0);
        
        AudioNode zombieDie = (AudioNode) rootNode.getChild("zombieDie");
        zombieDie.setVolume(0);
        
       
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
        
        AudioNode zombieFootstep = (AudioNode) rootNode.getChild("zombieFootstep");
        zombieFootstep.setVolume(0.1f);
        
        AudioNode zombieHurt = (AudioNode) rootNode.getChild("zombieHurt");
        zombieHurt.setVolume(0.2f);
        
        AudioNode zombieDie = (AudioNode) rootNode.getChild("zombieDie");
        zombieDie.setVolume(0.4f);
    }

}