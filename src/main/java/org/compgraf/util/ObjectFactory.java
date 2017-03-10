package org.compgraf.util;

import javafx.geometry.Point3D;
import javafx.scene.DepthTest;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Cylinder;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

/**
 *
 * @author 
 */
public class ObjectFactory
{

    /**
     * Metodo que permite crear los elementos básicos de una escena 3D con el
     * sistema de coordenadas y un objeto centrado en el origen.
     *
     * @param cube Objeto gráfico que compone la escena.
     * @return El nodo de la escena
     */
    //<editor-fold defaultstate="collapsed" desc="Metodo :: Node createScene3D(Node cube)">
    public static Node createScene3D(Node cube)
    {
        Group scene3D = new Group();
        scene3D.setDepthTest(DepthTest.ENABLE);
        scene3D.getTransforms().addAll(
                new Translate(250, 250),
                new Rotate(180, Rotate.X_AXIS)
        );

        scene3D.getChildren().add(ObjectFactory.createSystem(100.0));
        scene3D.getChildren().add(cube);

        return scene3D;
    }
    //</editor-fold>

    /**
     * Metodo que permite crear los ejes en el origen del sistemas de
     * coordenadas.
     *
     * @param length longitud de los ejes.
     * @return Nodo del sistema de coordenadas.
     */
    //<editor-fold defaultstate="collapsed" desc="Metodo :: Node createSystem(double)">
    public static Node createSystem(double length)
    {
        Group n = new Group();

        n.getChildren().add(createXAxe(100.0));
        n.getChildren().add(createYAxe(100.0));
        n.getChildren().add(createZAxe(100.0));

        return n;
    }
    //</editor-fold>

    /**
     * Metodo que permite crear una línea que denota el eje X del sistema de
     * coordenadas.
     *
     * @param lenght longitud de la línea.
     * @return Nodo del eje.
     */
    //<editor-fold defaultstate="collapsed" desc="Metodo :: Node createXAxe(double)">
    private static Node createXAxe(double lenght)
    {
        Cylinder axe = new Cylinder(0.5, lenght);

        axe.setRotate(90);
        axe.setTranslateX(lenght / 2);
        axe.setMaterial(new PhongMaterial(Color.RED));
        axe.setDepthTest(DepthTest.ENABLE);

        return axe;
    }
    //</editor-fold>

    /**
     * Metodo que permite crear una línea que denota el eje Y del sistema de
     * coordenadas.
     *
     * @param lenght longitud de la línea.
     * @return Nodo del eje.
     */
    //<editor-fold defaultstate="collapsed" desc="Metodo :: Node createYAxe(double)">
    private static Node createYAxe(double length)
    {
        Cylinder axe = new Cylinder(0.5, length);

        axe.setTranslateY(length / 2);
        axe.setMaterial(new PhongMaterial(Color.GREEN));
        axe.setDepthTest(DepthTest.ENABLE);

        return axe;
    }
    //</editor-fold>

    /**
     * Metodo que permite crear una línea que denota el eje Z del sistema de
     * coordenadas.
     *
     * @param lenght longitud de la línea.
     * @return Nodo del eje.
     */
    //<editor-fold defaultstate="collapsed" desc="Metodo :: Node createZAxe(double)">
    private static Node createZAxe(double length)
    {
        Cylinder axe = new Cylinder(0.5, length);

        axe.setTranslateZ(length / 2);
        axe.setRotationAxis(new Point3D(1, 0, 0));
        axe.setRotate(90);
        axe.setMaterial(new PhongMaterial(Color.BLUE));
        axe.setDepthTest(DepthTest.ENABLE);

        return axe;
    }
    //</editor-fold>
}
