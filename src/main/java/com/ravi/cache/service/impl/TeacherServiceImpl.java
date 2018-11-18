package com.ravi.cache.service.impl;

import com.ravi.cache.service.TeacherService;
import com.ravi.dto.Teacher;
import com.ravi.dto.Teachers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ravi Goka on 11/18/2018.
 */
@Component
public class TeacherServiceImpl implements TeacherService {
    private static final Logger LOG = LoggerFactory.getLogger(TeacherServiceImpl.class);
    @Override
    public Teachers getAllTeachers() {
        if(LOG.isDebugEnabled()){
            LOG.debug("START :: Getting all teachers");
        }
        Teacher teacher1 = new Teacher();
        teacher1.setId(12736);
        teacher1.setGrade("First Grade");
        teacher1.setSubject("General Science");
        teacher1.setFirstName("John");
        teacher1.setLastName("Davis");

        Teacher teacher2 = new Teacher();
        teacher2.setId(473782);
        teacher2.setGrade("Second Grade");
        teacher2.setSubject("Mathematics");
        teacher2.setFirstName("Donald");
        teacher2.setLastName("Trump");


        Teacher teacher3 = new Teacher();
        teacher3.setId(57383);
        teacher3.setGrade("Third Grade");
        teacher3.setSubject("English");
        teacher3.setFirstName("George");
        teacher3.setLastName("Bush");

        List<Teacher> teachers = new ArrayList<>();
        teachers.add(teacher1);
        teachers.add(teacher2);
        teachers.add(teacher3);

        Teachers allTeachers = new Teachers(teachers);
        if(LOG.isDebugEnabled()){
            LOG.debug("END :: Getting all teachers: {}", allTeachers);
        }
        return allTeachers;
    }
}
