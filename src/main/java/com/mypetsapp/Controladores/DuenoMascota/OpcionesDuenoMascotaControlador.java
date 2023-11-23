package com.mypetsapp.Controladores.DuenoMascota;

import com.mypetsapp.DBUtils.DBUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class OpcionesDuenoMascotaControlador implements Initializable {

    @FXML
    private Button butt_ActualizarCuenta;

    @FXML
    private Button butt_ActualizarMascota;

    @FXML
    private Button butt_AgendarCita;

    @FXML
    private Button butt_BuscarMascota;

    @FXML
    private Button butt_CerrarSesion;

    @FXML
    private Button butt_EliminarCuenta;

    @FXML
    private Button butt_EliminarMascota;

    @FXML
    private Button butt_GenerarFactura;

    @FXML
    private Button butt_PagarFactura;

    @FXML
    private Button butt_RegistrarMascota;

    @FXML
    private Button butt_VerHistoriaClinica;

    @FXML
    private Label label_TipoUsuario;

    @FXML
    private Label label_Username;

    String userName;
    public void ponerInformacionParteSuperior(String username, String tipoUsuario){
        label_Username.setText(username);
        label_TipoUsuario.setText(tipoUsuario);
        userName = username;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        butt_CerrarSesion.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.cambiarEscena(event,"/com/mypetsapp/paginaIniciarSesion.fxml","Pagina Iniciar Sesion",null, null);
            }
        });

        butt_RegistrarMascota.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DMRegistrarMascotaControlador.setUserName(userName);
                DBUtils.cambiarEscena(event, "/com/mypetsapp/DuenoMascota/pDMRegistrarMascota.fxml", "Pagina Registrar Mascota", userName, null);
            }
        });
        butt_EliminarCuenta.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.cambiarEscena(event, "/com/mypetsapp/DuenoMascota/pDMEliminarDuenoMascota.fxml", "Pagina Eliminar Cuenta", null, null);
            }
        });
        butt_BuscarMascota.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.cambiarEscena(event, "/com/mypetsapp/Admin/pBuscarMascota.fxml", "Pagina Buscar Mascota", null, null);
            }
        });

        butt_EliminarMascota.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.cambiarEscena(event, "/com/mypetsapp/DuenoMascota/pDMEliminarMascota.fxml", "Pagina Eliminar Mascota", null, null);
            }
        });

    }
}
