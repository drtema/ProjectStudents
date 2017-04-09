package com.drtema.daoimplemantations;

import com.drtema.daointerfaces.CoursesDAO;
import com.drtema.mainclasses.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Dr.tema on 08.04.17.
 */
public class CoursesList implements CoursesDAO {

    List<Course> courses = new ArrayList();

    @Override
    public void add(Course course) {
        courses.add(course);
    }

    @Override
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
        } else
        for (Course course : courses) {
            System.out.println(course.getCourseName());
        }

    }

    @Override
    public void viewAllStudents(int courseID) {

    }

    @Override
    public void addStudent(int courseID, int studentID) {

    }

    @Override
    public void addTrainer(int courseID, int trainerID) {

    }
}
