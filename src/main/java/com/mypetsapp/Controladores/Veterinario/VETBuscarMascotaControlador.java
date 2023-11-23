package com.mypetsapp.Controladores.Veterinario;

import com.mypetsapp.DBUtils.DBUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class VETBuscarMascotaControlador implements Initializable {

    @FXML
    private Button butt_BuscarMascota;

    @FXML
    private Button butt_Regresar;

    @FXML
    private TextField tf_MascotaNombre;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        butt_Regresar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.cambiarEscena(event, "/com/mypetsapp/Vet/paginaOpcionesVeterinario.fxml", "Opciones | Veterinario", null, null);
            }
        });
        butt_BuscarMascota.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.buscarMascota(tf_MascotaNombre.getText());
            }
        });
    }
}
