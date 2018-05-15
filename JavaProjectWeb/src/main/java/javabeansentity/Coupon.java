package javabeansentity;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="coupon")
@XmlRootElement
public class Coupon implements Serializable{
	

	
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long ID;
	@Column(unique=true, nullable=false)
	private String Title;
	@Column(unique=true,nullable=false)
	private Date Start_Date;
	@Column(nullable=false)
	private Date End_Date;
	@Column(nullable=false)
	private int Amount;
	@Enumerated(EnumType.STRING)
	private CouponType Type;
	@Column(nullable=false)
	private String Message;
	@Column(nullable=false)
	private double Price;
	@Column(nullable=false)
	private String Image;
	
	@ManyToOne
    @JoinColumn(name = "Company_id", referencedColumnName = "id")
	private Company company;
	
	@ManyToMany(mappedBy = "coupons")
    private Set<Customer> customer = new HashSet<>();
	
	
	/**Default Constructor Coupon*/
	public Coupon() 
	{

	}
	

	public Coupon(long iD, String title, Date start_Date, Date end_Date, int amount, CouponType type, String message, double price, String image)
	{
		super();
		this.ID = iD;
		this.Title = title;
		this.Start_Date = start_Date;
		this.End_Date = end_Date;
		this.Amount = amount;
		this.Type = type;
		this.Message = message;
		this.Price = price;
		this.Image = image;
	}

	/**Getters & Setters*/
	
	public Coupon(long iD, String title, Date start_Date, Date end_Date, int amount, CouponType type, String message,
			double price, String image, Company company, Set<Customer> customer) {
		super();
		ID = iD;
		Title = title;
		Start_Date = start_Date;
		End_Date = end_Date;
		Amount = amount;
		Type = type;
		Message = message;
		Price = price;
		Image = image;
		this.company = company;
		this.customer = customer;
	}

	/**
	 * This Getter For Coupon id.
	 * @return the id
	 */
	public long getID() {
		return ID;
	}

	/**
	 * this setter for receiving a Long value and update the id.
	 * @param id
	 */
	public void setID(long iD) {
		this.ID = iD;
	}

	/**
	 * This Getter For Coupon Title.
	 * @return the Title
	 */
	public String getTitle() {
		return Title;
	}

	/**
	 * this setter for receiving a String value and update the Title.
	 * @param Title
	 */
	public void setTitle(String title) {
		this.Title = title;
	}

	/**
	 * This Getter For Coupon Start_Date.
	 * @return the Start_Date
	 */
	public Date getStart_Date() {
		return Start_Date;
	}

	/**
	 * this setter for receiving a Date value and update the Start_Date.
	 * @param start_Date
	 */
	public void setStart_Date(Date start_Date) {
		this.Start_Date = start_Date;
	}

	/**
	 * This Getter For Coupon End_Date.
	 * @return the End_Date
	 */
	public Date getEnd_Date() {
		return End_Date;
	}

	/**
	 * this setter for receiving a Date value and update the end_Date.
	 * @param end_Date
	 */
	public void setEnd_Date(Date end_Date) {
		this.End_Date = end_Date;
	}

	/**
	 * This Getter For Coupon Amount.
	 * @return the Amount
	 */
	public int getAmount() {
		return Amount;
	}

	/**
	 * this setter for receiving a int value and update the amount.
	 * @param amount
	 */
	public void setAmount(int amount) {
		this.Amount = amount;
	}

	/**
	 * This Getter For Coupon Type.
	 * @return the Type
	 */
	public CouponType getType() {
		return Type;
	}

	/**
	 * this setter for receiving a CouponType value and update the type.
	 * @param type
	 */
	public void setType(CouponType type) {
		this.Type = type;
	}

	/**
	 * This Getter For Coupon Message.
	 * @return the Message
	 */
	public String getMessage() {
		return Message;
	}

	/**
	 * this setter for receiving a String value and update the message.
	 * @param message
	 */
	public void setMessage(String message) {
		this.Message = message;
	}

	/**
	 * This Getter For Coupon Price.
	 * @return the Price
	 */
	public double getPrice() {
		return Price;
	}

	/**
	 * this setter for receiving a double value and update the price.
	 * @param price
	 */
	public void setPrice(double price) {
		this.Price = price;
	}

	/**
	 * This Getter For Coupon Image.
	 * @return the Image
	 */
	public String getImage() {
		return Image;
	}

	/**
	 * this setter for receiving a String value and update the image.
	 * @param image
	 */
	public void setImage(String image) {
		this.Image = image;
	}

	@JsonIgnore
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@JsonIgnore
	public Set<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(Set<Customer> customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Coupon [ID=" + ID + ", Title=" + Title + ", Start_Date=" + Start_Date + ", End_Date=" + End_Date
				+ ", Amount=" + Amount + ", Type=" + Type + ", Message=" + Message + ", Price=" + Price + ", Image="
				+ Image +/* ", company=" + company.getCompName() +*/"]";
	}

	
}