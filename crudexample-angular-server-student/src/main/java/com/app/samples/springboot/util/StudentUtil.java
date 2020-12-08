package com.app.samples.springboot.util;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.samples.springboot.entity.Student;
import com.app.samples.springboot.repository.StudentRepository;
import com.google.gson.Gson;

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
