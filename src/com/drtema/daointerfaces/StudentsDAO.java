package com.drtema.daointerfaces;

import com.drtema.mainclasses.Student;

/**
 * Created by Dr.tema on 08.04.17.
 */
public interface StudentsDAO {
    void add(Student student);
    void transfer(int studentID,int courseIDToEnroll, int courseIDToExpel);
    void find(int studentID);
    void view(int StudentID);
}
