module com.mypetsapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.mypetsapp to javafx.graphics;
    opens com.mypetsapp.Controladores to javafx.fxml;
    opens com.mypetsapp.DBUtils to javafx.fxml;
    opens com.mypetsapp.Controladores.Administrador to javafx.fxml;
    opens com.mypetsapp.Controladores.DuenoMascota to javafx.fxml;
    opens com.mypetsapp.Controladores.Veterinario to javafx.fxml;
    exports com.mypetsapp.Controladores.DuenoMascota to javafx.fxml;
    exports com.mypetsapp.Controladores.Veterinario to javafx.fxml;
}