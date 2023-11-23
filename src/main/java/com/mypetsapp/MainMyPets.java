package com.mypetsapp;

import com.mypetsapp.DBUtils.DBConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;

public class MainMyPets extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainMyPets.class.getResource("paginaIniciarSesion.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Pagina Iniciar Sesion");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Connection connection = DBConnection.connect();
        launch();
    }
}