package com.drtema.mainclasses;

import com.drtema.userinterfaces.CourseInterface;

import java.util.Scanner;

/**
 * Created by Dr.tema on 08.04.17.
 */
public class Main {
    public static void main(String... args){

        Scanner scanner = new Scanner(System.in);

        boolean flag;

        System.out.println("Please add new course");
        String input;
        do {

            System.out.println("Please set input type(1 - console/2 - file): ");
            input = scanner.nextLine();
        } while(!input.equals("2")&&!input.equals("1"));

        CourseInterface.setInputType(input);

        if (CourseInterface.isInputType()) {
            do {
                CourseInterface.courseAdd();
                System.out.println("Do you want to add 1 more course?(1 - YES/anykey - NO): ");
                flag = scanner.next().equals("1");
            } while (flag);
        } else {
            CourseInterface.courseAdd();
            CourseInterface.courseAdd();
            CourseInterface.courseAdd();
        }

//        do{
//            System.out.println(
//                    "Available commands: " +
//                            "addCourse - 1");
//        } while(flag);
        CourseInterface.viewAllCoursesNames();
    }
}
