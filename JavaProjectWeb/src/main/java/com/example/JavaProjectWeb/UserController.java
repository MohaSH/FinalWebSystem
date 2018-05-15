package com.example.JavaProjectWeb;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import repositoryservicesfacades.SysException;

@RestController
public class UserController {

	/*@Autowired
	private UserService servcie;
	*/
	//@Autowired
	//private comfas omfas;
	//@Autowired
	//private CompanyFacade companyFacade;
	//@Autowired
	//private AdminFacade adminFacade;
	//@Autowired
	//private CustomerFacade customerFacade;
	
	@RequestMapping(method=RequestMethod.GET, value="/add")
	public void addUser() throws SysException{
		//comfas user = new User(3);
		//servcie.addUser(user);
       // omfas.getCompany();
		//Company Comp = new Company(1,"omp_name", "assword", "eail");
		//Customer Cust=new Customer(1,"HP","password");
		//adminFacade.CreateCompany(Comp);
		//Coupon Coup=new Coupon(1,"3",new Date(2011-1900,10-1,10),new Date(2020-1900,10-1,10),22,CouponType.ELECTRICITY,"ll",20,"sdf");
		//System.out.println(companyFacade.getCoupon(42).toString());
		//System.out.println(customerFacade.getAllPurchasedCouponsByType(Cust, CouponType.CAMPING).toString());
		//System.out.println("Keep goooooo");
		//Company Comp = companyFacade.login("omp_name", "assword");
		//if(Comp!= null) return"Keep goooooo"; else return"no Keep goooooo";
		//return "Keep goooooo";
		//User u = service.
		//System.out.println(companyFacade.login("omp_name", "assword").toString());
	}}
	/*@RequestMapping(method=RequestMethod.GET, value="/add")
	public void addUser(@RequestParam int id, @RequestParam String name){
		User user = new User(id);
		user.setName(name);
		servcie.addUser(user);

		//User u = service.
	}*/
	
	/*@RequestMapping(method=RequestMethod.GET, value="/getCompany/{id}")
	public @ResponseBody String getCompany(@PathVariable("id") Long id){
		System.out.println(id);
		System.out.println("sad");
        Company result = omfas.getCompany(id);
		System.out.println(result);
		return result.toString();
	}*/
	
	/*@RequestMapping(method=RequestMethod.GET, value="/get")
	public @ResponseBody String getUser(@RequestParam int id){
		User result =  servcie.findByUserId(id);
		System.out.println(result);
		return result.toString();
		//User u = service.
	}	
	
	@RequestMapping(method=RequestMethod.GET, value="/getbyname")
	public @ResponseBody String getUseByName(@RequestParam String name){
		User result =  servcie.findbyUserName(name);
		System.out.println(result);
		return result.toString();
		//User u = service.
	}		*/
	
//}