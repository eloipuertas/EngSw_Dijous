package mygame.model.character;
 
import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.asset.plugins.ZipLocator;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.collision.shapes.CapsuleCollisionShape;
import com.jme3.bullet.collision.shapes.CollisionShape;
import com.jme3.bullet.control.CharacterControl;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.bullet.util.CollisionShapeFactory;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.light.AmbientLight;
import com.jme3.light.DirectionalLight;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import mygame.Main;
 
/**
 * Example 9 - How to make walls and floors solid.
 * This collision code uses Physics and a custom Action Listener.
 * @author normen, with edits by Zathras
 */
public class CharacterMainJMonkey extends AbstractAppState
        implements ActionListener {
 
  private Spatial sceneModel;
  private BulletAppState bulletAppState;
  private RigidBodyControl landscape;
  private CharacterControl player;
  private Vector3f walkDirection = new Vector3f();
  private boolean left = false, right = false, up = false, down = false;
  private SimpleApplication app;
  private Main m;
  

    @Override
    public void initialize(AppStateManager stateManager, Application applicooter){
        super.initialize(stateManager, applicooter);
        this.app = (SimpleApplication)applicooter;

    setUpKeys();
    
    CapsuleCollisionShape capsuleShape = new CapsuleCollisionShape(1.5f, 6f, 1);
    player = new CharacterControl(capsuleShape, 0.05f);
    player.setJumpSpeed(20);
    player.setFallSpeed(30);
    player.setGravity(30);
    player.setPhysicsLocation(new Vector3f(0, 10, 0));

    
    bulletAppState.getPhysicsSpace().add(player);
  }
 
  public void setState(BulletAppState state){
      bulletAppState=state;
  }
  
  /** We over-write some navigational key mappings here, so we can
   * add physics-controlled walking and jumping: */
  public void setUpKeys() {
    app.getInputManager().addMapping("Left", new KeyTrigger(KeyInput.KEY_A));
    app.getInputManager().addMapping("Right", new KeyTrigger(KeyInput.KEY_D));
    app.getInputManager().addMapping("Up", new KeyTrigger(KeyInput.KEY_W));
    app.getInputManager().addMapping("Down", new KeyTrigger(KeyInput.KEY_S));
    app.getInputManager().addMapping("Jump", new KeyTrigger(KeyInput.KEY_SPACE));
    app.getInputManager().addListener(this, "Left");
    app.getInputManager().addListener(this, "Right");
    app.getInputManager().addListener(this, "Up");
    app.getInputManager().addListener(this, "Down");
    app.getInputManager().addListener(this, "Jump");
  }
 
  /** These are our custom actions triggered by key presses.
   * We do not walk yet, we just keep track of the direction the user pressed. */
  public void onAction(String binding, boolean value, float tpf) {
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
}