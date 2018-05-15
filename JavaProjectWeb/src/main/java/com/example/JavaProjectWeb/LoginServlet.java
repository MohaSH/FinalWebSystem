package com.example.JavaProjectWeb;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javabeansentity.ClientType;
import repositoryservicesfacades.CouponClientFacade;

@Controller
public class LoginServlet {

	@Autowired
	private CouponSystem couponSystem;

	
	@RequestMapping(value="/servletlogin", method=RequestMethod.GET)
	    public @ResponseBody String doGet( @RequestParam String name){
		 System.out.println("GET " + name);
	        return "HELLO " + name;
	    }
	
	@RequestMapping(value="/servletlogin", method=RequestMethod.POST)
	    public @ResponseBody void doPost(HttpServletRequest request ,HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException{
		 
		 ClientType clienttype = ClientType.valueOf(request.getParameter("clienttype"));
		 String username = request.getParameter("username");
		 String password = request.getParameter("password");

		 CouponClientFacade Facade = couponSystem.login(username, password, clienttype);

		 if(Facade == null)
		 {
			 response.sendRedirect("http://localhost:9090/index.html?error=myerror");
		 }
		 else
		 {
			switch (clienttype)
				{
					case ADMINISTRATOR:
						request.getSession().setAttribute("Facade", Facade);
						response.sendRedirect("http://localhost:9090/AdminSPA/index.html");
					break;
					case COMPANY:
						request.getSession().setAttribute("Facade", Facade);
						response.sendRedirect("http://localhost:9090/CompanySPA/index.html");
					break;
					case CUSTOMER:
						request.getSession().setAttribute("Facade", Facade);
						response.sendRedirect("http://localhost:9090/CustomerSPA/index.html");
					break;				
				}
		 }
	 }
	
}