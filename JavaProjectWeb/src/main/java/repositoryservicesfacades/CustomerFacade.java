package repositoryservicesfacades;


import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import databaserepository.CouponRepository;
import databaserepository.CustomerRepository;
import javabeansentity.Coupon;
import javabeansentity.CouponType;
import javabeansentity.Customer;

/**
 * @author Mohammad Shinawi
 * CustomerFacade class Giving access for Customer for the System
 */
@Service
public class CustomerFacade implements CouponClientFacade{
	
	/**Fields */

	private Customer Logincust;
	@Autowired
	private CouponRepository couponrepository;
	@Autowired
	private CustomerRepository customerrepository;
	//private String CustName;
	
	/**
	 * Constructor for initialize couponDBDAO and customerDBDAO
	 * @param CustName
	 */
	public CustomerFacade(/*String CustName*/) {
		//this.CustName=CustName;

	}
	
	

	public Customer getLogincust() {
		return Logincust;
	}



	public void setLogincust(Customer logincust) {
		Logincust = logincust;
	}



	/**
	 * login Access for Customer
	 */
	public CouponClientFacade login(String name, String password) 
	{
		if(customerrepository.SELECTFORLOGIN(name, password) != null) 
		{
			Logincust = customerrepository.SELECTFORLOGIN(name, password);
			if (Logincust.getCustName().matches(name))
			{
				System.out.println("Login Success As Customer");
				return this;
			}
		    else
		    {
		    	System.out.println("ERROR : Login Failed As Customer");	
			    return null;
		    }	
		}
		else
	    	System.out.println("ERROR : Login Failed As Customer");	
		    return null;
	}
	
	public Iterable<Coupon> getAllCoupon() throws SysException

	{
		return couponrepository.findAll();
	}
	
	public Coupon getCoupon(long ID) throws SysException
	{
		return couponrepository.findOne(ID);
	}
	
	/**
	 * PurchaseCoupon
	 * @param Coup
	 * @throws SysException
	 */
	public void PurchaseCoupon(Coupon Coup,Customer Cust) throws SysException
	{
	/*	if (Coup.getAmount() != 0) {
			Coup.setAmount(Coup.getAmount() - 1);
			couponDBDAO.UpdateCoupon(Coup);
		} else {
			throw new SysException("The coupon is out of stock or coupon's date expired");
		}
		couponDBDAO.PurchaseCoupon(Coup, CustName);
	*/
		Cust.getCoupons().add(Coup);
		customerrepository.save(Cust);
	}
	
	/**
	 * getAllPurchasedCoupons
	 * @throws SysException
	 */
	public Set<Coupon> getAllPurchasedCoupons(Customer Cust) throws SysException
	{
		//customerDBDAO.getCoupons(CustName);
		
		return customerrepository.findOne(Cust.getID()).getCoupons();
		
	}
	
	/**
	 * getAllPurchasedCouponsByType
	 * @param Coupontype
	 * @throws SysException
	 */
	public List<Coupon> getAllPurchasedCouponsByType(Customer Cust,CouponType Coupontype) throws SysException
	{
		
		return couponrepository.SELECTPURCHASECOUPONBYTYPE(Cust.getID(), Coupontype.name());
		
	}
	
	/**
	 * getAllPurchasedCouponsByPrice
	 * @param Price
	 * @throws SysException
	 */
	public List<Coupon> getAllPurchasedCouponsByPrice(Customer Cust,double Price) throws SysException
	{
		//customerDBDAO.getCouponsByPrice(CustName,Price);
		return  couponrepository.SELECTPURCHASECOUPONBYPrice(Cust.getID(), Price);
	}

}