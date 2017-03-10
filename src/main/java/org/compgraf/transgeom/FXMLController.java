package org.compgraf.transgeom;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point3D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.shape.TriangleMesh;
import javafx.stage.Stage;
import org.compgraf.data.ObjetoGeometrico;
import org.compgraf.transgeom.data.Matriz;
import org.compgraf.transgeom.util.OperacionesMatrices;

public class FXMLController implements Initializable
{

    private Stage stage;
    private ObjetoGeometrico objetoGeometrico;
    private Label[][] celdas;
    private Matriz m;

    @FXML
    private Button bSalir;

    @FXML
    private Label labelz;
    @FXML
    private Label labely;
    @FXML
    private Label labelx;
    @FXML
    private Slider sTrX;
    @FXML
    private Slider sTrY;
    @FXML
    private Slider sTrZ;

    @FXML
    private Label celda00, celda01, celda02, celda03;
    @FXML
    private Label celda10, celda11, celda12, celda13;
    @FXML
    private Label celda20, celda21, celda22, celda23;
    @FXML
    private Label celda30, celda31, celda32, celda33;
    @FXML
    private Label angulo;

    @FXML
    private Pane panelGrafico;

    /**
     * Metodo que permite terminar la ejecución de la aplicación.
     *
     * Este metodo se enlaza con la acción usando el archivo en formato FXML.
     *
     * @param event
     */
    //<editor-fold defaultstate="collapsed" desc="Metodo :: handleButtonAction(ActionEvent)">
    @FXML
    private void handleButtonAction(ActionEvent event)
    {
        stage.close();
    }
    //</editor-fold>

    /**
     * Metodo que permite hacer la rotación del cuerpo cuando se mueve el slider
     * correspondiente.
     *
     * Este metodo se enlaza con la acción usando el archivo en formato FXML.
     *
     * En el metodo se invoca la matriz de rotación sobre un eje aleatorio.
     *
     * Para aplicar la rotación al cuerpo se deben recuperar los valores de los
     * vertices del cuerpo, calcular los nuevos vertices rotados.
     *
     * Finalmente se reemplaza el buffer de coordenadas dentro de la maya del
     * cuerpo por los nuevos vertices calculados.
     *
     */
    
    @FXML
    //<editor-fold defaultstate="collapsed" desc="Metodo :: handleDraggedSliderZ()">
    private void handleDraggedSliderZ()
    {
        double size = objetoGeometrico.getSize();
        m = OperacionesMatrices.translacion(sTrX.getValue()/size, sTrY.getValue()/size, sTrZ.getValue()/size);
        actualizarValores();

        TriangleMesh tm = (TriangleMesh)objetoGeometrico.getMesh();
        tm.getPoints().clear();
        
        LinkedList<Point3D> v = objetoGeometrico.getVertices();
        LinkedList<Point3D> vf = new LinkedList<>();
        for(Point3D vi: v)
        {
            Point3D pf = OperacionesMatrices.multiplicacion(m, vi);
            vf.add(pf);
        }
        tm.getPoints().addAll(objetoGeometrico.crearArregloCoordenadasVertices(vf));
    }
    //</editor-fold>
    
    @FXML
    private void handleDraggedSliderY()
    {
        double size = objetoGeometrico.getSize();
        m = OperacionesMatrices.translacion(sTrX.getValue()/size, sTrY.getValue()/size, sTrZ.getValue()/size);
        actualizarValores();

        TriangleMesh tm = (TriangleMesh)objetoGeometrico.getMesh();
        tm.getPoints().clear();
        
        LinkedList<Point3D> v = objetoGeometrico.getVertices();
        LinkedList<Point3D> vf = new LinkedList<>();
        for(Point3D vi: v)
        {
            Point3D pf = OperacionesMatrices.multiplicacion(m, vi);
            vf.add(pf);
        }
        tm.getPoints().addAll(objetoGeometrico.crearArregloCoordenadasVertices(vf));
    }
    
    @FXML
    private void handleDraggedSliderX()
    {
        double size = objetoGeometrico.getSize();
        m = OperacionesMatrices.translacion(sTrX.getValue()/size, sTrY.getValue()/size, sTrZ.getValue()/size);
        actualizarValores();

        TriangleMesh tm = (TriangleMesh)objetoGeometrico.getMesh();
        tm.getPoints().clear();
        
        LinkedList<Point3D> v = objetoGeometrico.getVertices();
        LinkedList<Point3D> vf = new LinkedList<>();
        for(Point3D vi: v)
        {
            Point3D pf = OperacionesMatrices.multiplicacion(m, vi);
            vf.add(pf);
        }
        tm.getPoints().addAll(objetoGeometrico.crearArregloCoordenadasVertices(vf));
    }
    

    /**
     * Este metodo tiene como proposito enlazar los valores individuales que
     * están el en panel grafico con una matriz para su actualización automatica
     * usando una matriz de Lables.
     */
    //<editor-fold defaultstate="collapsed" desc="Metodo :: ajustarMatrizSalida()">
    public void ajustarMatrizSalida()
    {
        celdas = new Label[4][4];

        celdas[0][0] = celda00;
        celdas[0][1] = celda01;
        celdas[0][2] = celda02;
        celdas[0][3] = celda03;

        celdas[1][0] = celda10;
        celdas[1][1] = celda11;
        celdas[1][2] = celda12;
        celdas[1][3] = celda13;

        celdas[2][0] = celda20;
        celdas[2][1] = celda21;
        celdas[2][2] = celda22;
        celdas[2][3] = celda23;

        celdas[3][0] = celda30;
        celdas[3][1] = celda31;
        celdas[3][2] = celda32;
        celdas[3][3] = celda33;
    }
    //</editor-fold>

    /**
     * Este metodo inicializa la matriz como una matriz identidad, asigna los
     * Lables del panel con el controlador en una matriz y finalmente escribe
     * los valores de la matriz de transformacion en la matriz del panel.
     */
    //<editor-fold defaultstate="collapsed" desc="Metodo :: inicializar()">
    private void inicializar()
    {
        m = OperacionesMatrices.identidad();
        ajustarMatrizSalida();
        actualizarValores();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodo :: initialize(URL, ResourceBundle)">
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        inicializar();
    }
    //</editor-fold>

    /**
     * Este metodo actualiza los valores en la matriz visual del panel cada vez
     * que se actualiza el valor de rotación.
     */
    //<editor-fold defaultstate="collapsed" desc="Metodo :: actualizarValores()">
    private void actualizarValores()
    {
//        angulo.setText(String.format("%4.1f", slAngle.getValue()));

        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                celdas[i][j].setText(String.format("%4.1f", m.get(i, j)));
            }
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodo :: setStage(Stage)">
    public void setStage(Stage stage)
    {
        this.stage = stage;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodo :: setObjetoGeometrico(ObjetoGeometrico)">
    public void setObjetoGeometrico(ObjetoGeometrico objetoGeometrico)
    {
        this.objetoGeometrico = objetoGeometrico;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodo :: Slider getSTrX()">
    public Slider getSTrX()
    {
        return sTrX;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Metodo :: Slider getSTrY()">
    public Slider getSTrY()
    {
        return sTrY;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Metodo :: Slider getSTrZ()">
    public Slider getSTrZ()
    {
        return sTrZ;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodo :: Pane getPanelGrafico()">
    public Pane getPanelGrafico()
    {
        return panelGrafico;
    }
    //</editor-fold>
}
