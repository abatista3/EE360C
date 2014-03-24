/*
 * Name: <your name>
 * EID: <your EID>
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Set;
import java.util.Queue;
import java.util.HashSet;


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
	Long[] indexesConflictingCourses;
	Course course, conflictingCourse;
	Set<Course> spring = new HashSet<Course>();
	Set<Course> fall = new HashSet<Course>();
	Set<Course> queued = new HashSet<Course>();	
	Queue<Course> q = new LinkedList<Course>();

	// Graph Representation
	// Adjacency List
	HashMap<String,LinkedList<Course>> graph = new HashMap<String,LinkedList<Course>>();
	ArrayList<Course> nodes = new ArrayList<Course>();

	// Build Graph Representation
	for(int i = 0; i < courses.size(); i++){
		course = courses.get(i);
		if(course.selected){
			LinkedList<Course> conflictingCourses = new LinkedList<Course>();
			indexesConflictingCourses = courses.get(i).getConflictCourses();
			for(int j = 0; j < indexesConflictingCourses.length; j++){
				conflictingCourse = courses.get(indexesConflictingCourses[j].intValue());
				if(conflictingCourse.selected){
					conflictingCourses.add(conflictingCourse);
				}
			}
			graph.put(course.getName(),conflictingCourses);
			nodes.add(course);
		}
	}

	// See if graph bipartite
	Course unexploredCourse, adjacentCourse;
	LinkedList<Course> adjacencyList;
	for(int i = 0; i < nodes.size(); i++){
		if(!spring.contains(nodes.get(i)) && !fall.contains(nodes.get(i))){
			unexploredCourse = nodes.get(i);
			spring.add(unexploredCourse);
			q.add(unexploredCourse);
			queued.add(unexploredCourse);
			while(!q.isEmpty()){
				unexploredCourse = q.poll();
				adjacencyList = graph.get(unexploredCourse.getName());
				for(int j = 0; j < adjacencyList.size(); j++){
					adjacentCourse = adjacencyList.get(j);
					if(spring.contains(unexploredCourse) && !spring.contains(adjacentCourse) && !queued.contains(adjacentCourse)){
						fall.add(adjacentCourse);
						q.add(adjacentCourse);
						queued.add(adjacentCourse);
					}
					else if(fall.contains(unexploredCourse) && !fall.contains(adjacentCourse) && !queued.contains(adjacentCourse)){
						spring.add(adjacentCourse);
						q.add(adjacentCourse);
						queued.add(adjacentCourse);
					}
					else if(!queued.contains(adjacentCourse)){ // not bipartite
        					return new ArrayList<ArrayList<Course>>(0);
					}
				}
			}
		}
	}
	ArrayList<Course> springSemester, fallSemester;
	springSemester = new ArrayList<Course>(spring);
	fallSemester = new ArrayList<Course>(fall);
	ArrayList<ArrayList<Course>> semesters = new ArrayList<ArrayList<Course>>();
	semesters.add(fallSemester);
	semesters.add(springSemester);

	System.out.println("Spring");
	for(int i = 0; i < springSemester.size(); i++){
		System.out.println(springSemester.get(i).getName());
	}
	System.out.println("Fall");
	for(int i = 0; i < fallSemester.size(); i++){
		System.out.println(fallSemester.get(i).getName());
	}
        return semesters;
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

