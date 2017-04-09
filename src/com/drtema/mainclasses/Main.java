package com.drtema.mainclasses;

import com.drtema.daoimplemantations.CoursesList;
import com.drtema.daointerfaces.CoursesDAO;
import com.drtema.userinterfaces.CourseInterface;

/**
 * Created by Dr.tema on 08.04.17.
 */
public class Main {
    public static void main(String... args){
//        Course course1 = new Course(
//                "Java for Beginners",
//                "Course for people that want learn Java programming language",
//                "2017.03.10",
//                "2017.05.10",
//                "MON","WED","FRI");

       // System.out.println(course1);

        CoursesDAO coursesDate = new CoursesList();

        coursesDate.add(CourseInterface.courseAdd());

        coursesDate.view(1);

        coursesDate.viewAllNames();
    }
}
