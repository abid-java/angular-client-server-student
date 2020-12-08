package com.app.samples.springboot.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Student.
 */
@Entity
@Table(name = "student")
public class Student {
	
	/** The student id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long studentId;
	
	/** The first name. */
	@Column(name = "first_name")
	private String firstName;
	
	/** The last name. */
	@Column(name = "last_name")
	private String lastName;
	
	/** The email id. */
	@Column(name = "email_id")
	private String emailId;
	
	/** The school name. */
	@Column(name = "school_name")
	private String schoolName;
	
	/** The address. */
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "address_student_Id")
	private Address address;

	/**
	 * Instantiates a new student.
	 */
	public Student() {
		super();
	}	

	/**
	 * Instantiates a new student.
	 *
	 * @param studentId the student id
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param emailId the email id
	 * @param schoolName the school name
	 * @param address the address
	 */
	public Student(long studentId, String firstName, String lastName, String emailId, String schoolName, Address address) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.schoolName = schoolName;
		this.address = address;
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
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the email id.
	 *
	 * @return the email id
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * Sets the email id.
	 *
	 * @param emailId the new email id
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * Gets the address.
	 *
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * Sets the address.
	 *
	 * @param address the new address
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * Gets the school name.
	 *
	 * @return the school name
	 */
	public String getSchoolName() {
		return schoolName;
	}

	/**
	 * Sets the school name.
	 *
	 * @param schoolName the new school name
	 */
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId="
				+ emailId + ", schoolName=" + schoolName + ", address=" + address + "]";
	}
	
	

}
