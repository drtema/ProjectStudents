package com.drtema.daointerfaces;

import com.drtema.mainclasses.Course;
import com.drtema.mainclasses.Student;

/**
 * Created by Dr.tema on 08.04.17.
 */
public interface CoursesDAO {
    void add(Course course);
    Course find(int courseID);
    void view(int courseID);
    void viewAllNames();
    void viewAllStudents(int courseID);
    void addStudent(int courseID,int studentID);
    void addTrainer(int courseID,int trainerID);

}
