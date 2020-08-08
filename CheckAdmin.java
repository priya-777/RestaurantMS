
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Priya Ravi
 */
public class CheckAdmin {
    String checkAdmin(String Id,String Password)
    {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","priya","777");
            String query="select Id from Employees";
            PreparedStatement stmt=con.prepareStatement(query);
            ResultSet Ids=stmt.executeQuery();
            int avail=0;
            while(Ids.next())
            {
               if(Ids.getInt("Id")==Integer.parseInt(Id))
                {
                    avail=1;
                    break;
                }
            }
            
            con.setAutoCommit(true);
            con.close();
            if(avail==0)
                return "Invalid Employee Id";
            
            if(!(Integer.parseInt(Password)==777))
                return "Incorrect Password";
            
            return "1";
            
            
        }
        catch(Exception e){
           return e+"";
        }
    }
}
