package com.drtema.daointerfaces;

import com.drtema.mainclasses.Course;
import com.drtema.mainclasses.Student;

/**
 * Created by Dr.tema on 08.04.17.
 */
public interface CoursesDAO {
    void add(Course course);
    void view(int courseID);
    void viewAllNames();
    Course find(int courseID);
    int getSize();
    void close();
}
