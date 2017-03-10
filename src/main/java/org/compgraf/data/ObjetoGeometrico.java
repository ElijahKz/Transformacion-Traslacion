package org.compgraf.data;

import java.util.LinkedList;
import javafx.geometry.Point3D;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;

/**
 *
 * @author 
 */
public abstract class ObjetoGeometrico extends MeshView
{

    private LinkedList<Point3D> vertices;

    private double size;

    public ObjetoGeometrico(double size, Color color, double shade)
    {
        this.size = size;
        vertices = new LinkedList<>();

        crearVericesCuerpo();
        
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(color);
        material.setSpecularColor(color);
        material.setSpecularPower(shade);
        setMaterial(material);
        
        TriangleMesh tM = new TriangleMesh();
        tM.getPoints().addAll(crearArregloCoordenadasVertices(getVertices()));
        tM.getTexCoords().addAll(crearArregloCoordenadasTexturas());
        tM.getFaces().addAll(crearIndicesCaras());
        setMesh(tM);
    }

    /**
     * Metodo que permite traer el valor por el que agrandan las coordenadas.
     *
     * @return
     */
    //<editor-fold defaultstate="collapsed" desc="Metodo :: double getSize()">
    public double getSize()
    {
        return size;
    }
    //</editor-fold>

    /**
     * Metodo que permite obtener la lista de vertices del cuerpo.
     *
     * @return Lista de vertices
     */
    //<editor-fold defaultstate="collapsed" desc="Metodo :: LinkedList<Point3D> getVertices()">
    public LinkedList<Point3D> getVertices()
    {
        return vertices;
    }
    //</editor-fold>

    /**
     * Metodo que permite agregar un vertice al cuerpo.
     *
     * @param p Vertice nuevo que se agrega al cuerpo.
     */
    //<editor-fold defaultstate="collapsed" desc="Metodo :: add(Point3D)">
    public void add(Point3D p)
    {
        vertices.add(p);
    }
    //</editor-fold>

    /**
     * Metodo que permite organizar las coordenadas de los vertices de un cuerpo
     * en un arreglo de valores reales, este es el buffer de coordenadas.
     *
     * @param v Lista de vertices
     * @return buffer de valores
     */
    //<editor-fold defaultstate="collapsed" desc="Metodo :: float[] crearArregloCoordenadasVertices(LinkedList<Point3D>)">
    public float[] crearArregloCoordenadasVertices(LinkedList<Point3D> v)
    {
        float arr[] = new float[v.size() * 3];

        int i = 0;
        for (Point3D vi : v)
        {
            arr[i] = (float) (vi.getX() * size);
            arr[i + 1] = (float) (vi.getY() * size);
            arr[i + 2] = (float) (vi.getZ() * size);
            i += 3;
        }

        return arr;
    }
    //</editor-fold>

    /**
     * Metodo que permite crear los vertices de un cuerpo, este se deja
     * abstracto para que se implemente en cada cuerpo nuevo que se haga.
     */
    //<editor-fold defaultstate="collapsed" desc="Metodo abstracto :: crearVericesCuerpo()">
    public abstract void crearVericesCuerpo();
    //</editor-fold>

    /**
     * Metodo que permite definir el sistema de texturas de la superficie de un
     * cuerpo.
     *
     * @return
     */
    //<editor-fold defaultstate="collapsed" desc="Metodo abstracto :: float[] crearArregloCoordenadasTexturas()">
    public abstract float[] crearArregloCoordenadasTexturas();
    //</editor-fold>

    /**
     * Metodo que define los índices de vertices que forman los triangulos de
     * las caras de los cuerpos, este métodoa además empareja los vertices con
     * las texturas asociadas.
     *
     * @return
     */
    //<editor-fold defaultstate="collapsed" desc="Metodo abstracto :: int[] crearIndicesCaras()">
    public abstract int[] crearIndicesCaras();
    //</editor-fold>
}
