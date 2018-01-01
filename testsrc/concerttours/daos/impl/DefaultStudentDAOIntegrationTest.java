package concerttours.daos.impl;

import static org.junit.Assert.assertTrue;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.servicelayer.ServicelayerTransactionalTest;
import de.hybris.platform.servicelayer.model.ModelService;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import concerttours.daos.StudentDAO;
import concerttours.model.StudentModel;


/**
 * The purpose of this test is to illustrate DAO best practices and behaviour.
 *
 * The DAO logic is factored into a separate POJO. Stepping into these will illustrate how to write and execute
 * FlexibleSearchQueries - the basis on which most hybris DAOs operate.
 */
@IntegrationTest
public class DefaultStudentDAOIntegrationTest extends ServicelayerTransactionalTest
{
	/** As this is an integration test, the class (object) being tested gets injected here. */
	@Resource
	private StudentDAO studentDAO;
	/** Platform's ModelService used for creation of test data. */
	@Resource
	private ModelService modelService;
	/** Name of test band. */
	private static final String STUDENT_CODE = "A1";
	/** Firstname of Student */
	private static final String STUDENT_FNAME = "Mohammed";
	/** Lastname of Student. */
	private static final String STUDENT_LNAME = "Parikh";

	@Test
	public void studentDAOTest()
	{

		// retrieve all bands currently in the database
		List<StudentModel> allStudents = studentDAO.findStudents();
		final int size = allStudents.size();

		// check that our test band is not already present in the database
		List<StudentModel> studentsByCode = studentDAO.findStudentsByCode(STUDENT_CODE);
		assertTrue("No Student should be returned", studentsByCode.isEmpty());

		// add our test band to the database
		final StudentModel studentModel = modelService.create(StudentModel.class);
		studentModel.setCode(STUDENT_CODE);
		studentModel.setFname(STUDENT_FNAME);
		studentModel.setLname(STUDENT_LNAME);
		modelService.save(studentModel);
		// check we now get one more student back than previously and our test band is in the list
		allStudents = studentDAO.findStudents();
		Assert.assertEquals(size + 1, allStudents.size());
		Assert.assertTrue("band not found", allStudents.contains(studentModel));
		// check we can locate our test band by its code
		studentsByCode = studentDAO.findStudentsByCode(STUDENT_CODE);
		Assert.assertEquals("Did not find the student we just saved", 1, studentsByCode.size());
		Assert.assertEquals("Retrieved Student code attribute incorrect", STUDENT_CODE, studentsByCode.get(0).getCode());
		Assert.assertEquals("Retrieved Students firstname attribute incorrect", STUDENT_FNAME, studentsByCode.get(0).getFname());
		Assert.assertEquals("Retrieved Students lastname attribute incorrect", STUDENT_LNAME, studentsByCode.get(0).getLname());
	}

	@Test
	public void testFindStudents_EmptyStringParam()
	{
		//calling findBandsByCode() with an empty String - returns no results
		final List<StudentModel> students = studentDAO.findStudentsByCode("");
		Assert.assertTrue("No Students should be returned", students.isEmpty());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testfindBands_NullParam()
	{
		//calling findBandByCode with null should throw an IllegalArgumentException
		studentDAO.findStudentsByCode(null); //method's return value not captured
    }
}