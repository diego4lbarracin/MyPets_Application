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

public class BuscarUsuarioControlador implements Initializable {

    @FXML
    private Button butt_Buscar;

    @FXML
    private Button butt_Regresar;

    @FXML
    private Label label_TipoUsuario;

    @FXML
    private Label label_Username;

    @FXML
    private TextField tf_UsuarioBuscar;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        butt_Buscar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.buscarUsuario(tf_UsuarioBuscar.getText());
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
