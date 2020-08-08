/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminLogin;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Priya Ravi
 */
public class SeperateConnection {
    Connection getConnection()
    {
        Connection con=null;
        try{
     Class.forName("oracle.jdbc.driver.OracleDriver");
            con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","priya","777");
            return con;
        }
        catch(Exception e)
        {}
        return con;
    }
}
