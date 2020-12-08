package com.app.samples.springboot.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Address.
 */
@Entity
@Table(name = "address")
public class Address {
	
	/** The student id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long studentId;

	/** The street. */
	@Column(name = "street")
	private String street;
	
	/** The city. */
	@Column(name = "city")
	private String city;
	
	/** The state. */
	@Column(name = "state")
	private String state;
	
	/** The country. */
	@Column(name = "country")
	private String country;
	
	/** The zip code. */
	@Column(name = "zip_code")
	private long zipCode;
	
	/** The student. */
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "address")
	private Student student;

	/**
	 * Instantiates a new address.
	 */
	public Address() {
		super();
	}

	/**
	 * Instantiates a new address.
	 *
	 * @param studentId the student id
	 * @param street the street
	 * @param city the city
	 * @param state the state
	 * @param country the country
	 * @param zipCode the zip code
	 */
	public Address(long studentId, String street, String city, String state, String country, long zipCode) {
		super();
		this.studentId = studentId;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipCode = zipCode;
	}

	/**
	 * Gets the student id.
	 *
	 * @return the student id
	 */
	public long getStudentId() {
		return studentId;
	}

	/**
	 * Sets the student id.
	 *
	 * @param studentId the new student id
	 */
	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	/**
	 * Gets the street.
	 *
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * Sets the street.
	 *
	 * @param street the new street
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * Gets the city.
	 *
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets the city.
	 *
	 * @param city the new city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Gets the state.
	 *
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * Sets the state.
	 *
	 * @param state the new state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Gets the country.
	 *
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Sets the country.
	 *
	 * @param country the new country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * Gets the zip code.
	 *
	 * @return the zip code
	 */
	public long getZipCode() {
		return zipCode;
	}

	/**
	 * Sets the zip code.
	 *
	 * @param zipCode the new zip code
	 */
	public void setZipCode(long zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Address [studentId=" + studentId + ", street=" + street + ", city=" + city + ", state=" + state
				+ ", country=" + country + ", zipCode=" + zipCode + ", student=" + student + "]";
	}
	
	

}
