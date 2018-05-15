package databaserepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import javabeansentity.Company;


@Transactional
public interface CompanyRepository extends CrudRepository<Company, Long>{
	
	@Modifying
	@Query(value = "UPDATE company SET password= :password, email = :email  WHERE comp_name = :comp_name ;", nativeQuery = true) 
	public void UPDATECOMPANY(@Param("comp_name") String comp_name, @Param("password") String password, @Param("email") String email);
	
	@Query(value = "SELECT * FROM company WHERE comp_name=:comp_name AND password=:password", nativeQuery = true) 
	public Company SELECTFORLOGIN(@Param("comp_name") String comp_name, @Param("password") String password);

}