package concerttours.service.impl;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.servicelayer.ServicelayerTest;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import de.hybris.platform.servicelayer.model.ModelService;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;

import concerttours.model.StudentModel;
import concerttours.service.StudentService;

@IntegrationTest
public class DefaultStudentServiceIntegrationTest extends ServicelayerTest
{
    @Resource
	private StudentService studentService;
    @Resource
	private ModelService modelService;
    /** Test band */
	private StudentModel studentModel;
    /** Name of test band. */
	private static final String STUDENT_CODE = "A1";
    /** Name of test band. */
	private static final String STUDENT_FNAME = "Sakshi";
    /** History of test band. */
	private static final String STUDENT_LNAME = "Parikh";
    @Before
    public void setUp()
    {
        // This instance of a BandModel will be used by the tests
		studentModel = modelService.create(StudentModel.class);
		studentModel.setCode(STUDENT_CODE);
		studentModel.setFname(STUDENT_FNAME);
		studentModel.setLname(STUDENT_LNAME);
    }

    @Test(expected = UnknownIdentifierException.class)
    public void testFailBehavior()
    {
		studentService.getStudentForCode(STUDENT_CODE);
    }
    /**
     * This test tests and demonstrates that the Service's getAllBand method calls the DAOs' getAllBand method and
     * returns the data it receives from it.
     */
    @Test
	public void testStudentService()
    {
		List<StudentModel> studentModels = studentService.getStudents();
		final int size = studentModels.size();
		modelService.save(studentModel);
		studentModels = studentService.getStudents();
		assertEquals(size + 1, studentModels.size());
		assertEquals("Unexpected band found", studentModel, studentModels.get(studentModels.size() - 1));
		final StudentModel persistedStudentModel = studentService.getStudentForCode(STUDENT_CODE);
		assertNotNull("No band found", persistedStudentModel);
		assertEquals("Different band found", studentModel, persistedStudentModel);
    }

    /**
     * This test tests and demonstrates that the Service's getAllBand method calls the DAOs' getAllBand method and
     * returns the data it receives from it.
     */
    @Test
    public void testBandServiceTours() throws Exception
    {
		createCoreData();
		importCsv("/impex/concerttours-students.impex", "UTF-8");

		//TODO: Write a Service for Enrollments

		//final StudentModel student = studentService.getStudentForCode("A001");
		//assertNotNull("No band found", student);
		//final Set<ProductModel> tours = student.get
		//  assertNotNull("No tour found", tours);
		//  Assert.assertEquals("not found one tour", 1, tours.size());
		//  final Object[] objects = new Object[5];
		//  final Collection<VariantProductModel> concerts = ((ProductModel) tours.toArray(objects)[0]).getVariants();
		//  assertNotNull("No tour found", tours);
		//  Assert.assertEquals("not found one tour", 6, concerts.size());
    }
}