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
public class AdminSideTableUpdate extends HttpServlet {

    public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
    {
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();
      String input=request.getParameter("msg");
      if(input!="")
      {
      int NoOfPersons=Integer.parseInt(request.getParameter("msg"));
      GetDetails get=new GetDetails();
      int a=get.getNoOfTables(NoOfPersons);
      if(a==0)
          out.println("<h2>We have No Tables with "+NoOfPersons+" Dinners</h2>");
      else
      out.println("<h2>We have "+a+" Tables with "+NoOfPersons+" Dinners</h2>");
      }   
      out.close();
    }
}
