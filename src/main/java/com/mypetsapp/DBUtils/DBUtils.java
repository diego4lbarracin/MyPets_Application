package com.mypetsapp.DBUtils;

import com.mypetsapp.Controladores.Administrador.OpcionesAdministradorControlador;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mypetsapp.Controladores.DuenoMascota.OpcionesDuenoMascotaControlador;
import com.mypetsapp.Controladores.Veterinario.OpcionesVeterinario;
public class DBUtils {
    public static void cambiarEscena(ActionEvent event, String FXMLFile, String TituloEscena, String username, String TipoUsuario){
        Parent root = null;

        /*Cuando se envia el metodo con informacion del usuario.*/
        if( username!= null ){
            try{
                FXMLLoader loader= new FXMLLoader(DBUtils.class.getResource(FXMLFile));
                root = loader.load();
                Object controller = loader.getController();
                if (controller instanceof OpcionesAdministradorControlador opcionesAdministradorControlador) {
                    opcionesAdministradorControlador.ponerInformacionParteSuperior(username, TipoUsuario);
                } else if (controller instanceof OpcionesDuenoMascotaControlador opcionesDuenoMascota) {
                    opcionesDuenoMascota.ponerInformacionParteSuperior(username, TipoUsuario);
                } else if (controller instanceof OpcionesVeterinario opcionesVeterinario) {
                    opcionesVeterinario.ponerInformacionParteSuperior(username, TipoUsuario);

                }
            }catch ( IOException e){
                e.printStackTrace();
            }
        }else{
            try {
                root = FXMLLoader.load(DBUtils.class.getResource(FXMLFile));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /*Para poner la escena en el nodo.*/
        Stage escena = (Stage) ((Node) event.getSource()).getScene().getWindow();
        escena.setTitle(TituloEscena);
        escena.setScene(new Scene(root));
        escena.show();
    }

    /*Iniciar Sesion*/
    public static void inciarSesionUsuario(ActionEvent event, String nombreUsuario, String contrasena){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnection.connect();
            preparedStatement = connection.prepareStatement("SELECT CONTRASENA_USUARIO,ID_TIPO_USUARIO FROM TABLA_LOGIN WHERE NOMBRE_USUARIO = ?");
            preparedStatement.setString(1, nombreUsuario);
            resultSet = preparedStatement.executeQuery();
            /*Para revisar si el resultado del query esta vacio.*/
            if(!resultSet.isBeforeFirst()){
                System.out.println("No se encontro ese usuario en la BDD.");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Las credenciales son incorrectas. Ingrese un nombre de usuario contraseña válidos.");
                alert.show();
            }else {
                /*Si el result set no esta vacio.*/
                while (resultSet.next()){
                    String contrasenaQuery= resultSet.getString("CONTRASENA_USUARIO");
                    int idTipoUsuario= resultSet.getInt("ID_TIPO_USUARIO");

                    /*Si la contrasena ingresada es igual a la contrasena de la base de datos.*/
                    if(contrasenaQuery.equals(contrasena)){
                        String nombreTipoUsuario= null;
                        /*Se va cambiar la escena a la sección de opciones para tipo de usuario.*/
                        switch (idTipoUsuario){
                            case 1 -> {
                                nombreTipoUsuario = "ADMINISTRADOR";
                                cambiarEscena(event, "/com/mypetsapp/Admin/paginaOpcionesAdministrador.fxml", "Opciones Administrador", nombreUsuario, nombreTipoUsuario);
                            }
                            case 2 -> {
                                nombreTipoUsuario = "VETERINARIO";
                                cambiarEscena(event, "/com/mypetsapp/Vet/paginaOpcionesVeterinario.fxml", "Opciones Veterinario", nombreUsuario, nombreTipoUsuario);
                            }
                            case 3 -> {
                                nombreTipoUsuario = "DUEÑO";
                                cambiarEscena(event, "/com/mypetsapp/DuenoMascota/paginaOpcionesDuenoMascota.fxml", "Opciones Dueño Mascota", nombreUsuario, nombreTipoUsuario);
                            }
                        }
                    }else {
                        System.out.println("Las contraseñas no son iguales.");
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("La contraseña no es correcta. Intente nuevamente.");
                        alert.show();
                    }
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            /*Cerrando las connectiones.*/
            if (resultSet!= null){
                try {
                    resultSet.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }

            if(preparedStatement!=null){
                try {
                    preparedStatement.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /*Metodo para buscarUsuario*/
    public static void buscarUsuario(String nombreDeUsuario){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ResultSet resultSet1 = null;

        try {
            connection = DBConnection.connect();
            preparedStatement = connection.prepareStatement("SELECT ID_TIPO_USUARIO FROM TABLA_LOGIN WHERE NOMBRE_USUARIO = ?");
            preparedStatement.setString(1, nombreDeUsuario);
            resultSet = preparedStatement.executeQuery();
            if(!resultSet.isBeforeFirst()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("No se encontro ese usuario registrado en la BDD");
                alert.show();
            }
            while (resultSet.next()){
                if(resultSet.getInt("ID_TIPO_USUARIO") != 1) {
                    switch (resultSet.getInt("ID_TIPO_USUARIO")) {
                        case 2 -> {
                            preparedStatement = connection.prepareStatement("SELECT * FROM EMPLEADO WHERE TABLA_LOGINNOMBRE_USUARIO = ?");
                            preparedStatement.setString(1, nombreDeUsuario);
                            resultSet1 = preparedStatement.executeQuery();
                            StringBuilder alertContent = new StringBuilder();
                            while(resultSet1.next()){
                                alertContent.append("VETERINARIO").append("\n")
                                        .append("PK_ID_EMPLEADO: ").append(resultSet1.getInt("PK_ID_EMPLEADO")).append("\n")
                                        .append("ID_TIPODOC: ").append(resultSet1.getInt("ID_TIPODOC")).append("\n")
                                        .append("NUM_DOC_EMPLEADO: ").append(resultSet1.getLong("NUM_DOC_EMPLEADO")).append("\n")
                                        .append("NOMBRE_EMPLEADO: ").append(resultSet1.getString("NOMBRE_EMPLEADO")).append("\n")
                                        .append("APELLIDO_EMPLEADO: ").append(resultSet1.getString("APELLIDO_EMPLEADO")).append("\n")
                                        .append("ID_TIPO_SEXO: ").append(resultSet1.getInt("ID_TIPO_SEXO")).append("\n")
                                        .append("TELEFONO_EMPLEADO: ").append(resultSet1.getLong("TELEFONO_EMPLEADO")).append("\n")
                                        .append("ID_CLINICA: ").append(resultSet1.getInt("ID_CLINICA")).append("\n")
                                        .append("TABLA_LOGINNOMBRE_USUARIO: ").append(resultSet1.getString("TABLA_LOGINNOMBRE_USUARIO")).append("\n");
                            }
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("RESULTADOS DE LA BUSQUEDA");
                            alert.setHeaderText(null);
                            alert.setContentText(alertContent.toString());
                            alert.showAndWait();

                        }
                        case 3 -> {
                            preparedStatement = connection.prepareStatement("SELECT * FROM DUENO WHERE TABLA_LOGINNOMBRE_USUARIO = ?");
                            preparedStatement.setString(1, nombreDeUsuario);
                            resultSet1 = preparedStatement.executeQuery();
                            StringBuilder alertContent = new StringBuilder();
                            while (resultSet1.next()){
                                alertContent.append("DUEÑO DE MASCOTA").append("\n")
                                        .append("PK_ID_DUENO: ").append(resultSet1.getLong("PK_ID_DUENO")).append("\n")
                                        .append("ID_TIPODOC: ").append(resultSet1.getInt("ID_TIPODOC")).append("\n")
                                        .append("NOMBRE_DUENO: ").append(resultSet1.getString("NOMBRE_DUENO")).append("\n")
                                        .append("APELLIDO_DUENO: ").append(resultSet1.getString("APELLIDO_DUENO")).append("\n")
                                        .append("DIRECCION_DUENO: ").append(resultSet1.getString("DIRECCION_DUENO")).append("\n")
                                        .append("TELEFONO_DUENO: ").append(resultSet1.getLong("TELEFONO_DUENO")).append("\n")
                                        .append("TABLA_LOGINNOMBRE_USUARIO: ").append(resultSet1.getString("TABLA_LOGINNOMBRE_USUARIO"));
                            }
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("RESULTADOS DE LA BUSQUEDA");
                            alert.setHeaderText(null);
                            alert.setContentText(alertContent.toString());
                            alert.showAndWait();
                        }
                    }
                }else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("No se puede consultar este usuario.");
                    alert.show();
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            /*Cerrando las connectiones.*/
            if (resultSet!= null){
                try {
                    resultSet.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }

            if(preparedStatement!=null){
                try {
                    preparedStatement.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void buscarMascota(String nombreMascota){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnection.connect();
            preparedStatement = connection.prepareStatement("SELECT * FROM MASCOTA WHERE NOMBRE_MASCOTA = ?");
            preparedStatement.setString(1, nombreMascota);
            resultSet = preparedStatement.executeQuery();
            if(!resultSet.isBeforeFirst()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("No se encontro esa mascota. Intente nuevamente.");
                alert.show();
            }else{
                StringBuilder alertString = new StringBuilder();
                while (resultSet.next()){
                    alertString.append("INFORMACION DE LA MASCOTA").append("\n")
                            .append("PK_ID_MASCOTA: ").append(resultSet.getString("PK_ID_MASCOTA")).append("\n")
                            .append("NOMBRE_MASCOTA: ").append(resultSet.getString("NOMBRE_MASCOTA")).append("\n")
                            .append("ID_TIPO_MASCOTA: ").append(resultSet.getInt("ID_TIPO_MASCOTA")).append("\n")
                            .append("DESCRIPCION_MASCOTA: ").append(resultSet.getString("DESCRIPCION_MASCOTA")).append("\n")
                            .append("ID_DUENO: ").append(resultSet.getInt("ID_DUENO")).append("\n")
                            .append("ID_ESTADO: ").append(resultSet.getInt("ID_ESTADO")).append("\n");
                }
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText(alertString.toString());
                alert.showAndWait();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if (resultSet!= null){
                try {
                    resultSet.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }

            if(preparedStatement!=null){
                try {
                    preparedStatement.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String idDueno(String username){
        String IDDUeno = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DBConnection.connect();
            preparedStatement = connection.prepareStatement("SELECT PK_ID_DUENO FROM DUENO WHERE TABLA_LOGINNOMBRE_USUARIO = ?");
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                IDDUeno = String.valueOf(resultSet.getLong("PK_ID_DUENO"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            /*Cerrando las connectiones.*/
            if (resultSet!= null){
                try {
                    resultSet.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }

            if(preparedStatement!=null){
                try {
                    preparedStatement.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return IDDUeno;
    }
    /*Metpdo Registrar Mascota*/
    public static void registrarMascota(String nombreMascota, String
            ID_TIPO_MASCOTA, String descripcionMascota, String idDUENO, String idESTADOMASCOTA){
        Connection connection = null;
        PreparedStatement statement = null;
//        ResultSet resultSet = null;
        int ID_Tipo_Mascota = Integer.parseInt(ID_TIPO_MASCOTA);
        int idDueno = Integer.parseInt(idDUENO);
        int idEstadoMascota = Integer.parseInt(idESTADOMASCOTA);
        try {
            connection = DBConnection.connect();
            if (!existeDueno(connection, idDueno)) {
                System.out.println("El dueño no está registrado en el sistema.");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("El dueño no está registrado en el sistema");
            }else{
                statement = connection.prepareStatement("INSERT INTO Mascota (NOMBRE_MASCOTA, ID_TIPO_MASCOTA, DESCRIPCION_MASCOTA, ID_Dueno, ID_ESTADO) " +
                        "VALUES (?, ?, ?, ?, ?)");
                statement.setString(1, nombreMascota);
                statement.setInt(2, ID_Tipo_Mascota);
                statement.setString(3, descripcionMascota);
                statement.setInt(4, idDueno);
                statement.setInt(5, idEstadoMascota);

                int rowsAffected = statement.executeUpdate();

                if(rowsAffected > 0) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setContentText("La mascota "+ nombreMascota+" fue registrada correctamente de la BDD.");
                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("No se pudo registrar la mascota. Intente nuevamente.");
                    alert.show();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            /*Cerrando las connectiones.*/

            if(statement!=null){
                try {
                    statement.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*Metodo Usado por la funcion registrarMascota*/
    private static boolean existeDueno(Connection connection, int idDueno) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement("SELECT COUNT(*) AS cuenta FROM Dueno WHERE PK_ID_Dueno = ?");
            preparedStatement.setInt(1, idDueno);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int cuenta = resultSet.getInt("cuenta");
                return cuenta > 0;
            }
        } finally {
            if (resultSet!= null){
                try {
                    resultSet.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }

            if(preparedStatement!=null){
                try {
                    preparedStatement.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }

        return false;
    }
    /*Registrar Dueno Mascota*/
    public static void registrarDuenoMascota( String numDoc, String tipoDoc, String nombreDueno,
                                             String apellidoDueno, String direccionDueno, String telefono, String username, String password){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DBConnection.connect();
            preparedStatement = connection.prepareStatement("SELECT COUNT(*) AS cuenta FROM TABLA_LOGIN WHERE NOMBRE_USUARIO = ?");
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next() && resultSet.getInt("cuenta") > 0) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("El usuario " + username + " ya existe. Escriba un usurio diferente.");
                alert.show();
                return;
            }

            if (tipoDoc == null && numDoc == null && nombreDueno==null && apellidoDueno== null && direccionDueno==null && telefono==null && username==null && password== null ){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Error al registrar. Hay campos Vacios.");
                alert.show();
            }else {
                int IDTipoDOC= 0;
                if(tipoDoc.equals("CC")){
                    IDTipoDOC= 1;
                } else if (tipoDoc.equals("CE")) {
                    IDTipoDOC=2;
                }

                preparedStatement = connection.prepareStatement("INSERT INTO DUENO (PK_ID_DUENO,ID_TIPODOC,NOMBRE_DUENO,APELLIDO_DUENO,DIRECCION_DUENO,TELEFONO_DUENO)" +
                        "VALUES(?, ?, ?, ?, ?, ?)");
                preparedStatement.setLong(1, Long.parseLong(numDoc));
                preparedStatement.setInt(2, IDTipoDOC);
                preparedStatement.setString(3, nombreDueno);
                preparedStatement.setString(4, apellidoDueno);
                preparedStatement.setString(5, direccionDueno);
                preparedStatement.setLong(6, Long.parseLong(telefono));

                int rowsAffected= preparedStatement.executeUpdate();
                if(rowsAffected > 0) {
                    preparedStatement = connection.prepareStatement("INSERT INTO TABLA_LOGIN(NOMBRE_USUARIO, ID_TIPO_USUARIO, CONTRASENA_USUARIO) VALUES (?, 3, ?)");
                    preparedStatement.setString(1, username);
                    preparedStatement.setString(2, password);
                    preparedStatement.executeUpdate();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("El usuario "+ username+" fue creado correctamente en la BDD.");
                    alert.showAndWait();
                    preparedStatement = connection.prepareStatement("UPDATE DUENO SET TABLA_LOGINNOMBRE_USUARIO = ? WHERE PK_ID_DUENO = ?");
                    preparedStatement.setString(1, username);
                    preparedStatement.setString(2, numDoc);
                    preparedStatement.executeUpdate();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("No se pudo crear el usuario. Intente nuevamente.");
                    alert.show();
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            /*Cerrando las connectiones.*/
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /*Eliminar Dueno Mascota*/
    public static void eliminarCuenta(String username){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnection.connect();
            preparedStatement = connection.prepareStatement("SELECT ID_TIPO_USUARIO FROM TABLA_LOGIN WHERE NOMBRE_USUARIO = ?");
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            if(!resultSet.isBeforeFirst()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("No se encontro el usuario a eliminar. Intente nuevamente.");
                alert.show();
            }

            while (resultSet.next()){
                if (resultSet.getInt("ID_TIPO_USUARIO")!=3) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("No se puede eliminar este tipo de usuario porque es administrador o veterinario. Intente nuevamente.");
                    alert.show();
                } else {
                    preparedStatement = connection.prepareStatement("DELETE FROM DUENO WHERE TABLA_LOGINNOMBRE_USUARIO = ?");
                    preparedStatement.setString(1, username);
                    int rowsAffected = preparedStatement.executeUpdate();
                    if(rowsAffected > 0) {
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setContentText("El usuario "+ username+" fue eliminido correctamente de la BDD.");
                        alert.showAndWait();
                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("No se pudo eliminar el usuario. Intente nuevamente.");
                        alert.show();
                    }
                    preparedStatement = connection.prepareStatement("DELETE FROM TABLA_LOGIN WHERE NOMBRE_USUARIO = ?");
                    preparedStatement.setString(1, username);
                    preparedStatement.executeUpdate();
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            /*Cerrando las connectiones.*/
            if (resultSet!= null){
                try {
                    resultSet.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }

            if(preparedStatement!=null){
                try {
                    preparedStatement.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void eliminarMASCOTA(String nombreMascota){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnection.connect();
            preparedStatement = connection.prepareStatement("SELECT PK_ID_MASCOTA FROM MASCOTA WHERE NOMBRE_MASCOTA = ?");
            preparedStatement.setString(1, nombreMascota);
            resultSet = preparedStatement.executeQuery();

            if(!resultSet.isBeforeFirst()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("No se encontro la mascota a eliminar. Intente nuevamente.");
                alert.show();
            }else {
                while (resultSet.next()) {
                    int ID_MASCOTA = resultSet.getInt("PK_ID_MASCOTA");
                    preparedStatement = connection.prepareStatement("DELETE FROM MASCOTA WHERE PK_ID_MASCOTA = ?");
                    preparedStatement.setInt(1, ID_MASCOTA);
                    int rowsAffected = preparedStatement.executeUpdate();

                    if(rowsAffected > 0) {
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setContentText("La mascota "+ nombreMascota+" fue elimininada correctamente de la BDD.");
                        alert.showAndWait();
                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("No se pudo eliminar la mascota. Intente nuevamente.");
                        alert.show();
                    }

                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            /*Cerrando las connectiones.*/
            if (resultSet!= null){
                try {
                    resultSet.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }

            if(preparedStatement!=null){
                try {
                    preparedStatement.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
