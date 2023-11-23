package com.mypetsapp.Controladores.Veterinario;

import com.mypetsapp.DBUtils.DBUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class OpcionesVeterinario implements Initializable {

    @FXML
    private Button butt_AgendarCita;

    @FXML
    private Button butt_BuscarMascota;

    @FXML
    private Button butt_CerrarSesion;

    @FXML
    private Button butt_RecetarTratamientos;

    @FXML
    private Button butt_RegistrarMascota;

    @FXML
    private Button butt_RegistrarResultadosExamn;

    @FXML
    private Button butt_Usuario;

    @FXML
    private Button butt_VerHistoriaClinica;

    @FXML
    private Label label_TipoUsuario;

    @FXML
    private Label label_Username;
    public void ponerInformacionParteSuperior(String username, String tipoUsuario){
        label_Username.setText(username);
        label_TipoUsuario.setText(tipoUsuario);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        butt_CerrarSesion.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.cambiarEscena(event,"/com/mypetsapp/paginaIniciarSesion.fxml","Pagina Iniciar Sesion",null, null);
            }
        });

        butt_BuscarMascota.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.cambiarEscena(event, "/com/mypetsapp/Vet/pVETBuscarMascota.fxml", "Pagina Buscar Mascota", null, null);
            }
        });

        butt_Usuario.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.cambiarEscena(event, "/com/mypetsapp/Vet/pVETBuscarUsuario.fxml", "Pagina Buscar Usuario", null, null);
            }
        });

        butt_RegistrarMascota.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.cambiarEscena(event, "/com/mypetsapp/Vet/pVETRegistrarMascota.fxml", "Pagina Registrar Mascota", null, null);
            }
        });

    }

    
}
