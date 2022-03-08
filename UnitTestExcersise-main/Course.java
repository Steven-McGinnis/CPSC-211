import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
	
public class Course
{
    private int numAssignments;
    private Map<String,int[]> grades = new HashMap<String,int[]> ();
    
    /**
     * Returns the number of assignments in the course.  
     * Number of assignments should be at least 1.
     */
    public Course (int numAssignments)
    {
        this.numAssignments = numAssignments;
    }
    
    /**
     * Returns the number of assignments in the course
     */
    public int getNumAssignments ()
    {
        return numAssignments;
    }
    
    /**
     * Pass in the student name to add, returns true if student was added.
     * Returns false if student was already enrolled in the course and could
     * not be added.
     */
    public boolean addStudent (String name)
    {
        if (isStudentEnrolled(name))
            return false;
        
        grades.put(name, new int[numAssignments]);
        return true;
    }

    /**
     * Pass in the student name to add, returns true if student is in the course.
     * Returns false if student is not in the course.
     */
    public boolean isStudentEnrolled (String name)
    {
        return grades.containsKey(name);
    }
    
    /**
     * Pass in the student name to remove, returns true if student was removed.
     * Returns false if student is not in the course.
     */
    public boolean removeStudent (String name)
    {
        if (! isStudentEnrolled(name))
            return false;

        grades.remove(name);
        return true;
    }
    
    /**
     * Sets a grade for a particular assignment for the given student.  
     * Returns true if the grade could be set.  Returns false if the
     * student isn't in the course or the assignment number is illegal.
     * Assignment number is from 1 to the maximum number of assignments.
     * Grade must be at least 0.
     */
    public boolean setStudentAssignmentGrade (int assignmentNumber, int grade, String name)
    {
        if (! isStudentEnrolled(name))
            return false;
        
        if (assignmentNumber > numAssignments || assignmentNumber < 1)
            return false;
        
        if (grade < 0)
            return false;
        
        int [] studentGrades = grades.get(name);
        studentGrades[assignmentNumber-1] = grade;
        return true;
    }
    
    /**
     * Returns a grade for the given student and assignment.  
     * Returns -1 if any input is illegal, or the student isn't
     * in the course. 
     */
    public int getStudentAssignmentGrade (int assignmentNumber, String name)
    {
        if (! isStudentEnrolled(name))
            return -1;
        
        if (assignmentNumber > numAssignments || assignmentNumber < 1)
            return -1;
        
        int [] studentGrades = grades.get(name);
        return studentGrades[assignmentNumber-1];//Adjusted code to give proper result.
    }
}
