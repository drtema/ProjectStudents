package com.drtema.mainclasses;

import com.drtema.userinterfaces.CourseInterface;

import java.util.Scanner;

/**
 * Realized UI and command input
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
            try {

                CourseInterface.courseAdd();
                for (int i = 1; i < CourseInterface.getObjectCounter(); i++) {
                    CourseInterface.courseAdd();
                }

                CourseInterface.addTrainer();
                for (int i = 1; i < CourseInterface.getObjectCounter(); i++) {
                    CourseInterface.addTrainer();
                }

                CourseInterface.addStudent();
                for (int i = 1; i < CourseInterface.getObjectCounter(); i++) {
                    CourseInterface.addStudent();
                }

            } catch (Exception e){
                System.out.println("Wrong file format or path. Please input with the console.");
                CourseInterface.setInputType("1");
            }
        }

        outer: do{
            System.out.println(
                    "\nAvailable commands: " +
                            "\naddCourse - 1" +
                            "\nshowCourse - 2" +
                            "\nviewAllCoursesNames - 3" +
                            "\naddTrainer - 4" +
                            "\nviewTrainer - 5" +
                            "\naddStudent - 6" +
                            "\nviewStudent - 7" +
                            "\nstudentTransfer - 8" +
                            "\nviewAllCourseStudents - 9" +
                            "\naddTask - 10" +
                            "\naddMark - 11" +
                            "\nviewJournal - 12" +
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
                case "6":
                    CourseInterface.addStudent();
                    break;
                case "7":
                    System.out.println("Enter the student id: ");
                    if(!scanner.hasNextInt()){
                        System.out.println("invalid input!\n");
                        continue outer;
                    }
                    try {
                        id = scanner.nextInt();
                        CourseInterface.viewStudent(id);
                    } catch (NullPointerException e){
                        continue outer;
                    }
                    break;
                case "8":
                    int studentID;
                    int courseIDToEnroll;
                    int courseIDToExpel;
                    System.out.println("Enter the student id to transfer: ");
                    if(!scanner.hasNextInt()){
                        System.out.println("invalid input!\n");
                        continue outer;
                    }
                        studentID = scanner.nextInt();
                    System.out.println("Enter the course id to enroll: ");
                    if(!scanner.hasNextInt()){
                        System.out.println("invalid input!\n");
                        continue outer;
                    }
                        courseIDToEnroll = scanner.nextInt();
                    System.out.println("Enter the course id to expel: ");
                    if(!scanner.hasNextInt()){
                        System.out.println("invalid input!\n");
                        continue outer;
                    }
                        courseIDToExpel = scanner.nextInt();

                    try {
                        CourseInterface.transfer(studentID,courseIDToEnroll,courseIDToExpel);
                    } catch (NullPointerException e){
                        continue outer;
                    }
                    break;
                case "9":
                    System.out.println("Enter the course id: ");
                    if(!scanner.hasNextInt()){
                        System.out.println("invalid input!\n");
                        continue outer;
                    }
                    try {
                        id = scanner.nextInt();
                        CourseInterface.viewStudentsNames(id);
                    } catch (NullPointerException e){
                        continue outer;
                    }
                case "10":
                    CourseInterface.addTask();
                    break;
                case "11":
                    CourseInterface.addMark();
                    break;
                case "12":
                    System.out.println("Enter the course id: ");

                    if(!scanner.hasNextInt()){
                        System.out.println("invalid input!\n");
                        continue outer;
                    }
                    try {
                        id = scanner.nextInt();
                        CourseInterface.viewJournal(id);
                    } catch (NullPointerException e){
                        continue outer;
                    }
                    break;
                case "0":
                    CourseInterface.exit();
                    break outer;
                default:
                    System.out.println("invalid command!");
                    break;
            }
        } while(true);
        CourseInterface.viewAllCoursesNames();
    }

}
