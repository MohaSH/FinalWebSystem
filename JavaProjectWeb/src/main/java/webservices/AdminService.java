package webservices;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javabeansentity.Company;
import javabeansentity.Customer;
import repositoryservicesfacades.AdminFacade;
import repositoryservicesfacades.SysException;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("AdminService")
public class AdminService {
	
	@Autowired
	private AdminFacade AdminFacade;
	
	public AdminService() {
		super();
	}
	
	private AdminFacade getAdminFacade(HttpServletRequest request)
	{
		AdminFacade = (AdminFacade) request.getSession().getAttribute("Facade");
		if(AdminFacade == null)
		{
			System.out.println("NOT Authorized");
			return null;
		}else {
			System.out.println("Authorized");
		    return AdminFacade;
		    }
	}
	
	@RequestMapping(value = "/Login/{name}/{pass}", method = RequestMethod.GET)
	public boolean Login(@PathVariable("name") String name,@PathVariable("pass") String pass) throws SysException
	{
		if(AdminFacade.login(name, pass).equals(null))
			return false;
		else 
			return true;
	}
	
	@RequestMapping(value = "/RegisterCompany", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String CreateCompany(HttpServletRequest request,@RequestBody Company Comp) throws SysException
	{
		if(this.getAdminFacade(request) != null)
		{
		AdminFacade = this.getAdminFacade(request);
		System.out.println(Comp.toString());
		AdminFacade.CreateCompany(Comp);
		return Comp.getCompName();
		}else
			return null;
	}
	
	@RequestMapping(value = "/RemoveCompany/{id}", method = RequestMethod.DELETE)
	public String RemoveCompany(HttpServletRequest request,@PathVariable("id") long id) throws SysException
	{
		if(this.getAdminFacade(request) != null)
		{
		AdminFacade = this.getAdminFacade(request);
		Company Comp = AdminFacade.getCompany(id);
		AdminFacade.RemoveCompany(Comp);
		return Comp.getCompName();
		}else
			return null;
	}
	
	@RequestMapping(value = "/UpdateCompany", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String UpdateCompany(HttpServletRequest request,@RequestBody Company Comp) throws SysException
	{
		if(this.getAdminFacade(request) != null)
		{
		AdminFacade = this.getAdminFacade(request);
		AdminFacade.UpdateCompany(Comp);
		return Comp.getCompName();
		}else
			return null;
	}
	
	@RequestMapping(value = "/GETCompany/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Company> getCompany(HttpServletRequest request,@PathVariable("id") long id) throws SysException
	{
		if(this.getAdminFacade(request) != null)
		{
		AdminFacade = this.getAdminFacade(request);
		Company Comp = AdminFacade.getCompany(id);
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(Comp);
		}else
			return null;
	}
	
	@RequestMapping(value = "/GETALLCompany", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Company> getAllCompanies(HttpServletRequest request) throws SysException
	{
		if(this.getAdminFacade(request) != null)
		{
		AdminFacade = this.getAdminFacade(request);
		List<Company> Comp = (List<Company>) AdminFacade.getAllCompanies();
		return Comp;
		}else
			return null;
	}
	
	@RequestMapping(value = "/RegisterCustomer", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String CreateCustomer(HttpServletRequest request,@RequestBody Customer Cust) throws SysException
	{
		if(this.getAdminFacade(request) != null)
		{
		AdminFacade = this.getAdminFacade(request);
		AdminFacade.CreateCustomer(Cust);
		return Cust.getCustName();
		}else
			return null;
	}
	
	@RequestMapping(value = "/RemoveCustomer/{id}", method = RequestMethod.DELETE)
	public String RemoveCustomer(HttpServletRequest request,@PathVariable("id") long id) throws SysException
	{
		if(this.getAdminFacade(request) != null)
		{
		AdminFacade = this.getAdminFacade(request);
		Customer Cust = AdminFacade.getCustomer(id);
		AdminFacade.RemoveCustomer(Cust);
		return Cust.getCustName();	
		}else
			return null;
	}
	
	@RequestMapping(value = "/UpdateCustomer", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String UpdateCustomer(HttpServletRequest request,@RequestBody Customer Cust) throws SysException
	{
		if(this.getAdminFacade(request) != null)
		{
		AdminFacade = this.getAdminFacade(request);
		AdminFacade.UpdateCustomer(Cust);
		return Cust.getCustName();
		}else
			return null;
	}
	
	@RequestMapping(value = "/GETCustomer/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Customer> getCustomer(HttpServletRequest request,@PathVariable("id") long id) throws SysException
	{
		if(this.getAdminFacade(request) != null)
		{
		AdminFacade = this.getAdminFacade(request);
		Customer Cust = AdminFacade.getCustomer(id);
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(Cust);
		}else
			return null;
	}
	
	@RequestMapping(value = "/GETALLCustomer", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Customer> getAllCustomer(HttpServletRequest request) throws SysException
	{
		if(this.getAdminFacade(request) != null)
		{
		AdminFacade = this.getAdminFacade(request);
		List<Customer> Cust = (List<Customer>) AdminFacade.getAllCustomer();
		return Cust;
		}else
			return null;
	}


}