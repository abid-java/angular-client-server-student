package com.app.samples.springboot.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.samples.springboot.entity.Student;
import com.app.samples.springboot.exception.ResourceNotFoundException;
import com.app.samples.springboot.repository.StudentDAO;
import com.app.samples.springboot.repository.StudentRepository;
import com.app.samples.springboot.util.StudentUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class StudentController.
 */
@RestController
@RequestMapping("/students")
public class StudentController {
	
	/** The class name. */
	private final String CLASS_NAME = "StudentController";
	
	/** The logger. */
	Logger logger = Logger.getLogger(StudentController.class.getName());
	
	/** The student repository. */
	@Autowired
	private StudentRepository studentRepository;
	
	/** The student util. */
	@Autowired
	private StudentUtil studentUtil;
	
	@Autowired
	private StudentDAO studentDao;
	
	/**
	 * Creates the student.
	 *
	 * @param student the student
	 * @return the response entity
	 */
	//API to create resource - POST Method
	@PostMapping("/createStudent")
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
		String METHOD_NAME = "createStudent";
		logger.info("<<===== executing " + METHOD_NAME + " in " + CLASS_NAME +" =====>>");
		Student savedStudent = null;
		ResponseEntity<Student> responseEntity = null;
		if(student != null) {
			logger.info("creating student : " + student.toString());
			logger.info("student's address : " + student.getAddress().toString());
			savedStudent = studentRepository.save(student);			
			if(savedStudent != null) {
				responseEntity = ResponseEntity.ok().body(savedStudent);
			} else {
				throw new DataAccessResourceFailureException("Error Connecting Database");
			}
		}
		return responseEntity;
	}
	
	/**
	 * Gets the all students.
	 *
	 * @return the all students
	 */
	//API to get all the resources - GET Method
	@GetMapping("/getAllStudents")
	public ResponseEntity<List<Student>> getAllStudents() {
		String METHOD_NAME = "getAllStudents";
		logger.info("<<===== executing " + METHOD_NAME + " in " + CLASS_NAME +" =====>>");
		ResponseEntity<List<Student>> responseEntity = null;
		List<Student> studentsList = studentRepository.findAll();
		if(studentsList.size() > 0) {
			responseEntity = ResponseEntity.ok().body(studentsList);
		} else {
			throw new ResourceNotFoundException("No Records Found : ");
		}
		return responseEntity;
	}
	

	/**
	 * Gets the student by id.
	 *
	 * @param studentId the student id
	 * @return the student by id
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	//API to get student - GET Method
	@GetMapping("/{studentId}")
	public ResponseEntity<Student> getStudentById(@PathVariable("studentId") Long studentId) throws ResourceNotFoundException{
		String METHOD_NAME = "getStudentById";
		logger.info("<<===== executing " + METHOD_NAME + " in " + CLASS_NAME +" =====>>");
		ResponseEntity<Student> responseEntity = null;
		Student existingStudent = studentUtil.existingStudent(studentId);
		if(existingStudent != null) {
			responseEntity = ResponseEntity.ok().body(existingStudent);
		} else {
			throw new ResourceNotFoundException("Student Not Found with Id : " + studentId);
		}
		return responseEntity;
	}
	
	
	/**
	 * Update student.
	 *
	 * @param newStudent the new student
	 * @param studentId the student id
	 * @return the response entity
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@PutMapping("/{studentId}")
	public ResponseEntity<Student> updateStudent(@RequestBody Student newStudent, @PathVariable("studentId") Long studentId) throws ResourceNotFoundException {
		String METHOD_NAME = "updateStudent";
		logger.info("<<===== executing " + METHOD_NAME + " in " + CLASS_NAME +" =====>>");
		ResponseEntity<Student> responseEntity = null;
		Student studentToUpdate = studentUtil.existingStudent(studentId);
		if(studentToUpdate != null) {
			studentToUpdate = studentDao.updateStudent(newStudent);
			responseEntity = ResponseEntity.ok().body(studentToUpdate);
		} else {
			throw new ResourceNotFoundException("Student Not Found with Id : " + studentId);
		}
		return responseEntity;		
	}
	
}
