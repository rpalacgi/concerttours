package concerttours.daos.impl;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import concerttours.daos.CourseDAO;
import concerttours.model.CourseModel;


@Component(value = "courseDAO")
public class DefaultCourseDAO implements CourseDAO
{
    /**
    * Use Hybris FlexibleSearchService for running queries against the database
     */
    @Autowired
    private FlexibleSearchService flexibleSearchService;
    /**
     * Finds all Bands by performing a FlexibleSearch using the {@link FlexibleSearchService}.
     */
    @Override
	public List<CourseModel> findCourses()
    {
        // Build a query for the flexible search.
        final String queryString = //
				"SELECT {p:" + CourseModel.PK + "} "//
						+ "FROM {" + CourseModel._TYPECODE + " AS p} ";
        final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);
		return flexibleSearchService.<CourseModel> search(query).getResult();
    }
    /**
     * Finds all Bands by given code by performing a FlexibleSearch using the {@link FlexibleSearchService}.
     */
    @Override
	public List<CourseModel> findCoursesByCode(final String code)
    {
        final String queryString = //
				"SELECT {p:" + CourseModel.PK + "}" //
						+ "FROM {" + CourseModel._TYPECODE + " AS p} "//
						+ "WHERE " + "{p:" + CourseModel.CODE + "}=?code ";
        final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);
        query.addQueryParameter("code", code);
		return flexibleSearchService.<CourseModel> search(query).getResult();
    }
}