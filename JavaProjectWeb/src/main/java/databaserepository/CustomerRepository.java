package databaserepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import javabeansentity.Customer;

@Transactional
public interface CustomerRepository extends CrudRepository<Customer, Long>{
	
	@Modifying
	@Query(value = "UPDATE customer SET password= :password WHERE cust_name = :cust_name ;", nativeQuery = true) 
	public void UPDATECUSTOMER(@Param("cust_name") String cust_name, @Param("password") String password);

	@Query(value = "SELECT * FROM customer WHERE cust_name=:cust_name AND password=:password", nativeQuery = true) 
	public Customer SELECTFORLOGIN(@Param("cust_name") String cust_name, @Param("password") String password);
}
