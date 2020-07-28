/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminLogin;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Priya Ravi
 */
public class AddNewTable extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        String NoOfPersons=request.getParameter("NoOfPersons");
        String NoOfTables=request.getParameter("NoOfTables");
        if(NoOfPersons.equals(""))
        {
           out.println("<script type=\"text/javascript\">alert('Enter NoOfPersons');");
           out.println("location='TableUpdatehtml.html';");
           out.println("</script>");
        }   
        else if(NoOfTables.equals(""))
        {
           out.println("<script type=\"text/javascript\">alert('Enter Count to increase');");
           out.println("location='TableUpdatehtml.html';");
           out.println("</script>");
        }
        else
        {
            int Persons=Integer.parseInt(NoOfPersons);
            int Tables=Integer.parseInt(NoOfTables);
            GetDetails get=new GetDetails();
            String result=get.AddnewTable(Persons, Tables);
            if(result.charAt(0)=='T')
            {
                out.println("<script type=\"text/javascript\">alert('"+result+"');");
           out.println("location='AddNewTablehtml.html';");
           out.println("</script>");
            }
            out.println(result);
        }
    }
}
