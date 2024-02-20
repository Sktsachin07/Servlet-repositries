package com.tut;

import java.util.Date;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
//@Table(name = "student_add")
public class Address {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name = "Addressid",length = 50)
	private int id;
	
	@Column(name="STREET")
	private String Street;
	
	@Column(name="CITY",length = 50)
	private String city;
	
	@Column(name = "is_Open")
	private boolean Isopen;
	
	@Transient
	private double x;
	
	@Column(name = "Date_")
	@Temporal(TemporalType.DATE)
	private Date dateadd;
	
	@Lob()
	private byte[] img;
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(int id, String street, String city, boolean isopen, double x, Date dateadd, byte[] img) {
		super();
		this.id = id;
		Street = street;
		this.city = city;
		this.Isopen = Isopen;
		this.x = x;
	    this.dateadd = dateadd;
		this.img = img;
	
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStreet() {
		return Street;
	}
	public void setStreet(String street) {
		Street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public boolean isIsopen() {
		return Isopen;
	}
	public void setIsopen(boolean isopen) {
		Isopen = isopen;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public Date getDateadd() {
		return dateadd;
	}
	public void setDateadd(Date dateadd) {
		this.dateadd = dateadd;
	}
	public byte[] getImg() {
		return img;
	}
	public void setImg1(byte[] img) {
		this.img = img;
	}
	public void setImg(byte[] data) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
		
}

