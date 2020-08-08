/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminLogin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Priya Ravi
 */
public class UpdateTable extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        String NoOfPersons=request.getParameter("NoOfPersons");
        String count=request.getParameter("CountOfTables");
        if(NoOfPersons.equals(""))
        {
           out.println("<script type=\"text/javascript\">alert('Enter NoOfPersons');");
           out.println("location='TableUpdatehtml.html';");
           out.println("</script>");
        }   
        else if(count.equals(""))
        {
           out.println("<script type=\"text/javascript\">alert('Enter Count to increase');");
           out.println("location='TableUpdatehtml.html';");
           out.println("</script>");
        }
        else{
            int Persons=Integer.parseInt(NoOfPersons);
            int c=Integer.parseInt(count);
        
            GetDetails update=new GetDetails();
            out.println(update.updateTable(Persons,c));
            out.println("<br><br><a href='TableUpdatehtml.html' >BACK</a>");
        }
    }
}
