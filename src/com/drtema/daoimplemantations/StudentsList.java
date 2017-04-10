package com.drtema.daoimplemantations;

import com.drtema.daointerfaces.StudentsDAO;
import com.drtema.mainclasses.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dr.tema on 08.04.17.
 */
public class StudentsList implements StudentsDAO {

    private static List<Student> studentList = new ArrayList<>();

    @Override
    public void add(Student student) {
        studentList.add(student);
    }

    @Override
    public Student find(int studentID) {
        for (Student student:studentList) {
            if (studentID == student.getStudentID()) {
                return student;
            }
        }
        return null;
    }

    @Override
    public void view(int studentID) {
        if(find(studentID) == null) {
            System.out.println("Trainer with id " + studentID + " doesn’t exist");
        } else
            System.out.println(find(studentID));
    }

    public static List<String> getStudentsFirstNames() {

        List<String> students1stNames = new ArrayList();
        for (Student course : studentList) {
            students1stNames.add(course.getFirstName());
        }
        return students1stNames;
    }

    public static List<String> getStudentsLastNames() {

        List<String> studentsLastNames = new ArrayList();
        for (Student course : studentList) {
            studentsLastNames.add(course.getLastName());
        }
        return studentsLastNames;
    }

    @Override
    public int getSize() {
        return studentList.size();
    }
}
