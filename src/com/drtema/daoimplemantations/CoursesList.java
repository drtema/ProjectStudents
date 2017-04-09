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

    public Course find(int courseID) {
        for (Course course:courses) {
            if (courseID == course.getCourseID()) {
                return course;
            }
        }
        return null;
    }

    @Override
    public void view(int courseID) {
        if(find(courseID) == null) {
            System.out.println("Course with id " + courseID + " doesn’t exist");
        } else
        System.out.println(find(courseID));
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
    public void viewAllStudents(int courseID) {

    }

    @Override
    public void addStudent(int courseID, int studentID) {

    }


}
