package concerttours.service;

import java.util.List;

import concerttours.model.StudentModel;

public interface StudentService
{
	/**
	 * Gets all bands in the system.
	 *
	 * @return all bands in the system
	 */
	List<StudentModel> getStudents();

	/**
	 */
	StudentModel getStudentForCode(String code);
}
