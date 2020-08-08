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

/**
 *
 * @author Priya Ravi
 */
public class UpdateDetails {
    void updateReservation(int NoOfPersons)
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
            
            String updatequery="update TableReservation set NoOftables=? where NoOfPersons=?";
            PreparedStatement updatestmt=con.prepareStatement(updatequery);
            updatestmt.setInt(1, avail-1);
            updatestmt.setInt(2, NoOfPersons);
            updatestmt.executeQuery();
            con.setAutoCommit(true);
            con.close();
        }
        catch(Exception e){
           return ;
        }
    }
    String updateCustomers(String MailId,String Number,String Date,String Time,int NoOfPersons)
    {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","priya","777");
            String query="insert into Customers values(?,?,?,?,?)";
            PreparedStatement stmt=con.prepareStatement(query);
            stmt.setString(1,MailId);
            stmt.setString(2,Number);
            stmt.setString(3,Date);
            stmt.setString(4,Time);
            stmt.setInt(5,NoOfPersons);
            String returnString=MailId+" | "+Number+" | "+Date+" | "+Time+" | "+NoOfPersons;
            stmt.executeQuery();
            con.setAutoCommit(true);
            con.close();
            
            return returnString;
        }
        catch(Exception e){
           return "";
        }
    }
}
