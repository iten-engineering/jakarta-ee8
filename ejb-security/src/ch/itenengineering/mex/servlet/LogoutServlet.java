package ch.itenengineering.mex.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LogoutServlet() {
        super();
    }


    protected void doGet(HttpServletRequest request,
    		HttpServletResponse response) throws ServletException, IOException {

    	response.setHeader("Cache-Control", "no-cache, no-store");
    	response.setHeader("Pragma", "no-cache");

    	request.getSession().invalidate();
    	response.sendRedirect(request.getContextPath() + "/exit.html");
    }    
    

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
