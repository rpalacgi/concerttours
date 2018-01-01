package concerttours.service.impl;

import de.hybris.platform.servicelayer.exceptions.AmbiguousIdentifierException;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;

import java.util.List;

import org.springframework.beans.factory.annotation.Required;

import concerttours.daos.StudentDAO;
import concerttours.model.StudentModel;
import concerttours.service.StudentService;


public class DefaultStudentService implements StudentService
{
	private StudentDAO studentDAO;

	/**
	 */
	@Override
	public List<StudentModel> getStudents()
	{
		return studentDAO.findStudents();
	}

	/**
	 */
	@Override
	public StudentModel getStudentForCode(final String code) throws AmbiguousIdentifierException, UnknownIdentifierException
	{
		final List<StudentModel> result = studentDAO.findStudentsByCode(code);
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
	public void setStudentDAO(final StudentDAO studentDAO)
	{
		this.studentDAO = studentDAO;
	}
}