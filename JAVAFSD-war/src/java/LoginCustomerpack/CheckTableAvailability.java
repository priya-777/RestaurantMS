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

public class CheckTableAvailability {
        public int checkTableAvailabilityMethod(int NoOfPersons) 
        {
       try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","priya","777");
            String query="select NoOftables from TableReservation where NoOfPersons=?";
            PreparedStatement stmt=con.prepareStatement(query);
            stmt.setInt(1,NoOfPersons);
            
            ResultSet availability=stmt.executeQuery();
            int avail=0;
            if(availability.next())
            {
               avail=availability.getInt("NoOftables");
            }
            
            con.setAutoCommit(true);
            con.close();
            return avail;
        }
        catch(Exception e){
           return 1000;
        }

    }

}
