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

public class DMRegistrarMascotaControlador implements Initializable {

    @FXML
    private Button butt_RegistrarMascota;

    @FXML
    private Button butt_Regresar;

    @FXML
    private TextField tf_Descripcion;

    @FXML
    private TextField tf_IDEstado;

    @FXML
    private TextField tf_IDTipoMascota;

    @FXML
    private TextField tf_MascotaNombre;

    static String userName;
    public static void setUserName(String username){
        userName= username;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        butt_RegistrarMascota.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                DBUtils.registrarMascota(tf_MascotaNombre.getText(), tf_IDTipoMascota.getText(), tf_Descripcion.getText(),
                        DBUtils.idDueno(userName), tf_IDEstado.getText());
            }
        });
        butt_Regresar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.cambiarEscena(event, "/com/mypetsapp/DuenoMascota/paginaOpcionesDuenoMascota.fxml", "Opciones | Dueño Mascota", null, null);
            }
        });
    }
}
