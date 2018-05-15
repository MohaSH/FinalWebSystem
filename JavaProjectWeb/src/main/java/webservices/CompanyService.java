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
import javabeansentity.Coupon;
import javabeansentity.CouponType;
import repositoryservicesfacades.CompanyFacade;
import repositoryservicesfacades.SysException;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("CompanyService")
public class CompanyService {
	
	@Autowired
	private CompanyFacade CompanyFacade;
	//@Autowired
	//private AdminFacade AdminFacade;
	
	public CompanyService() {
		super();
	}
	
	private CompanyFacade getCompanyFacade(HttpServletRequest request)
	{
		CompanyFacade = (CompanyFacade) request.getSession().getAttribute("Facade");
		if(CompanyFacade == null)
		{
			System.out.println("NOT Authorized");
			return null;
		}else {
			System.out.println("Authorized");
		    return CompanyFacade;
		    }
	}
	
	@RequestMapping(value = "/Login", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Company Login(@RequestBody Company Comp) throws SysException
	{
		return (Company) CompanyFacade.login(Comp.getCompName(), Comp.getPassword());
	}
	
	@RequestMapping(value = "/CreateCoupon", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String CreateCoupon(HttpServletRequest request/*,@PathVariable("id") long id*/,@RequestBody Coupon Coup) throws SysException
	{
		if(this.getCompanyFacade(request) != null)
		{
		CompanyFacade = this.getCompanyFacade(request);
		//Company Comp = AdminFacade.getCompany(id);
		Company Comp = CompanyFacade.getLogincomp();
		CompanyFacade.CreateCoupon(Coup,Comp);
		return Coup.getTitle();
		}else
			return null;
	}
	
	@RequestMapping(value = "/RemoveCoupon/{id}", method = RequestMethod.DELETE)
	public String RemoveCoupon(HttpServletRequest request,@PathVariable("id") long id) throws SysException
	{
		if(this.getCompanyFacade(request) != null)
		{
		CompanyFacade = this.getCompanyFacade(request);
		Coupon Coup = CompanyFacade.getCoupon(id);
		CompanyFacade.RemoveCoupon(Coup);
		return Coup.getTitle();
		}else
			return null;
	}
	
	@RequestMapping(value = "/UpdateCoupon", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String UpdateCoupon(HttpServletRequest request,@RequestBody Coupon Coup) throws SysException
	{
		if(this.getCompanyFacade(request) != null)
		{
		CompanyFacade = this.getCompanyFacade(request);
		CompanyFacade.UpdateCoupon(Coup);
		return Coup.getTitle();
		}else
			return null;
	}
	
	@RequestMapping(value = "/GetCoupon/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Coupon> getCoupon(HttpServletRequest request,@PathVariable("id") long id) throws SysException
	{
		if(this.getCompanyFacade(request) != null)
		{
		CompanyFacade = this.getCompanyFacade(request);
		Coupon Coup = CompanyFacade.getCoupon(id);
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(Coup);
		}else
			return null;
	}
	
	@RequestMapping(value = "/GetAllCoupon", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Coupon> getAllCoupons(HttpServletRequest request/*,@PathVariable("id") long id*/) throws SysException
	{
		if(this.getCompanyFacade(request) != null)
		{
		CompanyFacade = this.getCompanyFacade(request);
		//Company Comp = AdminFacade.getCompany(id);
		Company Comp = CompanyFacade.getLogincomp();
		List<Coupon> Coup = CompanyFacade.getAllCoupon(Comp);
		return Coup;
		}else
			return null;
	}
	
	@RequestMapping(value = "/GetCouponByType/{CoupType}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Coupon> getCouponByType(HttpServletRequest request/*,@PathVariable("id") long id*/,@PathVariable("CoupType") CouponType CoupType) throws SysException
	{
		if(this.getCompanyFacade(request) != null)
		{
		CompanyFacade = this.getCompanyFacade(request);
		//Company Comp = AdminFacade.getCompany(id);
		Company Comp = CompanyFacade.getLogincomp();
		List<Coupon> Coup = CompanyFacade.getCouponByType(Comp,CoupType);
		return Coup;
		}else
			return null;
	}
}