package com.drtema.userinterfaces;

import com.drtema.daoimplemantations.CoursesList;
import com.drtema.daoimplemantations.StudentsList;
import com.drtema.daoimplemantations.TrainersList;
import com.drtema.daointerfaces.CoursesDAO;
import com.drtema.daointerfaces.StudentsDAO;
import com.drtema.daointerfaces.TrainersDAO;
import com.drtema.mainclasses.Course;
import com.drtema.mainclasses.Student;
import com.drtema.mainclasses.Trainer;


import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Dr.tema on 08.04.17.
 */
public class CourseInterface {

    private static TrainersDAO trainersData = new TrainersList();
    private static CoursesDAO coursesData = new CoursesList();
    private static StudentsDAO studentsData = new StudentsList();

    private static Scanner scanner = new Scanner(System.in);
    private static String fileName = "/Users/Dr.tema/Documents/projects/ProjectStudents/Courses.txt";
    private static Path path = Paths.get(fileName);
    private static boolean inputType = true;

    public static boolean isInputType() {
        return inputType;
    }

    public static void setInputType(String type){
        do {

            if(type.equals("2")) {
                try {
                    scanner = new Scanner(path);
                } catch (IOException e) {
                    System.out.println("Invalid Path or File");
                }
                inputType = false;
                break;
            }
            scanner = new Scanner(System.in);
            inputType = true;
            break;
        } while(true);
    }

    public static void courseAdd(){

        String name;

        outer: do {
            if (inputType)
                System.out.println("Enter the name of course: ");
            name = scanner.nextLine();
            for (String s : CoursesList.getCoursesNames()) {
                if (s.equals(name)) {
                    System.out.println("Course name should be unique. Please, enter another name");
                    continue outer;
                }
            }
            break;
        } while(true);

        if (inputType)
            System.out.println("Enter the description of course: ");
        String description = scanner.nextLine();

        Pattern datePattern = Pattern.compile("" +
                "(19|20)\\d\\d[. ,-:]((0[1-9]|1[012])" +
                "[. ,-:](0[1-9]|[12]\\d)|(0[13-9]|1[012])" +
                "[. ,-:]" +
                "30|(0[13578]|1[02])" +
                "[. ,-:]31)");
        Matcher dateMatcher;

        String startDate;
        do {
            if (inputType)
                System.out.println("Enter the start-date of course in format:'yyyy.mm.dd': ");
            startDate = scanner.nextLine();
            dateMatcher = datePattern.matcher(startDate);

            if (dateMatcher.matches() == false) {
                System.out.println("Invalid input!");
                continue;
            }
        } while (dateMatcher.matches() == false);

        String endDate;
        do {
            if (inputType)
                System.out.println("Enter the end-date of course in format:'yyyy.mm.dd': ");
            endDate = scanner.nextLine();
            dateMatcher = datePattern.matcher(endDate);
            if (dateMatcher.matches() == false) {
                System.out.println("Invalid input!");
                continue;
            }
        } while (dateMatcher.matches() == false);

        Pattern dayPattern = Pattern.compile("(((MON)|(TUE)|(WED)|(THU)|(FRI)|(SAT)|(SUN))[. ,-:]){0,6}((MON)|(TUE)|(WED)|(THU)|(FRI)|(SAT)|(SUN))");
        Matcher dayMatcher;
        Scanner dayScanner = null;

        do {
            if (inputType)
                System.out.println("Enter the days of course in format:'MON,TUE,...,SUN': ");
            String dayOfCourses = scanner.nextLine();
            dayMatcher = dayPattern.matcher(dayOfCourses);

            if (!dayMatcher.matches()) {
                System.out.println("Invalid input!");
                continue;
            } else
                dayScanner = new Scanner(dayOfCourses).useDelimiter("[. ,-:]");
        } while (!dayMatcher.matches());

        List<String> dayOfCourses1 = new ArrayList();

        while (dayScanner.hasNext()){
            dayOfCourses1.add(dayScanner.next());
        }

        String[] array = new String[dayOfCourses1.size()];

        Course course = new Course(name,description, startDate,endDate, dayOfCourses1.toArray(array));

        coursesData.add(course);

    }

    public static void addTrainer(){

        scanner = new Scanner(System.in);

        String firstName;
        String lastName ;
        outer: do {
            System.out.println("Enter the firstName of trainer: ");
            firstName = scanner.nextLine();
            for (int i = 1; i <= trainersData.getSize(); i++) {
                if (trainersData.find(i).getFirstName().equals(firstName)) {
                    System.out.println("Enter the LastName of trainer: ");
                    lastName = scanner.nextLine();
                    for (int j = 1; i <= trainersData.getSize(); j++) {
                        if (trainersData.find(j).getLastName().equals(lastName)) {
                            System.out.println("Trainer's name should be unique. Please, enter another name");
                            continue outer;
                        }
                        break outer;
                    }
                }
            }
            System.out.println("Enter the lastName of trainer: ");
            lastName = scanner.nextLine();
            break;
        } while(true);


        Pattern coursesIDsPattern = Pattern.compile("([1-9],)*([1-9])");
        Matcher coursesIDsMatcher;
        Scanner IDsScanner;

        Trainer trainer = new Trainer(firstName, lastName);

        trainersData.add(trainer);

        outer: do{
            System.out.println("Enter the courses IDs for trainer in format:'1,2,...':: ");
            String coursesIDs = scanner.nextLine();

                coursesIDsMatcher = coursesIDsPattern.matcher(coursesIDs);

                if (!coursesIDsMatcher.matches()) {
                    System.out.println("Invalid input!");
                    continue;
                } else
                    IDsScanner = new Scanner(coursesIDs).useDelimiter(",");

            while (IDsScanner.hasNext()){
                    int ID = Integer.valueOf(IDsScanner.next());
                    if(coursesData.find(ID) == null) {
                        System.out.println("Course with id " + ID + " doesn’t exist");
                        continue outer;
                    } else{
                        if (coursesData.find(ID).getTrainerID() != 0) {
                            System.out.println("Course with id " + ID + " already has a trainer assigned");

                            continue outer;
                        } else {
                            trainer.setCourse(ID);
                            coursesData.find(ID).setTrainerID(trainer.getTrainerID());

                        }
                    }
                }

                break;

        } while(true);

    }

    public static void addStudent() {

        scanner = new Scanner(System.in);

        String firstName;
        String lastName;
        outer: do {
            System.out.println("Enter the firstName of student: ");
            firstName = scanner.nextLine();
            for (int i = 1; i <= studentsData.getSize(); i++) {
                if (studentsData.find(i).getFirstName().equals(firstName)) {
                    System.out.println("Enter the LastName of student: ");
                    lastName = scanner.nextLine();
                    for (int j = 1; i <= studentsData.getSize(); j++) {
                        if (studentsData.find(j).getLastName().equals(lastName)) {
                            System.out.println("Student's name should be unique. Please, enter another name");
                            continue outer;
                        }
                        break outer;
                    }
                }
            }
            System.out.println("Enter the lastName of student: ");
            lastName = scanner.nextLine();
            break;
        } while(true);

        int age;

        Pattern agePattern = Pattern.compile("[1-9]{2}");
        Matcher ageMatcher;

        do{
            System.out.println("Enter the age of student: ");
            String ageString = scanner.nextLine();
            ageMatcher = agePattern.matcher(ageString);
            if (!ageMatcher.matches()) {
                System.out.println("Invalid input!");
                continue;
            } else
                age = Integer.valueOf(ageString);
            break;
        } while (true);

        Pattern coursesIDsPattern = Pattern.compile("([1-9],)*([1-9])");
        Matcher coursesIDsMatcher;
        Scanner IDsScanner;

        Student student = new Student(firstName, lastName, age);

        studentsData.add(student);

        outer:
        do {
            System.out.println("Enter the courses IDs for student in format:'1,2,...':: ");
            String coursesIDs = scanner.nextLine();

            coursesIDsMatcher = coursesIDsPattern.matcher(coursesIDs);

            if (!coursesIDsMatcher.matches()) {
                System.out.println("Invalid input!");
                continue;
            } else
                IDsScanner = new Scanner(coursesIDs).useDelimiter(",");

            while (IDsScanner.hasNext()) {
                int ID = Integer.valueOf(IDsScanner.next());
                if (coursesData.find(ID) == null) {
                    System.out.println("Course with id " + ID + " doesn’t exist");
                    continue outer;
                } else {
                        student.setCourse(ID);
                        coursesData.find(ID).addStudentID(student.getStudentID());
                }
            }

            break;

        } while (true);
    }

    public static void viewCourse(int courseID) {
        coursesData.view(courseID);
        if(coursesData.find(courseID).getTrainerID()!=0) {
            System.out.println("Trainer: ");
            trainersData.view(coursesData.find(courseID).getTrainerID());
        }
        if(coursesData.find(courseID).getStudentsListSize() != 0) {
            System.out.println("Students: ");
            for (Integer studentID : coursesData.find(courseID).getStudentsIDs()) {
                System.out.println(studentsData.find(studentID));
            }
        }
    }

    public static void transfer(int studentID,int courseIDToEnroll, int courseIDToExpel){
        if(studentsData.find(studentID) == null){
            System.out.println("Student with id "+ studentID +" doesn’t exist");
            return;
        } else
            if(coursesData.find(courseIDToEnroll) == null) {
                System.out.println("Course with id " + courseIDToEnroll + " doesn’t exist");
                return;
            } else
                if(coursesData.find(courseIDToExpel) == null) {
                    System.out.println("Course with id " + courseIDToEnroll + " doesn’t exist");
                    return;
                } else {
                    for (Integer ID : coursesData.find(courseIDToEnroll).getStudentsIDs()) {
                        if (ID == studentID) {
                            System.out.println("Student " + studentID + "already exist");
                            return;
                        }
                    }
                    coursesData.find(courseIDToEnroll).addStudentID(studentID);
                    coursesData.find(courseIDToExpel).studentExpel(studentID);
                }
        coursesData.find(courseIDToEnroll).addStudentID(studentID);
    }

    public static void viewAllCoursesNames() {
        coursesData.viewAllNames();
    }

    public static void viewTrainer(int trainerID){
        trainersData.view(trainerID);
        if(trainersData.find(trainerID).getCoursesID().size() !=0) {
            System.out.println("Trainer's courses= ");
            for (Integer id : trainersData.find(trainerID).getCoursesID()) {
                System.out.println(id + ": " + coursesData.find(id));
            }
        }
    }

    public static void viewStudent(int studentID){
        studentsData.view(studentID);
        System.out.println("Student's courses= \n");
        for (Integer id : studentsData.find(studentID).getCoursesID()) {
            System.out.println("\t" + coursesData.find(id).getCourseName());
        }
    }

    public static void viewStudentsNames(int courseID){
        for (Integer studentID : coursesData.find(courseID).getStudentsIDs()) {
            System.out.printf("Student: \nid: %d%s %s%n", studentID, studentsData.find(studentID).getFirstName(), studentsData.find(studentID).getLastName());
        }
    }

}
