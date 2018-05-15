package javabeansentity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity(name="customer")
@XmlRootElement
public class Customer implements Serializable {

	
	
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@Column(unique=true, nullable=false)
	private String custName;
	@Column(unique=true, nullable=false)
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER,cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
    @JoinTable(
        name = "Customer_Coupon", 
        joinColumns = { @JoinColumn (name = "Customer_id", referencedColumnName = "id")  }, 
        inverseJoinColumns = { @JoinColumn (name = "Coupon_id", referencedColumnName = "ID") }
    )
    Set<Coupon> coupons = new HashSet<>();
	
	
	
	/**Default Constructor Customer*/
	public Customer(){
		
	}

	public Customer(long id, String custName, String password) {
		super();
		this.id = id;
		this.custName = custName;
		this.password = password;
	}

	public Customer(long id, String custName, String password, Set<Coupon> coupons) {
		super();
		this.id = id;
		this.custName = custName;
		this.password = password;
		this.coupons = coupons;
	}

	/**Getters & Setters*/
	
	/**
	 * This Getter For Customer id.
	 * @return the id
	 */
	public long getID() {
		return id;
	}

	/**
	 * this setter for receiving a Long value and update the id.
	 * @param id
	 */
	public void setID(long id) {
		this.id = id;
	}

	/**
	 * This Getter For Customer Name.
	 * @return the custName
	 */
	public String getCustName() {
		return custName;
	}

	/**
	 * this setter for receiving a String value and update the Name.
	 * @param custName
	 */
	public void setCustName(String custName) {
		this.custName = custName;
	}

	/**
	 * This Getter For Customer Password.
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * this setter for receiving a String value and update the Password.
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * This Getter For Customer Coupons.
	 * @return the coupons
	 */
	@JsonIgnore
	public Set<Coupon> getCoupons() {
		return coupons;
	}

	public void setCoupons(Set<Coupon> coupons) {
		this.coupons = coupons;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", custName=" + custName + ", password=" + password + ", coupons=" + coupons
				+ "]";
	}

	
}