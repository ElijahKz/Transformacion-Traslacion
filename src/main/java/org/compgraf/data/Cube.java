package org.compgraf.data;

import javafx.geometry.Point3D;
import javafx.scene.paint.Color;

/**
 *
 * @author 
 */
public class Cube extends ObjetoGeometrico
{

    
    
 
    @SuppressWarnings(
    {
        "ConfusingArrayVararg", "PrimitiveArrayArgumentToVariableArgMethod"
    })
    public Cube(double size, Color color, double shade)
    {
        super(size, color, shade);
    }

    /**
     * Metodo que permite crear los vertices de un cuerpo, este se deja
     * abstracto para que se implemente en cada cuerpo nuevo que se haga.
     */
    //<editor-fold defaultstate="collapsed" desc="Metodo :: void crearVericesCuerpo()">
    @Override
    public void crearVericesCuerpo()
    {
        add(new Point3D(1.0, 1.0, 1.0));
        add(new Point3D(-1.0, 1.0, 1.0));
        add(new Point3D(-1.0, -1.0, 1.0));
        add(new Point3D(1.0, -1.0, 1.0));
        add(new Point3D(1.0, 1.0, -1.0));
        add(new Point3D(-1.0, 1.0, -1.0));
        add(new Point3D(-1.0, -1.0, -1.0));
        add(new Point3D(1.0, -1.0, -1.0));
    }
    //</editor-fold>

    /**
     * Metodo que permite definir el sistema de texturas de la superficie de un
     * cuerpo.
     *
     * @return
     */
    //<editor-fold defaultstate="collapsed" desc="Metodo :: float[] crearArregloCoordenadasTexturas()">
    @Override
    public float[] crearArregloCoordenadasTexturas()
    {
        float arr[] =
        {
            1, 0, 1, 1, 0, 1, 0, 0
        };
        return arr;
    }
    //</editor-fold>

    /**
     * Metodo que define los índices de vertices que forman los triangulos de
     * las caras de los cuerpos, este métodoa además empareja los vertices con
     * las texturas asociadas.
     *
     * @return
     */
    //<editor-fold defaultstate="collapsed" desc="Metodo :: int[] crearIndicesCaras()">
    @Override
    public int[] crearIndicesCaras()
    {
        int arr[] =
        {
            0, 0, 1, 1, 2, 2, 0, 0, 2, 2, 3, 3,
            4, 0, 0, 1, 3, 2, 4, 0, 3, 2, 7, 3,
            4, 0, 5, 1, 1, 2, 4, 0, 1, 2, 0, 3,
            3, 0, 2, 1, 6, 2, 3, 0, 6, 2, 7, 3,
            7, 0, 6, 1, 5, 2, 7, 0, 5, 2, 4, 3,
            1, 0, 5, 1, 6, 2, 1, 0, 6, 2, 2, 3,
        };
        return arr;
    }
    //</editor-fold>

}
