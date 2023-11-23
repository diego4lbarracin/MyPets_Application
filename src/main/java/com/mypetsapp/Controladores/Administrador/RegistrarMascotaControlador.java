package com.mypetsapp.Controladores.Administrador;

import com.mypetsapp.DBUtils.DBUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class RegistrarMascotaControlador implements Initializable {

    @FXML
    private Button butt_RegistrarMascota;

    @FXML
    private Button butt_Regresar;

    @FXML
    private Label label_TipoUsuario;

    @FXML
    private Label label_Username;

    @FXML
    private TextField tf_Descripcion;

    @FXML
    private TextField tf_IDDueno;

    @FXML
    private TextField tf_IDEstado;

    @FXML
    private TextField tf_IDTipoMascota;

    @FXML
    private TextField tf_MascotaNombre;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        butt_RegistrarMascota.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.registrarMascota(tf_MascotaNombre.getText(), tf_IDTipoMascota.getText(), tf_Descripcion.getText(),
                        tf_IDDueno.getText(), tf_IDEstado.getText());
            }
        });
        butt_Regresar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.cambiarEscena(event, "/com/mypetsapp/Admin/paginaOpcionesAdministrador.fxml", "Opciones | ADMINISTRADOR", null, null);
            }
        });
    }
}
