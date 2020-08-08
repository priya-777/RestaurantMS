/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginCustomerpack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Priya Ravi
 */
public class getTables extends HttpServlet {
   public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
    {
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();
      getTableJdbc get=new getTableJdbc();
      Set<Integer> entries=get.getEntry();
//      out.print("<select name=\"Number of persons\" size=\"1\">");
      for(Integer i:entries)
      {
          out.println("<option>"+i +"</option>");
      }
//      out.println("</select>");

out.close();
    }

    
}
