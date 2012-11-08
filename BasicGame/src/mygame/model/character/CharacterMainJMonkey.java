package mygame.model.character;
 
import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.asset.AssetManager;
import com.jme3.audio.AudioNode;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.collision.shapes.CapsuleCollisionShape;
import com.jme3.bullet.control.CharacterControl;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Mesh;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;
 
/**
 * Example 9 - How to make walls and floors solid.
 * This collision code uses Physics and a custom Action Listener.
 * @author normen, with edits by Zathras
 */
public class CharacterMainJMonkey extends AbstractAppState
        implements ActionListener {
  
  
  private Spatial sceneModel;
  private BulletAppState bulletAppState;
  //private RigidBodyControl landscape;
  private CharacterControl player;
  private AssetManager assetManager;
  private Vector3f walkDirection = new Vector3f();
  private boolean left = false, right = false, up = false, down = false;
  private SimpleApplication app;
  boolean musica = false;
  boolean primeraVez = true;
  private int contadorMute = 1;
  private int contadorPause = 2;
  boolean isPaused;
  AudioNode audio_environment;
    private Geometry geom1;
  

    @Override
    public void initialize(AppStateManager stateManager, Application applicooter){
        super.initialize(stateManager, applicooter);
        this.app = (SimpleApplication)applicooter;

    setUpKeys();
    CapsuleCollisionShape capsuleShape = new CapsuleCollisionShape(3f, 4f, 1);
    player = new CharacterControl(capsuleShape, 0.05f);
    player.setJumpSpeed(40);
    player.setFallSpeed(100);
    player.setGravity(100);
    player.setPhysicsLocation(new Vector3f(0, 10, 0));
    this.assetManager  = app.getAssetManager();  
    //@Emilio, inicia musica de fondo
    initAmbientAudio();
    
    //MODIFICAR TEAM DEL PERSONAJE
    //modelo pj de prueba para las colisiones
    Mesh mesh1 = new Box(0.5f, 0.5f, 0.5f);
    geom1 = new Geometry("Personaje", mesh1);
    geom1.addControl(player);
    
    bulletAppState.getPhysicsSpace().add(geom1);
  }
    
  //@Emilio inicia musica ambiente.
  private void initAmbientAudio(){
      if(primeraVez){                             //
        isPaused = false;
        audio_environment = new AudioNode(assetManager, "Sounds/Environment/Dark_music_Vampirical.ogg",false);
        audio_environment.setLooping(true);
        audio_environment.setVolume(0.3f);
        reproducirAudio();
        primeraVez = false;
    }else{
        
    }  
  }
 
  public void setState(BulletAppState state){
      bulletAppState=state;
  }
  
  /** We over-write some navigational key mappings here, so we can
   * add physics-controlled walking and jumping: */
  /*
   * @Emilio Añadido mute y pause.
   */
  public void setUpKeys() {
    app.getInputManager().addMapping("Left", new KeyTrigger(KeyInput.KEY_A));
    app.getInputManager().addMapping("Right", new KeyTrigger(KeyInput.KEY_D));
    app.getInputManager().addMapping("Up", new KeyTrigger(KeyInput.KEY_W));
    app.getInputManager().addMapping("Down", new KeyTrigger(KeyInput.KEY_S));
    app.getInputManager().addMapping("Jump", new KeyTrigger(KeyInput.KEY_SPACE));
    app.getInputManager().addMapping("Mute", new KeyTrigger(KeyInput.KEY_M));
    app.getInputManager().addMapping("Paused", new KeyTrigger(KeyInput.KEY_P));
    app.getInputManager().addListener(this, "Left");
    app.getInputManager().addListener(this, "Right");
    app.getInputManager().addListener(this, "Up");
    app.getInputManager().addListener(this, "Down");
    app.getInputManager().addListener(this, "Jump");
    app.getInputManager().addListener(this, "Mute");
    app.getInputManager().addListener(this, "Paused");
  }
 
  /** These are our custom actions triggered by key presses.
   * We do not walk yet, we just keep track of the direction the user pressed. */
  public void onAction(String binding, boolean value, float tpf) {
      
    if(!isPaused){                              //@Emilio nuevo, para pausar
        if (binding.equals("Left")) {
            left = value;
        } else if (binding.equals("Right")) {
            right = value;
        } else if (binding.equals("Up")) {
            up = value;
        } else if (binding.equals("Down")) {
            down = value;
        } else if (binding.equals("Jump")) {
            player.jump();
        } 
    }
    
    if (binding.equals("Mute")) {               //@Emilio nuevo, para mutear
            if(contadorMute != 0){
                reproducirAudio();
                contadorMute--;
            }else{
                contadorMute = 1;
            } 
        } 
    if (binding.equals("Paused")){               //@Emilio nuevo, para pausar
        if(!isPaused){
            if(contadorPause==2){
                isPaused = true; 
            }
         }else{
            if(contadorPause==0){
                isPaused = false;
                contadorPause = 4;
            }
          }  
          contadorPause--;
    }
  }
 
  /**
   * This is the main event loop--walking happens here.
   * We check in which direction the player is walking by interpreting
   * the camera direction forward (camDir) and to the side (camLeft).
   * The setWalkDirection() command is what lets a physics-controlled player walk.
   * We also make sure here that the camera moves with player.
   */

  
  public void personatgeUpdate() {
    Vector3f camDir = app.getCamera().getDirection().clone().multLocal(0.6f);
    Vector3f camLeft = app.getCamera().getLeft().clone().multLocal(0.4f);
    walkDirection.set(0, 0, 0);
    if (left)  { walkDirection.addLocal(camLeft); }
    if (right) { walkDirection.addLocal(camLeft.negate()); }
    if (up)    { walkDirection.addLocal(camDir); }
    if (down)  { walkDirection.addLocal(camDir.negate()); }
    player.setWalkDirection(walkDirection);
    app.getCamera().setLocation(player.getPhysicsLocation());
  }
  
  public Vector3f getPlayerPosition(){
      return player.getPhysicsLocation();
  }
  
  //@Emilio nuevo, reproducir audio.
  private void reproducirAudio(){
     if(musica){
         audio_environment.pause();
         musica = false;
     }else{
        audio_environment.play();
        musica = true;
     }  
  }
}