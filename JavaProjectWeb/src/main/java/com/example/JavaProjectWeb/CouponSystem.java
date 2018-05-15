package com.example.JavaProjectWeb;

import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javabeansentity.ClientType;
import repositoryservicesfacades.AdminFacade;
import repositoryservicesfacades.CompanyFacade;
import repositoryservicesfacades.CouponClientFacade;
import repositoryservicesfacades.CustomerFacade;

/**
 * @author Mohammad Shinawi
 * This singleton class its the system engine controller ;
 */
@Service
public class CouponSystem{
	
	/** Fields */
    private static CouponSystem INSTANCE;
    //private DailyCouponExpirationTask task ;
    //private Thread thread;
    @Autowired
	private AdminFacade adminFacade;
    @Autowired
	private CompanyFacade companyFacade;
    @Autowired
	private CustomerFacade customerFacade;

    /**
     * private constructor
     * @throws ClassNotFoundException
     * @throws SQLException
     */
	private CouponSystem() throws ClassNotFoundException, SQLException
	{
		//task = new DailyCouponExpirationTask();
		//ConnectionPool.getInstance();
		//thread = new Thread(task);
		//thread.start();
	}
	
	/**
	 * getInstance
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public synchronized static CouponSystem getInstance() throws ClassNotFoundException, SQLException
	{
		if (INSTANCE == null)
		{
			INSTANCE = new CouponSystem();
		}
		return INSTANCE;
	}
	
	/**
	 * Controller login System
	 */
	public CouponClientFacade login(String name, String password, ClientType clientType) {

		switch (clientType)
		{
			case ADMINISTRATOR:
				
				return adminFacade.login(name, password);
			
			case COMPANY:
				
				return companyFacade.login(name, password);
			
			case CUSTOMER:

				return customerFacade.login(name, password);	
		}
		return null;
	}

	/**
	 * shutdown
	 * @throws SysException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	/*public void shutdown() throws SysException, ClassNotFoundException, SQLException {
		
		thread.interrupt();
		task.stopTask();
		ConnectionPool.getInstance().closeConnection();
		
	}*/
}