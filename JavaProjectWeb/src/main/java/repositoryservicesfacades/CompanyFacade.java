package repositoryservicesfacades;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import databaserepository.CompanyRepository;
import databaserepository.CouponRepository;
import javabeansentity.Company;
import javabeansentity.Coupon;
import javabeansentity.CouponType;

/**
 * @author Mohammad Shinawi
 * AdminFacade class Giving access for admin for the System
 */

@Service
public class CompanyFacade implements CouponClientFacade{
	
	/**Fields */
	private Company Logincomp;
	@Autowired
	private CouponRepository couponrepository;
	@Autowired
	private CompanyRepository companyrepository;

	/**
	 * Constructor for initialize companyDBDAO and customerDBDAO
	 * @param CompName
	 */
	public CompanyFacade() {
		
	}
	
	public Company getLogincomp() {
		return Logincomp;
	}

	public void setLogincomp(Company logincomp) {
		Logincomp = logincomp;
	}

	/**
	 * login Access for Company
	 */
	@Override
	public CouponClientFacade login(String name, String password) 
	{
		if(companyrepository.SELECTFORLOGIN(name, password) != null) 
		{
			Logincomp = companyrepository.SELECTFORLOGIN(name, password);
			if (Logincomp.getCompName().matches(name))
			{
				System.out.println("Login Success As Company");
				return this;
			}
		    else
		    {
			    System.out.println("ERROR : Login Failed As Company");
			    return null;
		    }
			
		}
		else
		    System.out.println("ERROR : Login Failed As Company");
		    return null;
	}
	
	/**
	 * CreateCoupon
	 * @param Coup
	 * @throws SysException
	 */
	public void CreateCoupon(Coupon Coup,Company Comp) throws SysException 
	{
		Coup.setCompany(Comp);
		couponrepository.save(Coup);
	}
	
	/**
	 * RemoveCoupon
	 * @param Coup
	 * @throws SysException
	 */
	public void RemoveCoupon(Coupon Coup) throws SysException
	{
		couponrepository.delete(Coup.getID());
	}
	
	/**
	 * UpdateCoupon
	 * @param Coup
	 * @throws SysException
	 */
	public void UpdateCoupon(Coupon Coup) throws SysException
	{
		couponrepository.UPDATECOUPON(Coup.getStart_Date(), Coup.getEnd_Date(), Coup.getAmount(), Coup.getType().name(), Coup.getMessage(), Coup.getPrice(), Coup.getImage(), Coup.getTitle());
	}
	
	/**
	 * getCoupon
	 * @param ID
	 * @return
	 * @throws SysException
	 */
	public Coupon getCoupon(long ID) throws SysException
	{
		return couponrepository.findOne(ID);
	}
	
	/**
	 * getAllCoupon
	 * @return
	 * @throws SysException
	 */
	public List<Coupon> getAllCoupon(Company Comp) throws SysException

	{
		return couponrepository.SELECTCoupons(Comp.getID());
	}
	
	/**
	 * getCouponByType
	 * @param CoupType
	 * @return
	 * @throws SysException
	 */
	public List<Coupon> getCouponByType(Company Comp,CouponType CoupType) throws SysException
	{
		
		return couponrepository.SELECTALLCouponsBYTYPE(Comp.getID(), CoupType.name());
	}
	
}