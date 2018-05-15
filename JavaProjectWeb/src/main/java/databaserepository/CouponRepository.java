package databaserepository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import javabeansentity.Coupon;

@Transactional
public interface CouponRepository extends CrudRepository<Coupon, Long>{
	
	@Modifying
	@Query(value = "UPDATE coupon SET start_date=:start_date ,end_date=:end_date ,amount=:amount ,type=:type ,message=:message ,price=:price ,image=:image  WHERE title=:title ", nativeQuery = true) 
	public void UPDATECOUPON(@Param("start_date") Date start_date,@Param("end_date") Date end_date,@Param("amount") int amount,@Param("type") String type,@Param("message") String message,@Param("price") double price,@Param("image") String image,@Param("title") String title);
	
	@Query(value = "SELECT * FROM coupon WHERE company_id=:company_id", nativeQuery = true) 
	public List<Coupon> SELECTCoupons(@Param("company_id") long company_id);
	
	@Query(value = "SELECT * FROM coupon WHERE company_id=:company_id AND type =:type", nativeQuery = true) 
	public List<Coupon> SELECTALLCouponsBYTYPE(@Param("company_id") long company_id,@Param("type") String type);
	
	@Query(value = "SELECT * FROM coupon WHERE id IN ( SELECT coupon_id FROM customer_coupon WHERE customer_id =:customer_id ) AND type =:type", nativeQuery = true) 
	public List<Coupon> SELECTPURCHASECOUPONBYTYPE(@Param("customer_id") long customer_id,@Param("type") String type);
	
	@Query(value = "SELECT * FROM coupon WHERE id IN ( SELECT coupon_id FROM customer_coupon WHERE customer_id =:customer_id ) AND price =:price", nativeQuery = true) 
	public List<Coupon> SELECTPURCHASECOUPONBYPrice(@Param("customer_id") long customer_id,@Param("price") double price);

}
