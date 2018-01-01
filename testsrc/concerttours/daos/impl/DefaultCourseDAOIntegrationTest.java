package concerttours.daos.impl;

import static org.junit.Assert.assertTrue;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.servicelayer.ServicelayerTransactionalTest;
import de.hybris.platform.servicelayer.model.ModelService;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import concerttours.daos.CourseDAO;
import concerttours.model.CourseModel;


/**
 * The purpose of this test is to illustrate DAO best practices and behaviour.
 *
 * The DAO logic is factored into a separate POJO. Stepping into these will illustrate how to write and execute
 * FlexibleSearchQueries - the basis on which most hybris DAOs operate.
 */
@IntegrationTest
public class DefaultCourseDAOIntegrationTest extends ServicelayerTransactionalTest
{
	/** As this is an integration test, the class (object) being tested gets injected here. */
	@Resource
	private CourseDAO courseDAO;
	/** Platform's ModelService used for creation of test data. */
	@Resource
	private ModelService modelService;
	/** Name of test band. */
	private static final String COURSE_CODE = "ROCK-11";
	/** Name of test band. */
	private static final String COURSE_NAME = "Ladies of Rock";

	@Test
	public void bandDAOTest()
	{
		// check that our test band is not already present in the database
		List<CourseModel> coursesByCode = courseDAO.findCoursesByCode(COURSE_CODE);
		assertTrue("No Band should be returned", coursesByCode.isEmpty());
		// retrieve all bands currently in the database
		List<CourseModel> allCourses = courseDAO.findCourses();
		final int size = allCourses.size();
		// add our test band to the database
		final CourseModel courseModel = modelService.create(CourseModel.class);
		courseModel.setCode(COURSE_CODE);
		courseModel.setCname(COURSE_NAME);
		modelService.save(courseModel);
		// check we now get one more band back than previously and our test band is in the list
		allCourses = courseDAO.findCourses();
		Assert.assertEquals(size + 1, allCourses.size());
		Assert.assertTrue("band not found", allCourses.contains(courseModel));
		// check we can locate our test band by its code
		coursesByCode = courseDAO.findCoursesByCode(COURSE_CODE);
		Assert.assertEquals("Did not find the Band we just saved", 1, coursesByCode.size());
	}

	@Test
	public void testFindBands_EmptyStringParam()
	{
		//calling findBandsByCode() with an empty String - returns no results
		final List<CourseModel> courses = courseDAO.findCoursesByCode("");
		Assert.assertTrue("No Band should be returned", courses.isEmpty());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testfindBands_NullParam()
	{
		//calling findBandByCode with null should throw an IllegalArgumentException
		courseDAO.findCoursesByCode(null); //method's return value not captured
    }
}