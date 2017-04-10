package com.drtema.daoimplemantations;

import com.drtema.daointerfaces.CoursesDAO;
import com.drtema.mainclasses.Course;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Dr.tema on 08.04.17.
 */
public class CoursesList implements CoursesDAO {



    private static List<Course> courses = new ArrayList<>();

    public static List<String> getCoursesNames() {

        List<String> coursesNames = new ArrayList();
        for (Course course : courses) {
            coursesNames.add(course.getCourseName());
        }
        return coursesNames;
    }

    @Override
    public void add(Course course) {
        courses.add(course);
    }

    @Override
    public Course find(int courseID) throws NullPointerException {
        for (Course course:courses) {
            if (courseID == course.getCourseID()) {
                return course;
            }
        }
        throw new NullPointerException("Course with id " + courseID + " doesn’t exist");
    }

    @Override
    public void view(int courseID) {
        try {

            System.out.println(find(courseID));
        } catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void viewAllNames() {

        if (courses.size() == 0) {
            System.out.println("No courses available yet");
        } else {
            for (Course course : courses) {
                System.out.println(course.getCourseName() + " (id:" + course.getCourseID() + ")");
            }
        }

    }

    @Override
    public int getSize() {
        return courses.size();
    }

}
