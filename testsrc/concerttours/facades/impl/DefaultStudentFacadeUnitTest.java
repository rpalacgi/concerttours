package concerttours.facades.impl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import de.hybris.bootstrap.annotations.UnitTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import concerttours.data.StudentData;
import concerttours.model.StudentModel;
import concerttours.service.StudentService;


@UnitTest
public class DefaultStudentFacadeUnitTest
{
	private DefaultStudentFacade studentFacade;
	private StudentService studentService;
	private static final String BAND_CODE = "ROCK-11";
	private static final String BAND_NAME = "Ladies of Rock";

	// Convenience method for returning a list of Band
	private List<StudentModel> dummyDataBandList()
	{
		final List<StudentModel> students = new ArrayList<StudentModel>();
		final StudentModel student = configTestBand();
		students.add(student);
		return students;
	}

	// Convenience method for returning the configured test band
	private StudentModel configTestBand()
	{
		final StudentModel student = new StudentModel();
		student.setCode(BAND_CODE);
		student.setFname(BAND_NAME);
		return student;
	}

	@Before
	public void setUp()
	{
		// We will be testing the POJO DefaultBandFacade - the implementation of the BandFacade interface.
		studentFacade = new DefaultStudentFacade();
		studentService = mock(StudentService.class);
		// We then wire this service into the BandFacade implementation.
		studentFacade.setStudentService(studentService);
	}

	/**
	 * The aim of this test is to test that:
	 *
	 * 1) The facade's method getBands makes a call to the BandService's method getBands
	 *
	 * 2) The facade then correctly wraps BandModels that are returned to it from the BandService's getBands into Data
	 * Transfer Objects of type BandData.
	 */
	//Will fail bec of localization
	@Test
	public void testGetAllBands()
	{
		/**
		 * We instantiate an object that we would like to be returned to BandFacade when the mocked out BandService's method
		 * getBands is called. This will be a list of two BandModels.
		 */
		final List<StudentModel> students = dummyDataBandList();
		// create test band for the assert comparison
		final StudentModel student = configTestBand();
		// We tell Mockito we expect BandService's method getBands to be called, and that when it is, bands should be returned
		when(studentService.getStudents()).thenReturn(students);
		/**
		 * We now make the call to BandFacade's getBands. If within this method a call is made to BandService's getBands,
		 * Mockito will return the bands instance to it. Mockito will also remember that the call was made.
		 */
		final List<StudentData> dto = studentFacade.getStudents();
		// We now check that dto is a DTO version of bands..
		Assert.assertNotNull(dto);
		Assert.assertEquals(students.size(), dto.size());
		Assert.assertEquals(student.getCode(), dto.get(0).getId());
	}

	//Will fail bec of localization
	@Test
	public void testGetBand()
	{
		// create test band
		final StudentModel band = configTestBand();
		// We tell Mockito we expect BandService's method getBandForCode to be called, and that when it is, the test band should be returned
		when(studentService.getStudentForCode(BAND_CODE)).thenReturn(band);
		final StudentData dto = studentFacade.getStudent(BAND_CODE);
		// We now check that band is a correct DTO representation of the test band model
		Assert.assertNotNull(dto);
		Assert.assertEquals(band.getCode(), dto.getId());
	}
}