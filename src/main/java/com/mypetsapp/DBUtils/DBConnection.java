package com.mypetsapp.DBUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class DBConnection {
    public static String userName = "is358200";
    public static String passWord = "366njk69m5RC";

    public static String urlDB = "jdbc:oracle:thin:@orion.javeriana.edu.co:1521/LAB";
    public static Connection connect() {
        Scanner sc = new Scanner(System.in);
        Connection conn = null;
//        System.out.println("Conexion a la Base de Datos");
//        System.out.print("Usuario ->");
//        userName = sc.nextLine();
//        System.out.print("Contrasena ->");
//        passWord = sc.nextLine();
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(urlDB, userName, passWord);
            if (conn != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}