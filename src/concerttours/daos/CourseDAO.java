package concerttours.daos;

import java.util.List;

import concerttours.model.CourseModel;


/**
 * An interface for the Band DAO including various operations for retrieving persisted Band model objects
 */
public interface CourseDAO
{
	/**
	 * Return a list of band models that are currently persisted. If none are found an empty list is returned.
	 *
	 * @return all the bands in the system
	 */
	List<CourseModel> findCourses();

	/**
	 * Finds all bands with given code. If none is found, an empty list will be returned.
	 *
	 * @param code
	 *           the code to search for bands
	 * @return All bands with the given code.
	 */
	List<CourseModel> findCoursesByCode(String code);
}