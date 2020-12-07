package com.app.samples.springboot.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.samples.springboot.entity.Student;
import com.app.samples.springboot.repository.StudentRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class StudentUtil.
 */
@Service
public class StudentUtil {

	/** The student repository. */
	@Autowired
	private StudentRepository studentRepository;
	
	/**
	 * Existing student.
	 *
	 * @param studentId the student id
	 * @return the student
	 */
	public Student existingStudent(Long studentId) {
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
}
