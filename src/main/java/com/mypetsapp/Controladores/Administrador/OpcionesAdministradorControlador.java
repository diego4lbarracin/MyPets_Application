package com.mypetsapp.Controladores.Administrador;

import com.mypetsapp.DBUtils.DBUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class OpcionesAdministradorControlador implements Initializable {

    @FXML
    private Button butt_ActualizarCuenta;

    @FXML
    private Button butt_AdmnistrarSuministros;

    @FXML
    private Button butt_AgendarCita;

    @FXML
    private Button butt_BuscarMascota;

    @FXML
    private Button butt_BuscarUsuario;

    @FXML
    private Button butt_CerrarSesion;

    @FXML
    private Button butt_CrearDuenoMascota;

    @FXML
    private Button butt_EliminarCuenta;

    @FXML
    private Button butt_RegistrarMascota;

    @FXML
    private Button butt_VerInventario;

    @FXML
    private Label label_TipoUsuario;

    @FXML
    private Label label_Username;
    String user;
    String tipoUser;
    public void ponerInformacionParteSuperior(String username, String tipoUsuario){
        label_Username.setText(username);
        label_TipoUsuario.setText(tipoUsuario);
        user= username;
        tipoUser = tipoUsuario;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        butt_CerrarSesion.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.cambiarEscena(event,"/com/mypetsapp/paginaIniciarSesion.fxml","Pagina Iniciar Sesion",null, null);
            }
        });

        butt_BuscarUsuario.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.cambiarEscena(event, "/com/mypetsapp/Admin/pBuscarUsuario.fxml", "Opcion Buscar Usuario| Administrador",null, null);
            }
        });

        butt_BuscarMascota.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.cambiarEscena(event, "/com/mypetsapp/Admin/pBuscarMascota.fxml", "Opcion Buscar Mascota | Administrador", null, null );
            }
        });
        butt_EliminarCuenta.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.cambiarEscena(event, "/com/mypetsapp/Admin/pEliminarDuenoMascota.fxml", "Opcion Eliminar Usuario| Administrador", null, null);
            }
        });
        butt_CrearDuenoMascota.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.cambiarEscena(event, "/com/mypetsapp/Admin/pRegistrarDueno1.fxml", "Opcion Crear Dueño Mascota| Administrador", null, null );
            }
        });

        butt_RegistrarMascota.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.cambiarEscena(event, "/com/mypetsapp/Admin/pRegistrarMascota.fxml", "Registrar Mascota| Administrador", null, null);
            }
        });


    }
}
