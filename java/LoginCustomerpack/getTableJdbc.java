/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginCustomerpack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;


/**
 *
 * @author Priya Ravi
 */
public class getTableJdbc {
    static Set<Integer> avail=new HashSet<Integer>();
    static Set<Integer> getEntry()
    {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","priya","777");
            String query="select NoOfPersons from TableReservation";
            PreparedStatement stmt=con.prepareStatement(query);
            ResultSet availability=stmt.executeQuery(query);
            
            while(availability.next())
            {
               avail.add(availability.getInt("NoOfPersons"));
            }
            con.setAutoCommit(true);
            con.close();
            return avail;
        }
        catch(Exception e){
           return avail;
        }
    }
}
