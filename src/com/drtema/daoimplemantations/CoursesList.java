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
    public void find(int courseID) {

    }

    @Override
    public void view(int courseID) {

    }

    @Override
    public void viewAllNames() {

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
