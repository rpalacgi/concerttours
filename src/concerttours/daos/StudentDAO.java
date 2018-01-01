/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2017 SAP SE
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * Hybris ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with SAP Hybris.
 */
package concerttours.daos;
import java.util.List;

import concerttours.model.StudentModel;

/**
 *
 */
public interface StudentDAO
{
	/**
	 * Return a list of band models that are currently persisted. If none are found an empty list is returned.
	 *
	 * @return all the bands in the system
	 */
	List<StudentModel> findStudents();
	/**
	 */
	List<StudentModel> findStudentsByCode(String code);
}
