/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginCustomerpack;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCustomer extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       response.setContentType("text/html");
       CheckDetails checkDetail = new CheckDetails();
       PrintWriter out=response.getWriter();
       CheckTableAvailability checkTable=new CheckTableAvailability();
       UpdateDetails update=new UpdateDetails();
       String MailId=request.getParameter("MailId");
       String Number=request.getParameter("Number");
       if(MailId.length()==0)
       {
           out.println("<script type=\"text/javascript\">alert('Enter MailId');");
           out.println("location='LoginCustomerhtml.html';");
           out.println("</script>");
//           response.sendRedirect("LoginCustomerhtml.html");
       }
       else if(Number.length()==0)
       {
           out.println("<script type=\"text/javascript\">alert('Enter phone number');");
           out.println("location='LoginCustomerhtml.html';");
           out.println("</script>");
       }
       else if(Number.length()!=10)
           out.println("Enter correct Number");
       else{
       String Date=request.getParameter("Date");
       String Time=request.getParameter("Time");
       int NoOfPersons=Integer.parseInt(request.getParameter("Number of persons"));
//       out.println(checkDetail.checkDate(Date));
       if(!checkDetail.checkDate(Date))
           out.print("Check Date");
       else{
//           out.println(checkDetail.checkTime(Time));
           if(!checkDetail.checkTime(Time))
               out.println("Check Time");
           else{
//               out.println(checkTable.checkTableAvailabilityMethod(NoOfPersons));
              if(checkTable.checkTableAvailabilityMethod(NoOfPersons)>0)
              {
                  out.println("Your Table is Reserved :)");
                  update.updateReservation(NoOfPersons);
               out.println(update.updateCustomers(MailId,Number,Date,Time,NoOfPersons));
              }
              else
              {
                      out.println("Table of dinners "+NoOfPersons+" is not available");
                      }
              
               
                }
           
       }
    }
       out.println("<br><br><a href='LoginCustomerhtml.html' >BACK</a>");
    }

 
}
