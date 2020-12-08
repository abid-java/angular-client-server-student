package com.app.samples.springboot.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.app.samples.springboot.entity.Student;
import com.app.samples.springboot.util.StudentUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class StudentDAO.
 */
@Repository
public class StudentDAO {
	
	/** The class name. */
	private final String CLASS_NAME = "StudentDAO";

	/** The logger. */
	Logger logger = Logger.getLogger(StudentDAO.class.getName());
	
	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/** The student util. */
	@Autowired
	private StudentUtil studentUtil;
	
	/**
	 * Update student.
	 *
	 * @param student the student
	 * @return the student
	 */
	public Student updateStudent(Student student) {
		String METHOD_NAME = "updateStudent";
		logger.info("<<===== executing " + METHOD_NAME + " in " + CLASS_NAME +" =====>>");
		SimpleJdbcCall simpleJdbcCall = null;
		String jsonStudent = null;
		String jsonAddress = null;
		Map<String, Object> inParamMap = null;
		SqlParameterSource sqlParameterSource = null;
		Map<String, Object> simpleJdbcCallResult = null;
		try {
			inParamMap = new HashMap<String, Object>();
			simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("updatestudent");
			if(student != null) {
				jsonStudent = studentUtil.convertObjectToJson(student);
				jsonAddress = studentUtil.convertObjectToJson(student.getAddress());
				logger.info("v_student : " + jsonStudent);
				inParamMap.put("v_student", jsonStudent);//student json object
				logger.info("v_student_id : " + student.getStudentId());
				inParamMap.put("v_student_id", student.getStudentId()); //student id
				logger.info("v_address : " + jsonAddress);
				inParamMap.put("v_address", jsonAddress); //address json object
			}
			sqlParameterSource = new MapSqlParameterSource(inParamMap);
			simpleJdbcCallResult = simpleJdbcCall.execute(sqlParameterSource);
		}
		catch(DataAccessException dataAccessException ) {
			dataAccessException.printStackTrace();
		}
		return student;
	}
}
