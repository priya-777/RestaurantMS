/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminLogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Set;

/**
 *
 * @author Priya Ravi
 */
public class GetDetails {
        public int getNoOfTables(int NoOfPersons) 
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
               avail=availability.getInt("NoOftables");
            
            con.setAutoCommit(true);
            con.close();
            return avail;
        }
        catch(Exception e){
           return 1000;
        }
    }
       public String updateTable(int NoOfPersons,int CountToIncrease) 
        {
       try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","priya","777");
            int OldCount=getNoOfTables(NoOfPersons);
            String query="update TableReservation set NoOfTables=? where NoOfPersons=?";
            PreparedStatement stmt=con.prepareStatement(query);
            stmt.setInt(1,OldCount+CountToIncrease);
            stmt.setInt(2, NoOfPersons);
            stmt.executeQuery();
            con.setAutoCommit(true);
            con.close();
            
            return "Updating Success";
        }
        catch(Exception e){
           return e+"";
        }
    }
       public String AddnewTable(int NoOfPersons,int NoOfTables) 
        {
       try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","priya","777");
            String query="select count(NoOfPersons) from TableReservation where NoOfPersons=?";
            PreparedStatement stmt=con.prepareStatement(query);
            stmt.setInt(1, NoOfPersons);
            ResultSet count=stmt.executeQuery();
            int c=0;
            if(count.next())
            {
            c=count.getInt("count(NoOfPersons)");
            }
            
            if(c==0)
            {
            String query1="insert into TableReservation values(? ,?)";
            PreparedStatement stmt1=con.prepareStatement(query1);
            stmt1.setInt(1,NoOfPersons);
            stmt1.setInt(2,NoOfTables);
            stmt1.executeQuery();
            con.setAutoCommit(true);
            con.close();
            return "Add Table Success";
            }
            else
            return "Table Already Exists";
                   
             
            
        }
        catch(Exception e){
           return e+" ";
        }
    }
}

