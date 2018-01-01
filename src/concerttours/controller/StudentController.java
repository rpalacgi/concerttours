package concerttours.controller;
import de.hybris.platform.catalog.CatalogVersionService;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import concerttours.data.StudentData;
import concerttours.facades.StudentFacade;


@Controller
public class StudentController
{

	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
    private static final String CATALOG_ID = "concertoursProductCatalog";
    private static final String CATALOG_VERSION_NAME = "Online";
    private CatalogVersionService catalogVersionService;
	private StudentFacade studentFacade;

	@RequestMapping(value = "/students")
    public String showBands(final Model model)
    {
		logger.debug("showBands Called");
		final List<StudentData> students = studentFacade.getStudents();
        model.addAttribute("students", students);
        return "StudentList";
    }

	@RequestMapping(value = "/students/{studentId}")
	public String showBandDetails(@PathVariable final String studentId, final Model model) throws UnsupportedEncodingException
    {
        catalogVersionService.setSessionCatalogVersion(CATALOG_ID, CATALOG_VERSION_NAME);
		final String decodedBandId = URLDecoder.decode(studentId, "UTF-8");
		final StudentData student = studentFacade.getStudent(decodedBandId);
		student.setFname(student.getFname());
		model.addAttribute("student", student);
		return "StudentDetails";
    }
    @Autowired
    public void setCatalogVersionService(final CatalogVersionService catalogVersionServiceService)
    {
        this.catalogVersionService = catalogVersionServiceService;
    }
    @Autowired
	public void setFacade(final StudentFacade facade)
    {
		this.studentFacade = facade;
    }
}