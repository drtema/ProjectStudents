package com.drtema.mainclasses;

/**
 * Created by Dr.tema on 08.04.17.
 */
public class Main {
    public static void main(String... args){
        Course course1 = new Course("Java for Beginners",
                                    "Course for people that want learn Java programming language",
                                    "10.02.2017",
                                    "10.05.2017",
                                    "MONDAY","WEDNESDAY","FRIDAY");

        System.out.println(course1);
    }
}
