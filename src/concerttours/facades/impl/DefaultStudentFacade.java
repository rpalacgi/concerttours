package concerttours.facades.impl;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Required;

import concerttours.data.StudentData;
import concerttours.facades.StudentFacade;
import concerttours.model.StudentModel;
import concerttours.service.StudentService;


public class DefaultStudentFacade implements StudentFacade
{
	private StudentService studentService;

	@Override
	public List<StudentData> getStudents()
	{
		final List<StudentModel> studentModels = studentService.getStudents();
		final List<StudentData> studentFacadeData = new ArrayList<>();
		for (final StudentModel sm : studentModels)
		{
			final StudentData sfd = new StudentData();
			sfd.setId(sm.getCode());
			sfd.setFname(sm.getFname());
			studentFacadeData.add(sfd);
		}
		return studentFacadeData;
	}

	@Override
	public StudentData getStudent(final String name)
	{
		if (name == null)
		{
			throw new IllegalArgumentException("Band name cannot be null");
		}
		final StudentModel student = studentService.getStudentForCode(name);
		if (student == null)
		{
			return null;
		}

		final StudentData bandData = new StudentData();
		bandData.setId(student.getCode());
		bandData.setFname(student.getFname());
		return bandData;
	}

	@Required
	public void setStudentService(final StudentService studentService)
	{
		this.studentService = studentService;
	}

}