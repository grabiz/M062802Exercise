/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nguyen Euler
 */
@WebServlet("/login")
public class LoggedIn extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        StringBuilder html= new StringBuilder();
        html.append("<!DOCTYPE html> <html> <head> <title>Welcome page</title> <meta char-set=\"UTF-8\"> </head>");
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String remember=req.getParameter("remember");
        if(remember==null)
        {
            html.append("<body><p>Logged in succesfully!!!</p> <p>Welcome"+username+"</p>!!!!</body>");
            
        }
        else
        {
            HttpSession session = req.getSession();
            session.setAttribute("username",username);
            session.setAttribute("password",password);
            html.append("<body><p>Logged in succesfully!!!</p> <p>Welcome"+session.getAttribute("username")+"</p>!!!!</body>");
        }
        
        html.append("<a href=\"index.html\">Log out</a>");
        html.append("</html>");
        out.println(html);
    }
    
    
}
