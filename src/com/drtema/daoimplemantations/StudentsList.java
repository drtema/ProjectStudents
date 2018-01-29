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
    public Student find(int studentID) throws NullPointerException {
        for (Student student:studentList) {
            if (studentID == student.getStudentID()) {
                return student;
            }
        }
        throw new NullPointerException("Student with id " + studentID + " doesn’t exist");
    }

    @Override
    public void view(int studentID) {
        try {
            System.out.println(find(studentID));
        } catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
    }

        

    @Override
    public int getSize() {
        return studentList.size();
    }
    @Override
    public void close() {
        studentList.clear();
    }
}
