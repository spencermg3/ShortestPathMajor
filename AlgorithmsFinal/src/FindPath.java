import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.opencsv.CSVReader;

/**
 * @author Danny, Kai, Spencer
 * Just a preliminary file to get used to working with the csv Data. Currently it prints out all of the cells in the given
 * csv file. In addition it has a function that creates a hashmap of the headings data. I imagine this can be useful going into the
 * future. If we know that say the "Capstone Course?" element is always held in the 6th col (starting with zero) then could make future
 * algorithms more efficent/easier to code. 
 *  */


public class FindPath {

	/**
	 * 
	 * @param The desired csv file
	 * @return A Hashmap with the key being the headings column name and the key being the index which it is found.
	 * @throws IOException This is used in case the inputted file is null. 
	 */
	private static Map<String, Integer> headingsMap(File file) throws IOException{
		CSVReader reader = new CSVReader(new FileReader(file));
		String [] headingsLine;
		headingsLine = reader.readNext(); //This reads the data on a row by row case, seperating on commas. 
		reader.close();
		Map<String, Integer> CapMap = new HashMap<String, Integer>(); // The key will be the index in which the heading was found
		for (int i = 0; i < headingsLine.length; i++){
			CapMap.put(headingsLine[i], i);
		}
		return CapMap;
	}
	
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		System.out.println("Preparing to read data from csv....");
		
		// Below I have put in the path to the csv holding the CS major info, later we should make this more dynamic.
		File file = new File("C:\\Users\\Danny\\Desktop\\Algorithms\\ShortestPathMajor\\AlgorithmsFinal\\ShortestPathMajorCS.csv");
		CSVReader reader = new CSVReader(new FileReader(file));
		String [] nextLine;
	    while ((nextLine = reader.readNext()) != null) { //I read over every row
	        // nextLine[] is an array of values from the line
	    	for (int i = 0; i < nextLine.length; i++){
	    		System.out.print(nextLine[i] + " "); //just print out everything, to see what we are working with
	    	}
	    	System.out.println();
	    }
	    System.out.println();
	    Map<String, Integer> headingsMap = headingsMap(file);
	    for (Map.Entry<String, Integer> entry : headingsMap.entrySet()) { //just showing off that headingsMap function works
	    	System.out.println(entry.getKey() + " : " + entry.getValue());
	    }
	}
}
	
