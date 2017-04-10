package com.drtema.mainclasses;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by Dr.tema on 08.04.17.
 */
public class Course {
    private static int coursesCounter = 0;
    private final int courseID;
    private final String courseName;
    private String courseDescription;
    private List<Integer> studentsIDs = new ArrayList<>();
    private int trainerID = 0;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<DayOfWeek> dayOfTheCourses = new LinkedList();

    public Course(
            String courseName,
            String courseDescription,
            String startDate,
            String endDate,
            String... dayOfTheCourses
    ) {
        this.courseID = ++coursesCounter;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.startDate = LocalDate.parse(startDate, DateTimeFormatter.ofPattern("yyyy.MM.dd"));
        this.endDate = LocalDate.parse(endDate, DateTimeFormatter.ofPattern("yyyy.MM.dd"));
        for (String x:dayOfTheCourses) {
            this.dayOfTheCourses.add(DayOfWeek.valueOf(x));
        }
    }

    public int getCourseID() {
        return courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setTrainerID(Integer trainer){
        this.trainerID = trainer;
    }

    public void addStudentID(Integer studentID) {
        if (studentsIDs.size() >= 12) {
            System.out.println("Course with id " + studentID + " already has 12 students");
        }
        else {
            this.studentsIDs.add(studentID);
        }
    }

    public void studentExpel(Integer studentID){
        for (Integer studentsID : studentsIDs) {
            if(studentID == studentsID){
                studentsIDs.remove(studentID);
                return;
            }
        }
        System.out.println("Student with id "+ studentID +" doesn’t exist");
    }

    public int getTrainerID() {
        return trainerID;
    }

    public int getStudentsListSize(){
        return studentsIDs.size();
    }

    public List<Integer> getStudentsIDs() {
        return studentsIDs;
    }

    @Override
    public String toString() {
        return
                "\ncourseID=" + courseID +
                "\ncourseName='" + courseName + '\'' +
                "\ncourseDescription='" + courseDescription + '\'' +
                "\nstartDate='" + startDate + '\'' +
                "\nendDate='" + endDate+ '\'' +
                "\ndayOfTheCourses=" + dayOfTheCourses
                ;
    }


}
