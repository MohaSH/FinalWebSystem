package repositoryservicesfacades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import databaserepository.CompanyRepository;
import databaserepository.CustomerRepository;
import javabeansentity.Company;
import javabeansentity.Customer;


/**
 * @author Mohammad Shinawi
 * AdminFacade class Giving access for admin for the System
 */
@Service
public class AdminFacade implements CouponClientFacade{
	
	/**Fields */
	@Autowired
	private CompanyRepository companyrepository;
	@Autowired
	private CustomerRepository customerrepository;

	/**
	 * Constructor for initialize companyDBDAO and customerDBDAO
	 */
	public AdminFacade() {
		//Validations.VerifyNotEmpty(
	}
	
	/**
	 * login Access for Admin
	 */
	@Override
	public CouponClientFacade login(String name, String password) 
	{
		if (name.equals("admin") && password.equals("1234"))
		{
			System.out.println("Login Success As Admin");
			return this;

		}
		else{
			
			System.out.println("ERROR : Login Failed As Admin");
			return null;
		}
		
	}
	
	/**
	 * CreateCompany
	 * @param Comp
	 * @throws SysException
	 */
	public void CreateCompany(Company Comp) throws SysException
	{
		companyrepository.save(Comp);
	}
	
	/**
	 * RemoveCompany
	 * @param Comp
	 * @throws SysException
	 */
	public void RemoveCompany(Company Comp) throws SysException
	{
		companyrepository.delete(Comp);
	}
	
	/**
	 * UpdateCompany
	 * @param Comp
	 * @throws SysException
	 */
	public void UpdateCompany(Company Comp) throws SysException
	{
		
		companyrepository.UPDATECOMPANY(Comp.getCompName(), Comp.getPassword(), Comp.getEmail());
	}
	
	/**
	 * getCompany
	 * @param ID
	 * @return
	 * @throws SysException
	 * @throws SQLException 
	 */
	
	public Company getCompany(long ID) throws SysException
	{
		return companyrepository.findOne(ID);
	}
	
	/**
	 * getAllCompanies
	 * @return
	 * @throws SysException
	 */
	public Iterable<Company> getAllCompanies() throws SysException
	{
		return companyrepository.findAll();
	}
	
	/**
	 * CreateCustomer
	 * @param Cust
	 * @throws SysException
	 */
	public void CreateCustomer(Customer Cust) throws SysException 
	{
		customerrepository.save(Cust);
	}
	
	/**
	 * RemoveCustomer
	 * @param Cust
	 * @throws SysException
	 */
	public void RemoveCustomer(Customer Cust) throws SysException 
	{
		customerrepository.delete(Cust);
	}
	
	/**
	 * UpdateCustomer
	 * @param Cust
	 * @throws SysException
	 */
	public void UpdateCustomer(Customer Cust) throws SysException 
	{
		customerrepository.UPDATECUSTOMER(Cust.getCustName(), Cust.getPassword());
	}
	
	/**
	 * getCustomer
	 * @param ID
	 * @return
	 * @throws SysException
	 */
	public Customer getCustomer(long ID) throws SysException 
	{
		return customerrepository.findOne(ID);
	}
	
	/**
	 * getAllCustomer
	 * @return
	 * @throws SysException
	 */
	public Iterable<Customer> getAllCustomer() throws SysException
	{
		return customerrepository.findAll();
	}

}
