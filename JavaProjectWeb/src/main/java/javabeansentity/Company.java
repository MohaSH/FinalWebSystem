package javabeansentity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="company")
@XmlRootElement
public class Company implements Serializable{
	

	
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@Column(unique=true, nullable=false)
	private String compName;
	@Column(unique=true, nullable=false)
	private String password;
	@Column(unique=true, nullable=false)
	private String email;
	
	 @OneToMany(mappedBy="company")
	 private Set<Coupon> coupons;
	
	
	/**Default Constructor Company*/
	public Company(){
		
	}

	public Company(long id, String compName, String password, String email/*, Set<Coupon> coupons*/) {
		super();
		this.id = id;
		this.compName = compName;
		this.password = password;
		this.email = email;
		//this.coupons = coupons;
	}

	/**Getters & Setters*/

	/**
	 * This Getter For Company id.
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
	 * This Getter For Company Name.
	 * @return the compName
	 */
	public String getCompName() {
		return compName;
	}
	
	/**
	 * this setter for receiving a String value and update the Name.
	 * @param compName
	 */
	public void setCompName(String compName) {
		this.compName = compName;
	}
	
	/**
	 * This Getter For Company Password.
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
	 * This Getter For Company Email.
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * this setter for receiving a String value and update the email.
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	@JsonIgnore
	public Set<Coupon> getCoupons() {
		return coupons;
	}

	public void setCoupons(Set<Coupon> coupons) {
		this.coupons = coupons;
	}
	
	@Override
	public String toString() {
		return "Company [id=" + id + ", compName=" + compName + ", password=" + password + ", email=" + email
				+ ", coupons=" + coupons + "]";
	}

}