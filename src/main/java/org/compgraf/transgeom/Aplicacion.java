package org.compgraf.transgeom;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static javafx.application.Application.launch;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.SceneAntialiasing;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import org.compgraf.data.Cube;
import org.compgraf.data.ObjetoGeometrico;
import org.compgraf.util.ObjectFactory;
import org.compgraf.util.PanelFactory;

public class Aplicacion extends Application
{

    private ObjetoGeometrico box;

    /**
     * Metodo que crea la escena principal de la aplicación, creando un nodo raiz al cual se le 
     * agregan dos hijos, uno para la manipulación geométrica 3D y otro para el panel de control
     * de la aplicación.
     * @param stage
     * @throws Exception 
     */
    //<editor-fold defaultstate="collapsed" desc="Metodo :: start(Stage)">
    @Override
    public void start(Stage stage) throws Exception{
    
    
    // crear un cubo 3D, anchura, altura y profundidad
    Box box = new Box(100, 100, 100);

    // crear una luz puntual
    PointLight light = new PointLight();
    light.setTranslateX(-350);
    light.setTranslateY(-180);
    light.setTranslateZ(-500);
    
    Group root = new Group(box, light);

    // crear la escena, true para activar el buffer de profindidad 
    Scene scene = new Scene(root, 1280, 768, true, SceneAntialiasing.BALANCED);

    // crear una camara en perspectiva
    PerspectiveCamera camera = new PerspectiveCamera();
    camera.setTranslateX(scene.getWidth() / -2.0);
    camera.setTranslateY((scene.getHeight() / -2.0) - 150);
     
    PhongMaterial mat = new PhongMaterial(Color.RED);
    mat.setSpecularColor(Color.BLUE);
    mat.setSpecularPower(128);

// crear un cubo 3D, anchura, altura y profundidad

box.setRotate(45);
box.setRotationAxis(new Point3D(1, 1, 0));
box.setMaterial(mat);
    
    
    scene.setCamera(camera);
    stage.setTitle("JavaFX Graficos 3D");
    stage.setScene(scene);
    stage.show();
    
    
    }
            
            
            
            
            
            
            
            
//    {
//        box = new Cube(50, Color.GREEN, 50.0);
//        Node controlPanel = PanelFactory.createControlPanel(stage, box);
//        Node scene3D = ObjectFactory.createScene3D(box);
//
//        Group root = new Group();
//        root.getChildren().add(scene3D);
//        root.getChildren().add(controlPanel);
//
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.getScene().setCamera(new PerspectiveCamera());
//        stage.setResizable(false);
//        stage.setTitle("Translacion - CG");
//        stage.show();
//    }
    
    
    //</editor-fold>


    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }

}
