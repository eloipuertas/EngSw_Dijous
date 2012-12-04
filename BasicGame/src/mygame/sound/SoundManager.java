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
        
        
        // Initialize zombieOriol sound
        AudioNode zombieSoundOriol = new AudioNode(assetManager,
                "Sounds/Effects/Zombies1.wav", false);
        zombieSoundOriol.setLooping(true);
        zombieSoundOriol.setName("zombieSoundOriol");
        rootNode.attachChild(zombieSoundOriol);  
        
        // Initialize zombieFootstepsOriol
        AudioNode zombieFootstepOriol = new AudioNode(assetManager,
                "Sounds/Effects/footStepZombie.wav",false);
        zombieFootstepOriol.setLooping(true);
        zombieFootstepOriol.setVolume(0.1f);
        zombieFootstepOriol.setName("zombieFootstepOriol");
        rootNode.attachChild(zombieFootstepOriol);  
        
        
   
    }
    
    
    /* Initialize basic zombies sound with id of the zombie */
    public static void initBasicZombieSound(SimpleApplication app, int id){
        AssetManager assetManager = app.getAssetManager();
        Node rootNode = app.getRootNode();
        
         // Initialize zombies sound
        AudioNode zombieSound = new AudioNode(assetManager,
                "Sounds/Effects/Zombies1.wav", false);
        zombieSound.setLooping(true);
        
         // Set name "zombieSound + id of the zombie"
        String idS = String.valueOf(id);
        zombieSound.setName("zombieSound"+idS);
        rootNode.attachChild(zombieSound);
    }
    
    /* Initialize basic zombies footsteps sound  with id of the zombie */
    public static void initFootStepBasicZombieSound(SimpleApplication app, int id){
        AssetManager assetManager = app.getAssetManager();
        Node rootNode = app.getRootNode();
        
            
      // Initialize zombie footstep
        AudioNode zombieFootstep = new AudioNode(assetManager,
                "Sounds/Effects/footStepZombie.wav",false);
        zombieFootstep.setLooping(true);
        zombieFootstep.setVolume(0.1f);
        
        // Set name "zombieFootstep + id of the zombie"
        String idS = String.valueOf(id);
        zombieFootstep.setName("zombieFootstep"+idS);
         
        rootNode.attachChild(zombieFootstep);
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

    /* Play the zombie sounds Oriol */
    public static void OriolZombieSoundPlay(Node rootNode){
        AudioNode zombieSoundOriol = (AudioNode) rootNode.getChild("zombieSoundOriol");
        zombieSoundOriol.play();
    }
    
   /* Play the zombie sounds Petia */
    public static void PetiaZombieSoundPlay(Node rootNode){
        AudioNode zombieSoundPetia = (AudioNode) rootNode.getChild("zombieSoundPetia");
        zombieSoundPetia.play();
    }
   
    /* Play the zombie sounds  */
    public static void basicZombieSoundPlay(Node rootNode, int id){
        String idS = String.valueOf(id);
        AudioNode zombieSound = (AudioNode) rootNode.getChild("zombieSound"+idS);
        zombieSound.play();
    }

    /* Pause the zombie sounds Oriol */
    public static void OriolZombieSoundPause(Node rootNode){
        AudioNode zombieSoundOriol = (AudioNode) rootNode.getChild("zombieSoundOriol");
        zombieSoundOriol.pause();
    }
    
   /* Pause the zombie sounds Petia */
    public static void PetiaZombieSoundPause(Node rootNode){
        AudioNode zombieSoundPetia = (AudioNode) rootNode.getChild("zombieSoundPetia");
        zombieSoundPetia.pause();
    }
    
    
    /* Pause the zombie sounds  */
    public static void basicZombieSoundPause(Node rootNode, int id){
        String idS = String.valueOf(id);
        AudioNode zombieSound = (AudioNode) rootNode.getChild("zombieSound"+idS);
        zombieSound.pause();
    }
    
    
    /* Set volume the zombie sounds Oriol */
    public static void OriolZombieSoundSetVolume(Node rootNode, float vol){
        AudioNode zombieSoundOriol = (AudioNode) rootNode.getChild("zombieSoundOriol");
        zombieSoundOriol.setVolume(vol);
    }
    
    /* Set volume the zombie sounds Petia */
    public static void PetiaZombieSoundSetVolume(Node rootNode, float vol){
        AudioNode zombieSoundPetia = (AudioNode) rootNode.getChild("zombieSoundPetia");
        zombieSoundPetia.setVolume(vol);
    }
    
    
    /* Set volume to the zombie sounds  */
    public static void basicZombieSoundSetVolume(Node rootNode, int id, float vol){
        String idS = String.valueOf(id);
        AudioNode zombieSound = (AudioNode) rootNode.getChild("zombieSound"+idS);
        zombieSound.setVolume(vol);
    }

    /* Play Click  */
    public static void clickPlayInstance(Node rootNode){
        AudioNode click = (AudioNode) rootNode.getChild("click");
        click.playInstance();
    }
    
    /* Play the zombie footsteps Oriol */
    public static void OriolZombieFootStepsPlay(Node rootNode){
        AudioNode zombieFootstepOriol = (AudioNode) rootNode.getChild("zombieFootstepOriol");
        zombieFootstepOriol.play();
    }
    
   /* Play the zombie footsteps Petia */
    public static void PetiaZombieFootStepsPlay(Node rootNode){
        AudioNode zombieFootstepPetia = (AudioNode) rootNode.getChild("zombieFootstepPetia");
        zombieFootstepPetia.play();
    }
       
   /* Play the zombie footsteps */
    public static void basicZombieFootStepsPlay(Node rootNode, int id){
        String idS = String.valueOf(id);
        AudioNode zombieFootstep = (AudioNode) rootNode.getChild("zombieFootstep"+idS);
        zombieFootstep.play();
    }

    /* Pause the zombie footsteps Oriol */
    public static void OriolZombieFootStepsPause(Node rootNode){
        AudioNode zombieFootstepOriol = (AudioNode) rootNode.getChild("zombieFootstepOriol");
        zombieFootstepOriol.pause();
    }
    
   /* Pause the zombie footsteps Petia */
    public static void PetiaZombieFootStepsPause(Node rootNode){
        AudioNode zombieFootstepPetia = (AudioNode) rootNode.getChild("zombieFootstepPetia");
        zombieFootstepPetia.pause();
    }  
    
    /* Pause the zombie  footsteps */
    public static void basicZombieFootStepsPause(Node rootNode, int id){
        String idS = String.valueOf(id);
        AudioNode zombieFootstep = (AudioNode) rootNode.getChild("zombieFootstep"+idS);
        zombieFootstep.pause();
    }
    
    /* Set volume the zombie footsteps Oriol */
    public static void OriolZombieFootStepsSetVolume(Node rootNode, float vol){
        AudioNode zombieFootstepOriol = (AudioNode) rootNode.getChild("zombieFootstepOriol");
        zombieFootstepOriol.setVolume(vol);
    }
    
   /* Set volume the zombie footsteps Petia */
    public static void PetiaZombieFootStepsSetVolume(Node rootNode, float vol){
        AudioNode zombieFootstepPetia = (AudioNode) rootNode.getChild("zombieFootstepPetia");
        zombieFootstepPetia.setVolume(vol);
    }
    
    
    
    
    
    /* Set volume to the zombie sounds  */
    public static void basicZombieFootStepsSetVolume(Node rootNode, int id, float vol){
        String idS = String.valueOf(id);
        AudioNode zombieFootstep = (AudioNode) rootNode.getChild("zombieFootstep"+idS);
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

        

        AudioNode gothicTune = (AudioNode) rootNode.getChild("gothicTune");
        gothicTune.setVolume(0);

        AudioNode footSteps = (AudioNode) rootNode.getChild("footSteps");
        footSteps.setVolume(0);
        
        
        AudioNode zombieHurt = (AudioNode) rootNode.getChild("zombieHurt");
        zombieHurt.setVolume(0);
        
        AudioNode zombieDie = (AudioNode) rootNode.getChild("zombieDie");
        zombieDie.setVolume(0);
        
                
        // For each zombie mute sound and footStep
        int numZombies = 1;
        for (int i = 0; i < numZombies; ++i){
            String idS = String.valueOf(i);
            
            AudioNode zombieFootstep = (AudioNode) rootNode.getChild("zombieFootstep"+idS);
            zombieFootstep.setVolume(0);
            
            AudioNode zombieSound = (AudioNode) rootNode.getChild("zombieSound"+idS);
            zombieSound.setVolume(0);    
            
        }
        
       
    }

    /* Unmute all sounds, set at the initial volume */
    public static void unMuteAllSounds(Node rootNode){
        AudioNode click = (AudioNode) rootNode.getChild("click");
        click.setVolume(1);

       /* AudioNode zombieSound = (AudioNode) rootNode.getChild("zombieSound");
        zombieSound.setVolume(1);*/

        AudioNode gothicTune = (AudioNode) rootNode.getChild("gothicTune");
        gothicTune.setVolume(0.3f);

        AudioNode footSteps = (AudioNode) rootNode.getChild("footSteps");
        footSteps.setVolume(0.5f);
        
       /* AudioNode zombieFootstep = (AudioNode) rootNode.getChild("zombieFootstep");
        zombieFootstep.setVolume(0.1f);*/
        
        AudioNode zombieHurt = (AudioNode) rootNode.getChild("zombieHurt");
        zombieHurt.setVolume(0.2f);
        
        AudioNode zombieDie = (AudioNode) rootNode.getChild("zombieDie");
        zombieDie.setVolume(0.4f);
        
        
        
    }

}