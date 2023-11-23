package com.mypetsapp.Controladores.DuenoMascota;

import com.mypetsapp.DBUtils.DBUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class DMEliminarDuenoControlador implements Initializable {
    @FXML
    private Button butt_Eliminar;

    @FXML
    private Button butt_Regresar;

    @FXML
    private TextField tf_UsuarioEliminar;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        butt_Regresar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.cambiarEscena(event, "/com/mypetsapp/DuenoMascota/paginaOpcionesDuenoMascota.fxml", "Opciones | Dueño Mascota", null, null);
            }
        });

        butt_Eliminar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.eliminarCuenta(tf_UsuarioEliminar.getText());
                DBUtils.cambiarEscena(event,"/com/mypetsapp/paginaIniciarSesion.fxml","Pagina Iniciar Sesion",null, null);
            }
        });
    }
}
