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

        outer: do{
            System.out.println(
                    "\nAvailable commands: " +
                            "\naddCourse - 1" +
                            "\nshowCourse - 2" +
                            "\nviewAllCoursesNames - 3" +
                            "\naddTrainer - 4" +
                            "\nviewTrainer - 5" +
                            "\nexit - 0");
            switch (scanner.next()){
                case "1":
                    CourseInterface.setInputType("1");
                    CourseInterface.courseAdd();
                    break;
                case "2":
                    Integer id;
                    System.out.println("Enter the course id: ");

                        if(!scanner.hasNextInt()){
                            System.out.println("invalid input!\n");
                            continue outer;
                        }
                    try {
                        id = scanner.nextInt();
                        CourseInterface.viewCourse(id);
                    } catch (NullPointerException e){
                            continue outer;
                    }
                    break;
                case "3":
                    CourseInterface.viewAllCoursesNames();
                    break;
                case "4":
                    CourseInterface.addTrainer();
                    break;
                case "5":
                    System.out.println("Enter the trainer id: ");
                    if(!scanner.hasNextInt()){
                        System.out.println("invalid input!\n");
                        continue outer;
                    }
                    try {
                        id = scanner.nextInt();

                        CourseInterface.viewTrainer(id);
                    } catch (NullPointerException e){
                        continue outer;
                    }
                    break;
                case "0":
                    break outer;
                default:
                    System.out.println("invalid command!");
                    continue outer;
            }
        } while(true);
        CourseInterface.viewAllCoursesNames();
    }

}
