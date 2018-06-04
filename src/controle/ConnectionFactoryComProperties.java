/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Paulo Henrique Cayres
 */
public class ConnectionFactoryComProperties{
    
    public Connection getConnection() {
        try {
            // Criação de um objeto de propriedades
            Properties prop = new Properties();

            // leitura/carga do arquivo texto com as propriedades
            prop.load( getClass().getResourceAsStream("../util/bancoDeDados.properties"));

            // obtenção do valor de cada parâmetro através do método getProperty
            String dbDriver = prop.getProperty("db.driver");
            String dbUrl = prop.getProperty("db.url");
            String dbUser = prop.getProperty("db.user");
            String dbPwd = prop.getProperty("db.pwd");

 

            Class.forName(dbDriver);
            return DriverManager.getConnection(dbUrl, dbUser, dbPwd);

        } catch (ClassNotFoundException | IOException | SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
