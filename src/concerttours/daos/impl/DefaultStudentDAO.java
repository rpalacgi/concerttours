package concerttours.daos.impl;

import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.TranslationResult;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import concerttours.daos.StudentDAO;
import concerttours.model.StudentModel;


@Component(value = "studentDAO")
public class DefaultStudentDAO implements StudentDAO
{
	/**
	 * Use Hybris FlexibleSearchService for running queries against the database
	 */
	@Autowired
	private FlexibleSearchService flexibleSearchService;
	private TranslationResult result;
	private static final Logger logger = LoggerFactory.getLogger(DefaultStudentDAO.class);

	/**
	 * Finds all Students by performing a FlexibleSearch using the {@link FlexibleSearchService}.
	 */
   @Override
	public List<StudentModel> findStudents()
   {
        // Build a query for the flexible search.
        final String queryString =
				"SELECT {p:" + StudentModel.PK + "} "//
						+ "FROM {" + StudentModel._TYPECODE + " AS p} ";

		final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);
		//result = flexibleSearchService.translate(query);
		//logger.info("SQL Query : " + result.getSQLQuery());
		//logger.info("SQL Query Parameter : " + result.getSQLQueryParameters());
		  return flexibleSearchService.<StudentModel> search(query).getResult();
   }

	/**
	 * Finds all Students by given code by performing a FlexibleSearch using the {@link FlexibleSearchService}.
	 */
	@Override
	public List<StudentModel> findStudentsByCode(final String code)
    {
        final String queryString =
				"SELECT {p: " + StudentModel.PK + "}" //
						+ "FROM {" + StudentModel._TYPECODE + " AS p} "//
						+ "WHERE " + "{p: " + StudentModel.CODE + " }=?code ";
        final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);
		query.addQueryParameter("code", code);
		result = flexibleSearchService.translate(query);
		logger.info("SQL Query : " + result.getSQLQuery());
		logger.info("SQL Query Parameter : " + result.getSQLQueryParameters());
        return flexibleSearchService.<StudentModel> search(query).getResult();
    }
}