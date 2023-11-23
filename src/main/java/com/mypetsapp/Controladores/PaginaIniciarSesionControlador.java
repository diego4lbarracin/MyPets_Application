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

public class PaginaIniciarSesionControlador implements Initializable {

    @FXML
    private Button button_IniciarSesion;

    @FXML
    private TextField tf_Contrasena;

    @FXML
    private TextField tf_Usuario;

    @FXML
    private Button bt_Registrarse;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        button_IniciarSesion.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.inciarSesionUsuario(event, tf_Usuario.getText(), tf_Contrasena.getText());
            }
        });
        bt_Registrarse.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.cambiarEscena(event,"/com/mypetsapp/pRegistrarUsuarioNuevo.fxml", "Registro Usuarios Nuevos", null, null);
            }
        });

    }
}
