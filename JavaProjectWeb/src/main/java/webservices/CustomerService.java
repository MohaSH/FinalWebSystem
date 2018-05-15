package webservices;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javabeansentity.Coupon;
import javabeansentity.CouponType;
import javabeansentity.Customer;
import repositoryservicesfacades.CustomerFacade;
import repositoryservicesfacades.SysException;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("CustomerService")

public class CustomerService {
	
	@Autowired
	private CustomerFacade CustomerFacade;
	
	public CustomerService() {
		super();
	}
	
	private CustomerFacade getCustomerFacade(HttpServletRequest request)
	{
		CustomerFacade = (CustomerFacade) request.getSession().getAttribute("Facade");
		if(CustomerFacade == null)
		{
			System.out.println("NOT Authorized");
			return null;
		}else {
			System.out.println("Authorized");
		    return CustomerFacade;
		    }
	}
	
	@RequestMapping(value = "/Login", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Customer Login(@RequestBody Customer Cust) throws SysException
	{
		return (Customer) CustomerFacade.login(Cust.getCustName(), Cust.getPassword());
	}
	
	@RequestMapping(value = "/GetAllCoupons", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Coupon> getAllCoupons(HttpServletRequest request) throws SysException
	{
		if(this.getCustomerFacade(request) != null)
		{
		CustomerFacade = this.getCustomerFacade(request);
		List<Coupon> Coup = (List<Coupon>) CustomerFacade.getAllCoupon();
		return Coup;
		}else
			return null;
	}
	
	@RequestMapping(value = "/PurchaseCoupon", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String PurchaseCoupon(HttpServletRequest request/*,@PathVariable("id") long id*/,@RequestBody Coupon Coup) throws SysException
	{
		if(this.getCustomerFacade(request) != null)
		{
		CustomerFacade = this.getCustomerFacade(request);
		//Coupon Coup = CustomerFacade.getCoupon(IDCoup);
		//Customer Cust = AdminFacade.getCustomer(id);
		Customer Cust = CustomerFacade.getLogincust();
		CustomerFacade.PurchaseCoupon(Coup,Cust);
		return Coup.getTitle();
		}else
			return null;
	}
	
	@RequestMapping(value = "/getAllPurchasedCoupons", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Set<Coupon> getAllPurchasedCoupons(HttpServletRequest request) throws SysException
	{
		if(this.getCustomerFacade(request) != null)
		{
		CustomerFacade = this.getCustomerFacade(request);
		Customer Cust = CustomerFacade.getLogincust();
		Set<Coupon> Coup = CustomerFacade.getAllPurchasedCoupons(Cust);
		return Coup;
		}else
			return null;
	}
	
	@RequestMapping(value = "/GetAllPurchasedCouponsByType/{CoupType}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Coupon> getAllPurchasedCouponsByType(HttpServletRequest request/*,@PathVariable("id") long id*/,@PathVariable("CoupType") CouponType CoupType) throws SysException
	{
		if(this.getCustomerFacade(request) != null)
		{
		CustomerFacade = this.getCustomerFacade(request);
		//Customer Cust = AdminFacade.getCustomer(id);
		Customer Cust = CustomerFacade.getLogincust();
		List<Coupon> Coup = CustomerFacade.getAllPurchasedCouponsByType(Cust,CoupType);
		return Coup;
		}else
			return null;
	}
	
	@RequestMapping(value = "/GetAllPurchasedCouponsByPrice/{Price}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Coupon> getAllPurchasedCouponsByPrice(HttpServletRequest request/*,@PathVariable("id") long id*/,@PathVariable("Price") double Price) throws SysException
	{
		if(this.getCustomerFacade(request) != null)
		{
		CustomerFacade = this.getCustomerFacade(request);
		//Customer Cust = AdminFacade.getCustomer(id);
		Customer Cust = CustomerFacade.getLogincust();
		List<Coupon> Coup = CustomerFacade.getAllPurchasedCouponsByPrice(Cust,Price);
		return Coup;
		}else
			return null;
	}
	
	

}
