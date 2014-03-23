/*
 * Name: <your name>
 * EID: <your EID>
 */

import java.util.ArrayList;

/* Your solution goes in this file.
 *
 * Please do not modify the other files we have provided for you, as we will use
 * our own versions of those files when grading your project. You are
 * responsible for ensuring that your solution works with the original version
 * of all the other files we have provided for you.
 * 
 * That said, please feel free to add additional files and classes to your
 * solution, as you see fit. We will use ALL of your additional files when
 * grading your solution.
 */

public class ProgramLab2 extends CourseList {
    /* DO NOT FORGET to add a graph representation and 
       any other fields and/or methods that you think 
       will be useful. 
       DO NOT FORGET to modify the constructors when you 
       add new fields to the ProgramLab2 class. */
	
    ProgramLab2() {
        super();
    }
    
    ProgramLab2(String totalCourseFile, String inputCourseFile) {
        super(totalCourseFile, inputCourseFile);
    }
    
    public ArrayList<ArrayList<Course>> isConflictFree() {
    	/* 
    	 * TODO: This method should return an ArrayList of two Arraylists of courses
    	 * which do not have any conflict between them.
    	 * In case, finding such a partion is not possible, the length of 
    	 * the returned ArrayList should be zero, ie, it is empty.
    	 */
	Long[] conflictingCourses;
	for(int i = 0; i < courses.size(); i++){
		System.out.println(courses.get(i).getName());
		System.out.println(courses.get(i).getStartTime());
		System.out.println(courses.get(i).getEndTime());
		conflictingCourses = courses.get(i).getConflictCourses();
		System.out.println("Conflicts with");
		for(int j = 0; j < conflictingCourses.length; j++){
			System.out.println(courses.get(conflictingCourses[j].intValue()).getName());
			System.out.println(conflictingCourses[j]);
			System.out.println(courses.get(conflictingCourses[j].intValue()).getStartTime());
			System.out.println(courses.get(conflictingCourses[j].intValue()).getEndTime());
		
		}
		System.out.println("##########################################");
	}
        return new ArrayList<ArrayList<Course>>(0);
    }
    
    public ArrayList<Course> dependencyList() {
        /* 
         * TODO: This method returns dependency relation of the prerequisites, in an ArrayList of courses
         * The array of courses should be sorted in such a way that if course(i) depends on course(j)
         * j with appear before i, for all (i,j)
         */
        return new ArrayList<Course>(0);
    }
    
    public ArrayList<Course> legalSchedule() {
    	/* 
    	 * TODO: This method returns an ArrayList of courses with no conflicting lecture times  
    	 */
        return new ArrayList<Course>(0);
    }
    
    public ArrayList<Course> loadBalance() {
    	/* 
    	 * TODO: This method returns an ArrayList of courses such that the number of credit hours in maximum,
    	 * given the constraint that the maximum workload should be less than 80 hours (as specified in
    	 * CourseList class). Should return an empty ArrayList in case no such course can be found  
    	 */
        return new ArrayList<Course>(0);
    }
    
}

