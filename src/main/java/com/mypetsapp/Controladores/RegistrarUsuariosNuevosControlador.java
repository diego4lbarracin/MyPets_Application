package com.mypetsapp.Controladores;

import com.mypetsapp.DBUtils.DBUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class RegistrarUsuariosNuevosControlador implements Initializable {

    @FXML
    private Button butt_RegistrarDueno;

    @FXML
    private Button butt_RegresarInicioSesion;

    @FXML
    private TextField tf_ApellidoDueno;

    @FXML
    private TextField tf_ContrasenaDueno;

    @FXML
    private TextField tf_DireccionDueno;

    @FXML
    private TextField tf_NombreDueno;

    @FXML
    private TextField tf_NumDocDueno;

    @FXML
    private TextField tf_TelefonoDueno;

    @FXML
    private TextField tf_TipoDoc;

    @FXML
    private TextField tf_UsernameDueno;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        butt_RegresarInicioSesion.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.cambiarEscena(event,"/com/mypetsapp/paginaIniciarSesion.fxml","Pagina Iniciar Sesion",null, null);
            }
        });

        butt_RegistrarDueno.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.registrarDuenoMascota(tf_NumDocDueno.getText(),tf_TipoDoc.getText(),tf_NombreDueno.getText(),
                        tf_ApellidoDueno.getText(),tf_DireccionDueno.getText(), tf_TelefonoDueno.getText(), tf_UsernameDueno.getText(),
                        tf_ContrasenaDueno.getText());
            }
        });
    }
}
