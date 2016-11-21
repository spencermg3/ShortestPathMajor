import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//Make sure this package is included on your computer!!!
import com.opencsv.CSVReader;

/**
 * @author Danny, Kai, Spencer
 * Program that takes a student's inputed classes and determines if they are able to complete the Computer 
 * Science major at Macalester college
 * 
 */


public class FindPath {
	
	static File file; 
	static Map<CourseID, Course> courseMap;     //Map containing all courses in inputtedFile
	static ArrayList<Course> studentCourses;    //ArrayList containing all courses that the Student has currently completed
	
	
	/*
	 * Initialize file and courseMap - make sure filename is correct here
	 */
	public static void init() throws NumberFormatException, IOException{
		file = new File("ShortestPathMajorCS.csv");    //Change this if file is not found
		courseMap = createCourses();
		studentCourses = createStudentCourses();
	}
	
	
	/*
	 * Main method
	 */
	
	public static void main(String[] args) throws Exception {
		init();	
	
		
		//Print out all key/value pairs in the courseMap
//		for (Map.Entry<CourseID, Course> entry : courseMap.entrySet()){
//		    System.out.println(entry.getKey() + "/" + entry.getValue());}
		

		//Check to see how many Courses got added to studentCourses 
		//System.out.println(studentCourses.size());
		
		//Print out all courses in studentCourses
		Course c = studentCourses.get(0);
		System.out.println(c.toString());

	}
	
	
	
	/*
	 * Creates a Map of course objects - these are all courses contained in the given CSV
	 */
	private static Map<CourseID, Course> createCourses() throws NumberFormatException, IOException{
		Map<CourseID, Course> courseMap = new HashMap<CourseID, Course>();
		
		@SuppressWarnings("resource")
		CSVReader reader = new CSVReader(new FileReader(file));
		
		// nextLine is an array of Strings that represent all entries in a particular row of the given CSV
		String [] nextLine;
		
		//This is to get past the header row
		reader.readNext();
		
		while ((nextLine = reader.readNext()) != null) { //Read over every row and convert the row to a entry in the course map
	    		//Create CourseID object
	    		CourseID id = new CourseID(nextLine[1], Integer.parseInt(nextLine[2]));
	    		//Create Course object
	    		Course course = new Course(Integer.parseInt(nextLine[0]), nextLine[1], Integer.parseInt(nextLine[2]), 
	    									nextLine[3], nextLine[4], Integer.parseInt(nextLine[5]), Integer.parseInt(nextLine[6]),
	    									nextLine[7], nextLine[8], Integer.parseInt(nextLine[9]));
	    		//Add newly created entry to the map of courses
	    		courseMap.put(id, course);
	    	}
		return courseMap;	
	}
	
	
	
	/*
	 * Preliminary method that creates a list of Courses that the user has taken
	 */
	
	private static ArrayList<Course> createStudentCourses (){
		ArrayList<Course> studentCourseList = new ArrayList<Course>();
		
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner (System.in);
		System.out.print("Enter a course Department or -1 if no more courses:  ");  
		String deptName = scanner.next(); // Get what the user types.
		System.out.print("Enter a course Number: "); 
		int courseNum = scanner.nextInt();
		
		CourseID testID = new CourseID(deptName, courseNum);

		
//		Course testCourse = courseMap.get(testID);	
		
		//Something weird happens when I check for null here, .get() method somehow is returning null
//		studentCourseList.add(testCourse);

		
		
		//This is inefficient, but the .get() method is not working for the course Map
		for (Map.Entry<CourseID, Course> entry : courseMap.entrySet()){
			if (entry.getKey().equals(testID)){
				studentCourseList.add(entry.getValue());
			}
		}
		
		//Test to make sure it was actually added
		//System.out.println(studentCourseList.get(0).toString());
		
		//Below is used for testing, disregard

//		for (Map.Entry<CourseID, Course> entry : courseMap.entrySet()){
//		    System.out.println(entry.getKey().toString());
//			System.out.println(entry.getKey().equals(testID));}
	
		return studentCourseList;
	}
	
	
	
	
	
	
	
	/*
	 * Prints out headings for each Column
	 */
//	private static Map<String, Integer> headingsMap(File file) throws IOException{
//		CSVReader reader = new CSVReader(new FileReader(file));
//		String [] headingsLine;
//		headingsLine = reader.readNext(); //This reads the data on a row by row case, seperating on commas. 
//		reader.close();
//		Map<String, Integer> CapMap = new HashMap<String, Integer>(); // The key will be the index in which the heading was found
//		for (int i = 0; i < headingsLine.length; i++){
//			CapMap.put(headingsLine[i], i);
//		}
//		return CapMap;
//	}
	
	
	
}
	
