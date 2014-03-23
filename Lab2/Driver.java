import java.util.ArrayList;

public class Driver {
	public static String totalCourseFile;
	public static String inputCourseFile;
    public static boolean testConflict;
    public static boolean testPreReq;
    public static boolean testLegal;
    public static boolean testBalance;
    
    private static void usage() {
		System.err.println("usage: java Driver [-c] [-p] [-s] [-w] <course list file name> <selected courses file name>");
        System.err.println("\t-c\tTest conflict checking implementation");
        System.err.println("\t-p\tTest pre requisite checking implementation");
        System.err.println("\t-s\tTest legal schedule implementation");
        System.err.println("\t-w\tTest maximizing credit implementation");
        System.exit(1);    	
    }
    
    public static void main(String[] args) {
      
	if (args.length < 3) {
		usage();
	}

	String opts = args[0];
	totalCourseFile = args[1];
	inputCourseFile = args[2];
	
	ProgramLab2 courseSchedule = new ProgramLab2(totalCourseFile, inputCourseFile);
	
	if (opts.equals("-c"))
		testConflict = true;
	else if (opts.equals("-p"))
		testPreReq = true;
	else if (opts.equals("-s"))
		testLegal = true;
	else if (opts.equals("-w"))
		testBalance = true;
	else {
		System.err.printf("Unknown option: %s\n", opts);
		usage();
	}
	
	if (testConflict)
		courseSchedule.isConflictFree();
	if (testPreReq)
		courseSchedule.dependencyList();
	if (testLegal)
		courseSchedule.legalSchedule();
	if (testBalance)
		courseSchedule.loadBalance();
    }
    
}

