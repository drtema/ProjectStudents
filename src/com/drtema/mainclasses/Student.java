package com.drtema.mainclasses;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dr.tema on 08.04.17.
 */
public class Student {

    private static int studentsCounter = 0;
    private final int studentID;
    private final String firstName;
    private final String lastName;
    private final int age;
    private List<Integer> coursesID = new ArrayList();

    public Student(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.studentID = ++studentsCounter;

        for (Integer integer : coursesID) {
            this.coursesID.add(integer);
        }
    }

    public void setCourse(Integer courseID) {
        this.coursesID.add(courseID);
    }

    public List<Integer> getCoursesID() {
        return coursesID;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return
                "\nstudentID=" + studentID +
                "\nfirstName='" + firstName + '\'' +
                "\nlastName='" + lastName + '\'' +
                "\nage=" + age
                ;
    }
}
