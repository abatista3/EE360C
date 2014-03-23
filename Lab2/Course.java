// Class for indicating the different entries for a course
import java.util.Date;

/*
 * You may or may not use all the fields of this class, it is upto you to decide
 * what data structures are most relevant for your implementation
 * The getters and the setters functions have been provided to access the private members of 
 * of the class
 */
public class Course {

		// Name of course
    	private String name; 
    	// Index number of course (0 to N-1, where N is the number of courses provided)
    	private Long number; 
    	// Days of week the class meets 'MW', 'TTH', 'MWF'etc.
    	private int days;
    	// Start Time of the lecture
    	private Date startTime; 
    	// End Time of the lecture
    	private Date endTime;  
    	// Estimated workload in number of hours
    	private int workload; 
    	// Number of pre requisites for this course
    	private Long preReq;  
    	// Number of conflicts for this course
    	private Long conflict; 
    	// Array of Index number of courses which are prerequisites for this course
    	private Long[] preReqCourses; 
    	// Array of Index number of courses which should not be taken with this course (conflicts)
    	private Long[] conflictCourses; 
    	// No of credit, 3 or 4 etc.
    	private int credit; 
    	// Set to true if the user selects this course
    	boolean selected = false;   
    	
  
    Course() {
		this.name = "X";
		this.number = 0L;
		this.days = 0;
		this.startTime = new Date();
		this.endTime = new Date();
		this.workload = 0;
		this.preReq = 0L;
		this.conflict = 0L;
		this.credit = 0;
    }
    
    Course(String name, Long number, String days1, Date startTime, Date endTime, int workload, int credit,
    		Long preReq, Long conflict, Long[] preReqCourses, Long[] conflictCourses) {
		this.name = name;
    	this.number = number;
    	// For courses which meet on MWF or MW, days = 0, for courses meeting on TTH, days = 1
    	if (days1.equals("MW") || days1.equals("MWF"))
    		this.days = 0;
    	else
    		this.days = 1;
    	this.workload = workload;
    	this.credit = credit;
    	this.startTime = startTime;
		this.endTime = endTime;
		this.preReq = preReq;
		this.conflict = conflict;
		
		this.preReqCourses = preReqCourses;
		this.conflictCourses = conflictCourses; 
    }   
    
// Copy constructor	
    Course(Course c) {
		this.name = c.getName();
    	this.number = c.getNumber();
    	this.days = c.getDays();
    	this.workload = c.getWorkload();;
    	this.startTime = c.getStartTime();
		this.endTime = c.getEndTime();
		this.preReq = c.getPreReq();
		this.conflict = c.getConflict();		
		this.preReqCourses = c.getPreReqCourses();
		this.conflictCourses = c.getConflictCourses(); 
		this.credit = c.getCredit();
    }
	
//SETTERS
    public void setName(String name) {       
        this.name = name;
    }
    
    public void setNumber(Long number) {
        this.number = number;
    }

    public void setDays(int days) {       
        this.days = days;
    }
    
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
    
    public void setPreReq(Long preReq) {
        this.preReq = preReq;
    }
    
    public void setConflict(Long conflict) {
        this.conflict = conflict;
    }
    
    public void setWorkload(int workload) {
        this.workload = workload;
    }
    
    public void setCredit(int credit) {
        this.credit = credit;
    }
    
    public void setPreReqCourses(Long[] preReqCourses) {
    	this.preReqCourses = preReqCourses;
    }
    
    public void setConflictCourses(Long[] conflictCourses) {
    	this.conflictCourses = conflictCourses;
    }
    
//GETTERS    
    public String getName() {       
        return name;
    }
    
    public Long getNumber() {
        return number;
    }
    
    public int getDays() {       
        return days;
    }    
    public Date getStartTime() {
        return startTime;
    }
    
    public Date getEndTime() {
        return endTime;
    }
    
    public Long getPreReq() {
        return preReq;
    }
    
    public Long getConflict() {
        return conflict;
    } 
    
    public int getWorkload() {
        return workload;
    }
    
    public int getCredit() {
        return credit;
    }
    
    public Long[] getPreReqCourses() {
    	return preReqCourses;
    }
    
    public Long[] getConflictCourses() {
    	return conflictCourses;
    }
}