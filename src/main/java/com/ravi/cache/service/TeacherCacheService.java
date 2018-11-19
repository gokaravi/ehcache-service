package com.ravi.cache.service;

import com.ravi.dto.Teachers;

/**
 * Created by Ravi Goka on 11/18/2018.
 */
public interface TeacherCacheService {
	
	/**
	 * Method to get the details of all the teachers
	 * @return Teachers
	 */
    Teachers getAllTeachers();
}
