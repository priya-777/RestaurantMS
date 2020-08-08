/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminLogin;

import LoginCustomerpack.CheckDetails;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Priya Ravi
 */
public class LoginAdmin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
            CheckAdmin check=new CheckAdmin();
            String Id =request.getParameter("Id");
            String Password=request.getParameter("Password");
            RequestDispatcher ds=request.getRequestDispatcher("What-To-Do.html");
            RequestDispatcher ds2=request.getRequestDispatcher("LoginAdminhtml.html");
//            out.println("dsfvsd");
//            out.println(check.checkAdmin(Id,Password));
            if(check.checkAdmin(Id,Password).equals("1"))
                ds.include(request,response);
            else
                ds2.include(request,response);

        }
    }

}
