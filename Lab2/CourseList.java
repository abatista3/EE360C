import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Collections;

import java.util.Queue;
import java.util.Hashtable;
import java.util.HashSet;
import java.util.Comparator;
import java.util.Iterator;
import java.lang.Math;

public abstract class CourseList {
   
	// The Arraylist containing information about all the courses 
	protected ArrayList<Course> courses = new ArrayList<Course>(0); 
	
    int numCourses;
    
    // The maximum possible workload has been fixed to be 80 hours/week
    int maxWorkload = 80; 
    
    CourseList() {
        /* 
         * This constructor creates an empty list of courses
         */
    	courses = new ArrayList<Course>(0);
    }
    
	// totalCourseFile: File containing list of all courses offered
	// inputCourseFile: File containing list of courses selected by an user
	CourseList(String totalCourseFile, String inputCourseFile) {
		Scanner scan =  null;
        try {
        	scan = new Scanner(new BufferedReader(new FileReader(totalCourseFile)));
        	String courseSize = scan.nextLine();
    	    numCourses = Integer.parseInt(courseSize);
    	    parseCourses(scan, numCourses);
        } catch (FileNotFoundException exception) {
            System.err.println("FileNotFoundException: " + exception.getMessage());
        } finally {
            if (scan != null) scan.close();
        }
        
        try {
        	scan = new Scanner(new BufferedReader(new FileReader(inputCourseFile)));
        	String courseSize = scan.nextLine();
    	    int numSelections = Integer.parseInt(courseSize);
    	    parseSelections(scan, numSelections);
        } catch (FileNotFoundException exception) {
            System.err.println("FileNotFoundException: " + exception.getMessage());
        } finally {
            if (scan != null) scan.close();
        }
        
	}
	
	void parseCourses(Scanner scan, int numCourses) {  	
        for (int i=0; i<numCourses; i++) {
        	String[] inLine = scan.nextLine().split(" ");
        	DateFormat formatter = new SimpleDateFormat("HH:mm");
        	Date startTime = null;
        	Date endTime = null;
        	try {
        		startTime = (Date) formatter.parse(inLine[2]);
        		endTime = (Date) formatter.parse(inLine[3]);
        	} catch (ParseException e) {
                e.printStackTrace();
            }        	
        	Long number = Long.valueOf(i);
        	int hours = Integer.parseInt(inLine[4]);
        	int credits = Integer.parseInt(inLine[5]);
        			
        	int tempIndex = 6;
        	Long preReq = Long.valueOf(inLine[tempIndex]);
        	int t = Integer.parseInt(inLine[tempIndex]);
        	Long[] preReqCourses = new Long[t];
        	if (preReq != 0) {
        		for (int j = 0; j < preReq; j++) {
        			preReqCourses[j] = Long.valueOf(inLine[tempIndex+j+1]);
	        	}
        	}
          	
        	Long conflict =  Long.valueOf(inLine[tempIndex+t+1]);
        	int t1 = Integer.parseInt(inLine[tempIndex+t+1]);
        	Long[] conflictCourses = new Long[t1];
        	if(conflict != 0) {
	        	for (int j = 0; j < conflict; j++) {
	        		conflictCourses[j] = Long.valueOf(inLine[tempIndex+t+1+j+1]);
	        	}
        	}
        	
        	courses.add(new Course(inLine[0], number, inLine[1], startTime, endTime, hours, credits,
        			preReq, conflict, preReqCourses, conflictCourses));    
        	
        }
        
        return;
   	}
	
	// Reads in the set of selected courses, goes to the original
	// list of courses, and sets the 'selected' flag to be true
	void parseSelections(Scanner scan, int numSelections) {
		for (int i = 0; i < numSelections; i++) {
			String inLine = scan.nextLine();
			Long courseIn = Long.valueOf(inLine);
			for (Course c : courses) {
				Long num = c.getNumber();
				if (num.equals(courseIn)) {
					c.selected = true;
				}
			}
		}
		return;
	}
	
	public abstract ArrayList<ArrayList<Course>> isConflictFree();
	public abstract ArrayList<Course> dependencyList();
	public abstract ArrayList<Course> legalSchedule();
	public abstract ArrayList<Course> loadBalance();	
	     
}

