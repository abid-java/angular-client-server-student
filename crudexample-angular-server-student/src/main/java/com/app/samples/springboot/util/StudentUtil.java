package com.app.samples.springboot.util;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.samples.springboot.controller.StudentController;
import com.app.samples.springboot.entity.Address;
import com.app.samples.springboot.entity.Student;
import com.app.samples.springboot.repository.StudentRepository;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

// TODO: Auto-generated Javadoc
/**
 * The Class StudentUtil.
 */
@Service
public class StudentUtil {

	/** The student repository. */
	@Autowired
	private StudentRepository studentRepository;
	
	/** The class name. */
	private final String CLASS_NAME = "StudentUtil";
	
	/** The logger. */
	Logger logger = Logger.getLogger(StudentUtil.class.getName());
	
	/**
	 * Existing student.
	 *
	 * @param studentId the student id
	 * @return the student
	 */
	public Student existingStudent(Long studentId) {
		String METHOD_NAME = "existingStudent";
		logger.info("<<===== executing " + METHOD_NAME + " in " + CLASS_NAME +" =====>>");
		Student existingStudent = null;
		List<Student> studentsList = studentRepository.findAll();
		for(Student student : studentsList) {
			if(student != null) {
				if(studentId.equals(student.getStudentId())) {
					existingStudent = student;
				} 
			}
		}
		return existingStudent;
	}
	
	/**
	 * Updated student.
	 *
	 * @param existingStudent the existing student
	 * @param newStudent the new student
	 * @return the student
	 */
	public Student updatedStudent(Student existingStudent, Student newStudent) {
		String METHOD_NAME = "updatedStudent";
		logger.info("<<===== executing " + METHOD_NAME + " in " + CLASS_NAME +" =====>>");
		Address existingAddress = null;
		Address newAddress = null;
		if(existingStudent != null && newStudent != null) {
			existingStudent.setFirstName(newStudent.getFirstName());
			existingStudent.setLastName(newStudent.getLastName());
			existingStudent.setEmailId(newStudent.getEmailId());
			existingStudent.setSchoolName(newStudent.getSchoolName());
			existingAddress = existingStudent.getAddress();
			newAddress = newStudent.getAddress();			
			if(existingAddress != null && newAddress != null) {
				existingAddress.setCity(newAddress.getCity());
				existingAddress.setStreet(newAddress.getStreet());
				existingAddress.setState(newAddress.getState());
				existingAddress.setCountry(newAddress.getCountry());
				existingAddress.setZipCode(newAddress.getZipCode());				
			}
			existingStudent.setAddress(existingAddress);
		}
		return existingStudent;
	}
	
	/**
	 * Convert object to json.
	 *
	 * @param javaObject the java object
	 * @return the string
	 */
	public String convertObjectToJson(Object javaObject) {
		String METHOD_NAME = "convertObjectToJson";
		logger.info("<<===== executing " + METHOD_NAME + " in " + CLASS_NAME +" =====>>");
		String jsonObject = "";
		if(javaObject != null) {
			jsonObject = new Gson().toJson(javaObject);
		}
		return jsonObject;
	}
	
}
