package com.drtema.userinterfaces;

import com.drtema.mainclasses.Course;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Dr.tema on 08.04.17.
 */
public class CourseInterface {

    static Scanner scanner = new Scanner(System.in);

    public static Course courseAdd(){
        System.out.println("Enter the name of course: ");
        String name = scanner.nextLine();

        System.out.println("Enter the description of course: ");
        String description = scanner.nextLine();

        Pattern datePattern = Pattern.compile("" +
                "(19|20)\\d\\d[. ,-:]((0[1-9]|1[012])" +
                "[. ,-:](0[1-9]|[12]\\d)|(0[13-9]|1[012])" +
                "[. ,-:]" +
                "30|(0[13578]|1[02])" +
                "[. ,-:]31)");
        Matcher dateMatcher;
        Scanner dateScanner = null;
        String startDate;
        do {
            System.out.println("Enter the start-date of course in format:'yyyy.mm.dd': ");
            startDate = scanner.nextLine();
            dateMatcher = datePattern.matcher(startDate);

            if (dateMatcher.matches() == false) {
                System.out.println("Invalid input!");
                continue;
            }
        } while (dateMatcher.matches() == false);

        String[] string = new String[10];

        String endDate;
        do {
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

        //do {
            System.out.println("Enter the days of course in format:'MON,TUE,...,SUN': ");
            String dayOfCourses = scanner.nextLine();
            dayMatcher = datePattern.matcher(dayOfCourses);

            if (dateMatcher.matches() == false) {
                System.out.println("Invalid input!");
                //continue;
            } else
                dayScanner = new Scanner(dayOfCourses).useDelimiter("[. ,-:]");
        //} while (dayMatcher.matches() == false);

        List<String> dayOfCourses1 = new ArrayList();

        while (dayScanner.hasNext()){
            dayOfCourses1.add(dayScanner.next());
        }

        String[] array = new String[dayOfCourses1.size()];

        Course course = new Course(name,description, startDate,endDate, dayOfCourses1.toArray(array));

        return course;
    }

}
