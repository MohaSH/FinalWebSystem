package repositoryservicesfacades;

/**
 * @author Mohammad Shinawi
 * This interface has only one abstract method the login.
 */
public interface CouponClientFacade {
	
	/**
	 * Login for Couponsystem
	 * @param name
	 * @param password
	 * @param clientType
	 * @return
	 */
	CouponClientFacade login(String name, String password);
	
}