package concerttours.service.impl;

import de.hybris.platform.servicelayer.exceptions.AmbiguousIdentifierException;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;

import java.util.List;

import org.springframework.beans.factory.annotation.Required;

import concerttours.daos.BandDAO;
import concerttours.daos.CourseDAO;
import concerttours.model.CourseModel;
import concerttours.service.CourseService;


public class DefaultCourseService implements CourseService
{
	private CourseDAO courseDAO;

	/**
	 * Gets all bands by delegating to {@link BandDAO#findBands()}.
	 */
	@Override
	public List<CourseModel> getCourses()
	{
		return courseDAO.findCourses();
	}

	/**
	 * Gets all bands for given code by delegating to {@link BandDAO#findBandsByCode(String)} and then assuring uniqueness
	 * of result.
	 */
	@Override
	public CourseModel getCourseForCode(final String code) throws AmbiguousIdentifierException, UnknownIdentifierException
	{
		final List<CourseModel> result = courseDAO.findCoursesByCode(code);
		if (result.isEmpty())
		{
			throw new UnknownIdentifierException("Band with code '" + code + "' not found!");
		}
		else if (result.size() > 1)
		{
			throw new AmbiguousIdentifierException("Band code '" + code + "' is not unique, " + result.size() + " bands found!");
		}
		return result.get(0);
	}

	@Required
	public void setBandDAO(final CourseDAO courseDAO)
	{
		this.courseDAO = courseDAO;
	  }
}