package org.compgraf.util;

import org.compgraf.data.ObjetoGeometrico;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Slider;
import javafx.stage.Stage;
import org.compgraf.transgeom.Aplicacion;
import org.compgraf.transgeom.FXMLController;

/**
 *
 * @author 
 */
public class PanelFactory
{

    /**
     * Crea el panel del control de la aplicación que está en un archivo tipo FXML.
     * @param stage
     * @param box
     * @return
     * @throws Exception 
     */
    //<editor-fold defaultstate="collapsed" desc="Metodo :: Node createControlPanel(Stage, ObjetoGeometrico)">
    public static Node createControlPanel(Stage stage, ObjetoGeometrico box) throws Exception
    {
        FXMLLoader myLoader = new FXMLLoader(Aplicacion.class.getResource("/fxml/Scene.fxml"));
        Parent controles = myLoader.load();
        setUpController((FXMLController)myLoader.getController(), stage, box);

        return controles;
    }
    //</editor-fold>

    /**
     * Configuración del panel de control de la aplicacion.
     * @param controller
     * @param stage
     * @param box 
     */
    //<editor-fold defaultstate="collapsed" desc="Metodo :: void setUpController(FXMLController, Stage, ObjetoGeometrico)">
    private static void setUpController(FXMLController controller, Stage stage, ObjetoGeometrico box)
    {
        controller.setStage(stage);
        Slider trX = controller.getSTrX();
        trX.setMin(-200);
        trX.setMax(200);
        trX.setValue(0);

        Slider trY = controller.getSTrY();
        trY.setMin(-200);
        trY.setMax(200);
        trY.setValue(0);

        Slider trZ = controller.getSTrZ();
        trZ.setMin(-200);
        trZ.setMax(200);
        trZ.setValue(0);

        controller.setObjetoGeometrico(box);
    }
    //</editor-fold>

}
