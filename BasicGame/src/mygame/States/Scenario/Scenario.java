/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.States.Scenario;

import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.asset.AssetManager;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.collision.shapes.CollisionShape;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.bullet.util.CollisionShapeFactory;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

/**
 *
 * @author Harpo
 */
public class Scenario {

    private final Node rootNode;
    private final ViewPort viewPort;
    private final AssetManager assetManager;
    private final ColorRGBA backgroundColor = ColorRGBA.Blue;

    public Scenario(SimpleApplication app) {
        this.rootNode = app.getRootNode();
        this.viewPort = app.getViewPort();
        this.assetManager = app.getAssetManager();

        //Ponemos el fondo en color azul
        viewPort.setBackgroundColor(backgroundColor);

        //Cargamos el escenario
        Spatial escenario = this.assetManager.loadModel("Scenes/montextura.j3o");
        escenario.move(Vector3f.ZERO);
        rootNode.attachChild(escenario);

        CollisionShape sceneShape =
                CollisionShapeFactory.createMeshShape((Node) escenario);
        RigidBodyControl landscape = new RigidBodyControl(sceneShape, 0);
        app.getStateManager().getState(BulletAppState.class).getPhysicsSpace().add(landscape);

    }
}
