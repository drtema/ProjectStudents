package com.drtema.userinterfaces;

import com.drtema.daoimplemantations.CoursesList;
import com.drtema.daoimplemantations.StudentsList;
import com.drtema.daoimplemantations.TaskList;
import com.drtema.daoimplemantations.TrainersList;
import com.drtema.daointerfaces.CoursesDAO;
import com.drtema.daointerfaces.StudentsDAO;
import com.drtema.daointerfaces.TasksDAO;
import com.drtema.daointerfaces.TrainersDAO;
import com.drtema.mainclasses.Course;
import com.drtema.mainclasses.Student;
import com.drtema.mainclasses.Task;
import com.drtema.mainclasses.Trainer;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Realized UI and command input
 */
public class CourseInterface {

    private static TrainersDAO trainersData = new TrainersList();
    private static CoursesDAO coursesData = new CoursesList();
    private static StudentsDAO studentsData = new StudentsList();
    private static TasksDAO tasksData = new TaskList();

    private static Scanner scanner = new Scanner(System.in);
    private static String fileCourses = "/Users/Dr.tema/Documents/projects/ProjectStudents/Courses.txt";
    private static String fileTrainers = "/Users/Dr.tema/Documents/projects/ProjectStudents/trainers.txt";
    private static String fileStudents = "/Users/Dr.tema/Documents/projects/ProjectStudents/students.txt";
    private static Path pathCourses = Paths.get(fileCourses);
    private static Path pathTrainers = Paths.get(fileTrainers);
    private static Path pathStudents = Paths.get(fileStudents);
    private static int objectCounter;
    private static boolean inputType = true;

    public static boolean isInputType() {
        return inputType;
    }

    public static int getObjectCounter() {
        return objectCounter;
    }

    public static void setInputType(String type){
        do {

            if(type.equals("2")) {
                inputType = false;
                break;
            }
            scanner = new Scanner(System.in);
            inputType = true;
            break;
        } while(true);
    }

    public static void courseAdd(){

        if(!inputType) {
            if (coursesData.getSize()==0) {
                try {
                    scanner = new Scanner(pathCourses);
                    objectCounter = Integer.valueOf(scanner.nextLine());
                } catch (IOException e) {
                    System.out.println("Invalid Path or File");
                    inputType = true;
                }
            }
        } else
            scanner = new Scanner(System.in);

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
        if(!inputType) {
            if (trainersData.getSize()==0) {
                try {
                    scanner = new Scanner(pathTrainers);
                    objectCounter = Integer.valueOf(scanner.nextLine());
                } catch (IOException e) {
                    System.out.println("Invalid Path or File");
                }
            }
        } else
            scanner = new Scanner(System.in);

        String firstName;
        String lastName ;
        outer: do {
            if (inputType)
                System.out.println("Enter the firstName of trainer: ");
            firstName = scanner.nextLine();
            try {
                for (int i = 1; i <= trainersData.getSize(); i++) {
                    if (trainersData.find(i).getFirstName().equals(firstName)) {
                        if (inputType)
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
            }catch (NullPointerException e){
                System.out.println(e.getMessage());
            }
            if (inputType)
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
            if (inputType)
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
                        try {
                            if (coursesData.find(ID).getTrainerID() != 0) {
                                System.out.println("Course with id " + ID + " already has a trainer assigned");

                                continue outer;
                            } else {
                                trainer.setCourse(ID);
                                coursesData.find(ID).setTrainerID(trainer.getTrainerID());

                            }
                        } catch (NullPointerException e){
                            System.out.println(e.getMessage());
                            continue outer;
                        }
                }

                break;

        } while(true);

    }

    public static void addStudent() {

        if(!inputType) {
            if (studentsData.getSize()==0) {
                try {
                    scanner = new Scanner(pathStudents);
                    objectCounter = Integer.valueOf(scanner.nextLine());
                } catch (IOException e) {
                    System.out.println("Invalid Path or File");
                }
            }
        } else
            scanner = new Scanner(System.in);

        String firstName;
        String lastName;
        outer: do {
            if (inputType)
                System.out.println("Enter the firstName of student: ");
            firstName = scanner.nextLine();
            try {
                for (int i = 1; i <= studentsData.getSize(); i++) {
                    if (studentsData.find(i).getFirstName().equals(firstName)) {
                        if (inputType)
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
            } catch (NullPointerException e){
                System.out.println(e.getMessage());
            }
            if (inputType)
                System.out.println("Enter the lastName of student: ");
            lastName = scanner.nextLine();
            break;
        } while(true);

        int age;

        Pattern agePattern = Pattern.compile("[1-9][0-9]");
        Matcher ageMatcher;

        do{
            if (inputType)
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
            if (inputType)
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
                try{
                    student.setCourse(ID);
                    coursesData.find(ID).addStudentID(student.getStudentID());
                } catch (NullPointerException e){
                    System.out.println(e.getMessage());
                    continue outer;
                }
            }

            break;

        } while (true);
    }

    public static void viewCourse(int courseID) {
        try {
            coursesData.view(courseID);
            if (coursesData.find(courseID).getTrainerID() != 0) {
                System.out.println("Trainer: ");
                trainersData.view(coursesData.find(courseID).getTrainerID());
            }
            if (coursesData.find(courseID).getStudentsListSize() != 0) {
                System.out.println("Students: ");
                for (Integer studentID : coursesData.find(courseID).getStudentsIDs()) {
                    System.out.println(studentsData.find(studentID));
                }
            }
        } catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
    }

    public static void transfer(int studentID,int courseIDToEnroll, int courseIDToExpel){
        try {

                for (Integer ID : coursesData.find(courseIDToEnroll).getStudentsIDs()) {
                    if (ID == studentID) {
                        System.out.println("Student " + studentID + "already exist");
                        return;
                    }
                }
                coursesData.find(courseIDToEnroll).addStudentID(studentID);
                coursesData.find(courseIDToExpel).studentExpel(studentID);

        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
    }

    public static void viewAllCoursesNames() {
        coursesData.viewAllNames();
    }

    public static void viewTrainer(int trainerID){
        try {
            trainersData.view(trainerID);
            if (trainersData.find(trainerID).getCoursesID().size() != 0) {
                System.out.println("Trainer's courses= ");
                for (Integer id : trainersData.find(trainerID).getCoursesID()) {
                    System.out.println(id + ": " + coursesData.find(id));
                }
            }
        }catch (NullPointerException e){
            System.out.println(e);
        }
    }

    public static void viewStudent(int studentID){
        studentsData.view(studentID);
        System.out.println("Student's courses= \n");
        try {
            for (Integer id : studentsData.find(studentID).getCoursesID()) {
                System.out.println("\t" + coursesData.find(id).getCourseName());
            }
        } catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
    }

    public static void viewStudentsNames(int courseID){
        try {
            for (Integer studentID : coursesData.find(courseID).getStudentsIDs()) {
                System.out.printf("Student: \nid: %d%s %s%n", studentID, studentsData.find(studentID).getFirstName(), studentsData.find(studentID).getLastName());
            }
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
    }

    public static void addTask(){
        scanner = new Scanner(System.in);
        String taskName;
        System.out.println("Enter the task name");
        taskName = scanner.nextLine();

        Pattern coursesIDPattern = Pattern.compile("([1-9])+");
        Matcher coursesIDMatcher;

        do{
            System.out.println("Enter the course ID: ");
            String id = scanner.nextLine();
            coursesIDMatcher = coursesIDPattern.matcher(id);
            if (!coursesIDMatcher.matches()) {
                System.out.println("Invalid input!");
                continue;
            } else {
                try{
                    Integer ID = Integer.valueOf(id);
                    Task task = new Task(taskName,ID);
                    coursesData.find(ID).addTask(task.getTaskID());
                    tasksData.add(task);
                    break;
                }catch (NullPointerException e){
                    System.out.println(e.getMessage());
                }
            }
        } while(true);
    }
    //TODO
    public static void addMark(){

        scanner = new Scanner(System.in);
        Integer courseID;
        Integer studentID;
        Integer mark;

        do {
            System.out.println("Enter the course id: ");
            if (!scanner.hasNextInt()) {
                System.out.println("invalid input!\n");
                continue;
            }
            courseID = scanner.nextInt();
            break;
        }while (true);

        do {
            System.out.println("Enter the student id: ");
            if (!scanner.hasNextInt()) {
                System.out.println("invalid input!\n");
                continue;
            }
            studentID = scanner.nextInt();
            break;
        }while (true);

        do {
            System.out.println("Enter the mark: ");
            if (!scanner.hasNextInt()) {
                System.out.println("invalid input!\n");
                continue;
            }
            mark = scanner.nextInt();
            break;
        }while (true);


        try {
            tasksData.findByCourseID(courseID).setMark(studentsData.find(studentID).getFirstName() + " " + studentsData.find(studentID).getLastName(), mark);
        } catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
    }

    //TODO
    public static void viewJournal(Integer courseID){
        try {
            System.out.println(coursesData.find(courseID).getCourseName());
            for (Integer taskID : coursesData.find(courseID).getTasks()) {
                System.out.println(tasksData.find(taskID));
            }
        } catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
    }

    public static void exit(){
        coursesData.close();
        trainersData.close();
        tasksData.close();
        studentsData.close();
    }

}
