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
        
        // Initiliaze zombie die
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
        
        
        // Initialize zombieAttack
         AudioNode zombieAttack = new AudioNode(assetManager,
            "Sounds/Effects/zombieAttack1.wav",false);
        zombieAttack.setLooping(true);
        zombieAttack.setName("zombieAttack");
        zombieAttack.setVolume(0.4f);
        rootNode.attachChild(zombieAttack);
        
        
        // Initiliaze zombie hurt Petia
        AudioNode PetiaZombieHurt = new AudioNode(assetManager,
            "Sounds/Effects/zombiePetiaHurt.wav",false);
        PetiaZombieHurt.setLooping(true);
        PetiaZombieHurt.setName("PetiaZombieHurt");
        PetiaZombieHurt.setVolume(0.2f);
        rootNode.attachChild(PetiaZombieHurt);
        
        // Initiliaze zombie die Petia
        AudioNode PetiaZombieDie = new AudioNode(assetManager,
            "Sounds/Effects/zombiePetiaDie.wav",false);
        PetiaZombieDie.setLooping(true);
        PetiaZombieDie.setName("PetiaZombieDie");
        PetiaZombieDie.setVolume(0.4f);
        rootNode.attachChild(PetiaZombieDie);
        
        // Initialize zombieAttack Petia
         AudioNode PetiaZombieAttack = new AudioNode(assetManager,
            "Sounds/Effects/zombieAttack1.wav",false);
        PetiaZombieAttack.setLooping(true);
        PetiaZombieAttack.setName("PetiaZombieAttack");
        PetiaZombieAttack.setVolume(0.4f);
        rootNode.attachChild(PetiaZombieAttack);
        
        // Initiliaze zombie hurt Oriol
        AudioNode OriolZombieHurt = new AudioNode(assetManager,
            "Sounds/Effects/zombieOriolHurt.wav",false);
        OriolZombieHurt.setLooping(true);
        OriolZombieHurt.setName("OriolZombieHurt");
        OriolZombieHurt.setVolume(0.2f);
        rootNode.attachChild(OriolZombieHurt);
        
        // Initiliaze zombie die Oriol
        AudioNode OriolZombieDie = new AudioNode(assetManager,
            "Sounds/Effects/zombieOriolDie.wav",false);
        OriolZombieDie.setLooping(true);
        OriolZombieDie.setName("OriolZombieDie");
        OriolZombieDie.setVolume(0.4f);
        rootNode.attachChild(OriolZombieDie);
        
         // Initialize zombieAttack Petia
         AudioNode OriolZombieAttack = new AudioNode(assetManager,
            "Sounds/Effects/zombieAttack1.wav",false);
        OriolZombieAttack.setLooping(true);
        OriolZombieAttack.setName("OriolZombieAttack");
        OriolZombieAttack.setVolume(0.4f);
        rootNode.attachChild(OriolZombieAttack);
        
        // Initialize reload gun
        AudioNode reloadGun = new AudioNode(assetManager,
            "Sounds/Effects/reloadGun.wav",false);
        reloadGun.setLooping(true);
        reloadGun.setName("reloadGun");
        reloadGun.setVolume(0.2f);
        rootNode.attachChild(reloadGun);
        
        // Initialize change to gun
        AudioNode changeToGun = new AudioNode(assetManager,
            "Sounds/Effects/changeToGun.wav",false);
        changeToGun.setLooping(true);
        changeToGun.setName("changeToGun");
        changeToGun.setVolume(0.4f);
        rootNode.attachChild(changeToGun);   
        
        // Initialize change tu truncheon
        AudioNode changeToTruncheon = new AudioNode(assetManager,
            "Sounds/Effects/changeToTruncheon.wav",false);
        changeToTruncheon.setLooping(true);
        changeToTruncheon.setName("changeToTruncheon");
        changeToTruncheon.setVolume(0.4f);
        rootNode.attachChild(changeToTruncheon);
        
        
        // Initilaize shot gun
        AudioNode shotGun = new AudioNode(assetManager,
            "Sounds/Effects/shotGun.wav",false);
        shotGun.setLooping(true);
        shotGun.setName("shotGun");
        shotGun.setVolume(0.8f);
        rootNode.attachChild(shotGun);

        // Initialize truncheon attack
        AudioNode hitTruncheon = new AudioNode(assetManager,
            "Sounds/Effects/reloadGun.wav",false);
        hitTruncheon.setLooping(true);
        hitTruncheon.setName("hitTruncheon");
        hitTruncheon.setVolume(0.4f);
        hitTruncheon.attachChild(hitTruncheon);
           
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
                "Sounds/Effects/zombieFootStep2.wav",false);
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
        zombieFootstep.setVolume(0.5f * vol);
    }
    
    /* Play zombie hurt  */
    public static void basicZombieHurtPlayInstance(Node rootNode){
        AudioNode zombieHurt = (AudioNode) rootNode.getChild("zombieHurt");
        zombieHurt.playInstance();
    }
    
    /* Play zombie die  */
    public static void basicZombieDiePlayInstance(Node rootNode){
        AudioNode zombieDie = (AudioNode) rootNode.getChild("zombieDie");
        zombieDie.playInstance();
    }

    /* Play zombie attack  */
    public static void basicZombieAttackPlayInstance(Node rootNode){
        AudioNode zombieAttack = (AudioNode) rootNode.getChild("zombieAttack");
        zombieAttack.playInstance();
    }
    
        /* Play reload gun */
    public static void reloadGunPlayInstance(Node rootNode){
        AudioNode reloadGun = (AudioNode) rootNode.getChild("reloadGun");
        reloadGun.playInstance();
    }
    
        /* Play shot gun  */
    public static void shotGunPlayInstance(Node rootNode){
        AudioNode shotGun = (AudioNode) rootNode.getChild("shotGun");
        shotGun.playInstance();
    }
    
        /* Play truncheon attack  */
    public static void hitTruncheonPlayInstance(Node rootNode){
        AudioNode hitTruncheon = (AudioNode) rootNode.getChild("hitTruncheon");
        hitTruncheon.playInstance();
    }
    
        /* Play change to gun  */
    public static void changeToGunPlayInstance(Node rootNode){
        AudioNode changeToGun = (AudioNode) rootNode.getChild("changeToGun");
        changeToGun.playInstance();
    }
    
        /* Play change to truncheon  */
    public static void changeToTruncheonPlayInstance(Node rootNode){
        AudioNode changeToTruncheon = (AudioNode) rootNode.getChild("changeToTruncheon");
        changeToTruncheon.playInstance();
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
        
        AudioNode zombieAttack = (AudioNode) rootNode.getChild("zombieAttack");
        zombieAttack.setVolume(0);
        
                
        // For each zombie mute sound and footStep
        int numZombies = 5;
        for (int i = 0; i < numZombies; ++i){
            String idS = String.valueOf(i);
            
            AudioNode zombieFootstep = (AudioNode) rootNode.getChild("zombieFootstep"+idS);
            zombieFootstep.setVolume(0);
            
            AudioNode zombieSound = (AudioNode) rootNode.getChild("zombieSound"+idS);
            zombieSound.setVolume(0);    
            
        }
        
        AudioNode PetiaZombieHurt = (AudioNode) rootNode.getChild("PetiaZombieHurt");
        PetiaZombieHurt.setVolume(0);
        
        AudioNode PetiaZombieDie = (AudioNode) rootNode.getChild("PetiaZombieDie");
        PetiaZombieDie.setVolume(0);
        
        AudioNode PetiaZombieAttack = (AudioNode) rootNode.getChild("PetiaZombieAttack");
        PetiaZombieAttack.setVolume(0);
        
        AudioNode OriolZombieHurt = (AudioNode) rootNode.getChild("OriolZombieHurt");
        OriolZombieHurt.setVolume(0);
        
        AudioNode OriolZombieDie = (AudioNode) rootNode.getChild("OriolZombieDie");
        OriolZombieDie.setVolume(0);
        
        AudioNode OriolZombieAttack = (AudioNode) rootNode.getChild("OriolZombieAttack");
        OriolZombieAttack.setVolume(0);
        
        AudioNode hitTruncheon = (AudioNode) rootNode.getChild("hitTruncheon");
        hitTruncheon.setVolume(0);
        
        AudioNode changeToGun = (AudioNode) rootNode.getChild("changeToGun");
        changeToGun.setVolume(0);
        
        AudioNode changeToTruncheon = (AudioNode) rootNode.getChild("changeToTruncheon");
        changeToTruncheon.setVolume(0);
        
        AudioNode shotGun = (AudioNode) rootNode.getChild("shotGun");
        shotGun.setVolume(0);
        
        AudioNode reloadGun = (AudioNode) rootNode.getChild("reloadGun");
        reloadGun.setVolume(0);       
        
       
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
        
        AudioNode zombieAttack = (AudioNode) rootNode.getChild("zombieAttack");
        zombieAttack.setVolume(0.4f);
        
        AudioNode PetiaZombieHurt = (AudioNode) rootNode.getChild("PetiaZombieHurt");
        PetiaZombieHurt.setVolume(0.2f);
        
        AudioNode PetiaZombieDie = (AudioNode) rootNode.getChild("PetiaZombieDie");
        PetiaZombieDie.setVolume(0.4f);
        
        AudioNode PetiaZombieAttack = (AudioNode) rootNode.getChild("PetiaZombieAttack");
        PetiaZombieAttack.setVolume(0.4f);
        
        AudioNode OriolZombieHurt = (AudioNode) rootNode.getChild("OriolZombieHurt");
        OriolZombieHurt.setVolume(0.2f);
        
        AudioNode OriolZombieDie = (AudioNode) rootNode.getChild("OriolZombieDie");
        OriolZombieDie.setVolume(0.4f);
        
        AudioNode OriolZombieAttack = (AudioNode) rootNode.getChild("OriolZombieAttack");
        OriolZombieAttack.setVolume(0.4f);
        
        AudioNode hitTruncheon = (AudioNode) rootNode.getChild("hitTruncheon");
        hitTruncheon.setVolume(0.4f);
        
        AudioNode changeToGun = (AudioNode) rootNode.getChild("changeToGun");
        changeToGun.setVolume(0.4f);
        
        AudioNode changeToTruncheon = (AudioNode) rootNode.getChild("changeToTruncheon");
        changeToTruncheon.setVolume(0.4f);
        
        AudioNode shotGun = (AudioNode) rootNode.getChild("shotGun");
        shotGun.setVolume(0.8f);
        
        AudioNode reloadGun = (AudioNode) rootNode.getChild("reloadGun");
        reloadGun.setVolume(0.2f);
        
        
    }

}