/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compsql;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author leyva
 */
public class ConexionDB {

    public void InsertDB(String[] insert, String tabla) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        String insertTableSQL = "INSERT INTO " + tabla + " VALUES(";
//        String insertar [] = null;
//        insertar = insert;

        try {
            dbConnection = getDBConnection();

            for (int i = 0; i < insert.length; i++) {

                insertTableSQL += "?,";
                if (i == insert.length - 1) {

                    insertTableSQL = insertTableSQL.substring(0, insertTableSQL.length() - 1);

                }

            }
            insertTableSQL += ")";
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);
            System.out.println(insertTableSQL);
            for (int i = 0; i < insert.length; i++) {

                try {

                    preparedStatement.setString(i + 1, insert[i]);
                } catch (NumberFormatException e) {

                    try {
                        preparedStatement.setInt(i + 1, Integer.parseInt(insert[i]));

                    } catch (NumberFormatException f) {
                        try {
                            preparedStatement.setFloat(i + 1, Float.parseFloat(insert[i]));

                        } catch (NumberFormatException g) {
                            Date d = new Date(insert[i]);
                            preparedStatement.setDate(i + 1, (java.sql.Date) d);
                        }
                    }
                }
            }

            preparedStatement.executeUpdate();

           
            JOptionPane.showMessageDialog(null, "Se ha insertado correctamente en la tabla: " +tabla);

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

    }
    
    public void ActualizarDB(String referencia, String[] campoupd, String[] insertupd, String tabla) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        String updateTableSQL = "UPDATE " + tabla + " SET ";

        try {
            dbConnection = getDBConnection();

            for (int i = 0; i < insertupd.length; i++) {
                
                updateTableSQL +=campoupd[i];
                updateTableSQL +="=";
                updateTableSQL += "?,";
                if (i == insertupd.length - 1) {

                    updateTableSQL = updateTableSQL.substring(0, updateTableSQL.length() - 1);

                }

            }
            updateTableSQL += " WHERE " + campoupd[0] + "='" + referencia +"';";
            preparedStatement = dbConnection.prepareStatement(updateTableSQL);
            System.out.println(updateTableSQL);
            for (int i = 0; i < insertupd.length; i++) {

                try {

                    preparedStatement.setString(i + 1, insertupd[i]);
                } catch (NumberFormatException e) {

                    try {
                        preparedStatement.setInt(i + 1, Integer.parseInt(insertupd[i]));

                    } catch (NumberFormatException f) {
                        try {
                            preparedStatement.setFloat(i + 1, Float.parseFloat(insertupd[i]));

                        } catch (NumberFormatException g) {
                            Date d = new Date(insertupd[i]);
                            preparedStatement.setDate(i + 1, (java.sql.Date) d);
                        }
                    }
                }
            }

            preparedStatement.executeUpdate();

           
            JOptionPane.showMessageDialog(null, "Se ha actualizado correctamente en la tabla: " +tabla);

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

    }

    public Connection getDBConnection() throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        Connection conection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://localhost:3306/Automatas";
            conection = DriverManager.getConnection(url, "root", "escuela");
            //ruta de acceso, usuario, contraseña

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (conection != null) {
            System.out.println("Conexion exitosa");
        }

        return conection;

    }

}
