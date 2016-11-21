
/*
 * Object that contains a department and a Course ID number, (i.e. COMP 123)
 */


public class CourseID {
	
	String dept;
	int courseNum;
	

	public CourseID(String dept,int courseNum){
		this.courseNum = courseNum;
		this.dept= dept;
		
	}

	
	public int getCourseNum() {
		return courseNum;
	}

	public String getDept() {
		return dept;
	}
	
	
	public String toString(){
		return dept + " " + new Integer(courseNum).toString();
	}
	
	/*
	 * This is shitty, has to be fixed
	 */
	public boolean equals(Object object) {
	    CourseID testID = (CourseID)object;
		if (testID.toString().equals(this.toString())){
			return true;
		}
	    return false;
	}
	
	
	
	
}
