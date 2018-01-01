package concerttours.facades;

import java.util.List;

import concerttours.data.StudentData;


public interface StudentFacade
{
	StudentData getStudent(String name);

	List<StudentData> getStudents();
}