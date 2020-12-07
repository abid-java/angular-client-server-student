package com.app.samples.springboot.service;

import java.io.InputStream;

import com.app.samples.springboot.entity.Student;

// TODO: Auto-generated Javadoc
/**
 * The Interface IStudentService.
 */
public interface IStudentService {

	/**
	 * Read excel and save it.
	 *
	 * @param inputStream the input stream
	 */
	public Student readExcelAndSaveIt(InputStream inputStream);
}
