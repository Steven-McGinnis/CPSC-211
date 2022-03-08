import static org.junit.Assert.*;

import org.junit.Test;

public class CourseTest {

	/**
	 * Tests The Constructor to See if it is working.
	 * creates a number of Assignments to pass to constructor.
	 * calls another method to prove its working.
	 */
	@Test
	public void testCourse() {
		//Setup
		int numAssignments = 2;
		Course course = new Course(numAssignments);
		//Method Execution
		int assignmentFinal = course.getNumAssignments();
		//Verification
		if (assignmentFinal != 2)
		{
			fail("NumAssignments should have been " + numAssignments + " got " + assignmentFinal + " instead." );
		}	
	}

	
	
	/**
	 * Tests adding Assignments to the array and compares it to the Total
	 * 
	 */
	
	@Test
	public void testGetNumAssignments() {
		//Setup
		int numAssignments = 25;
		Course course = new Course(numAssignments);
		//Method Execution
		int assignmentFinal = course.getNumAssignments();
		//Verification
		if (assignmentFinal != 25)
		{
			fail("NumAssignments should have been " + numAssignments + " got " + assignmentFinal + " instead." );
		}
	}

	/**
	 * Tests adding a student by calling the testAddStudent
	 * Adds newstudent
	 */
	@Test
	public void testAddStudent() {
		//Setup
		int numAssigments = 11;
		String newstudent = "Jeremy";
		Course course = new Course(numAssigments);
		//Method Execution
		Boolean isadded = course.addStudent(newstudent);
		//Verification
		if(isadded != true) {
			fail("Added Student" + newstudent + " was not added to class despite not exisiting");
		}
	}
	
	/**
	 * Tests what happens when you try you add a student to the class
	 *  but there is one already in the class with the same name
	 */
	@Test
	public void testAddStudentFail() {
		//Setup
		int numAssignements = 70;
		String newstudent1 = "Bob";
		Course course = new Course(numAssignements);
		//Method Execution
		Boolean isadded1 = course.addStudent(newstudent1);
		Boolean isadded2 = course.addStudent(newstudent1);
		//Verification
		if(isadded1 != true) {
			fail("First Student Was Not Added Successfully");
		}
		if(isadded2 != false) {
			fail("Second Student Was Added despite existing already");
		}
	}

	
	/**
	 * Sees if there is a student enrolled in the class 
	 * But has not been assigned yet
	 */
	@Test
	public void testIsStudentEnrolled() {
		//Setup
		int numAssignements = 1;
		Course course = new Course(numAssignements);
		String testStudent = "John";
		//Method Execution
		Boolean check = course.isStudentEnrolled(testStudent);
		//Verification
		if(check != false) {
		fail("The Check for a Student not in the System Failed.");
		}
	}

	
	/**
	 * Tests if the student has been enroled in the class and this time he has
	 * 
	 */
	@Test
	public void testIsStudentEnrolled2() {
		//Setup
		int numAssignements = 1;
		Course course = new Course(numAssignements);
		String testStudent = "John";
		course.addStudent(testStudent);
		
		//Method Execution
		Boolean check = course.isStudentEnrolled(testStudent);
		//Verification
		if(check != true) {
		fail("The Check for a Student in the System Failed.");
		}
	}
	
	
	/**
	 * Tests removing a student from the class however the student is not enrolled
	 */
	@Test
	public void testRemoveStudent() {
		//Setup
		int numAssignments = 1;
		Course course = new Course(numAssignments);
		String student = "Emily";
		//Method Execution
		Boolean check = course.removeStudent(student);
		//Verification
		if(check != false) {
			fail("The Student was removed while not being enrolled.");
		}		
	}

	/**
	 * Adds Student then Removes them.
	 */
	
	@Test
	public void testRemoveStudent2() {
		//Setup
		int numAssignments = 1;
		Course course = new Course(numAssignments);
		String student = "Emily";
		course.addStudent(student);
		//Method Execution
		Boolean check = course.removeStudent(student);
		//Verification
		if(check != true) {
			fail("The Student was not removed properly.");
		}		
	}
	
	/**
	 * Checks to See if you can add a grade into the system.
	 */
	@Test
	public void testSetStudentAssignmentGrade() {
		//Setup
		int numAssignments = 11;
		Course course= new Course(numAssignments);
		String student = "Chasidy";
		course.addStudent(student);
		int grades = 100;
		
		//Method Execution
		for (int i = 1; i <= numAssignments; i++) {
			Boolean check = course.setStudentAssignmentGrade(i, grades, student);
		//Verification
			if(check != true) {
				fail("Failed to assign grade to assignment.");
			}
		}
	}
	
	
	/**
	 * Tests grade assignment but the assigment is above the amount of grades
	 */
	@Test
	public void testSetStudentAssignmentGrade1() {
		//Setup
		int numAssignments = 11;
		Course course= new Course(numAssignments);
		String student = "Chasidy";
		course.addStudent(student);
		int grades = 100;
		int assigment = 20;
		//Method Execution
		Boolean check = course.setStudentAssignmentGrade(assigment, grades, student);
		//Verification	
		if(check != false) {
				fail("Somehow you assigned a grade outside of the grades.");
			}
	}
	
	
	/**
	 * Tests if you can enter a negative grade
	 */
	@Test
	public void testSetStudentAssignmentGrade3() {
		//Setup
		int numAssignments = 11;
		Course course= new Course(numAssignments);
		String student = "Chasidy";
		course.addStudent(student);
		int grades = -2;
		int assigment = 1;
		//Method Execution
		Boolean check = course.setStudentAssignmentGrade(assigment, grades, student);
		//Verification	
		if(check != false) {
				fail("Grade Was Negative and Passed");
			}
	}

	
	/** 
	 * Tests getting a grade for a student that was entered.
	 * Bug Fix in Primary Code -1 in array.
	 * 
	 */
	@Test
	public void testGetStudentAssignmentGrade() {
		//Setup
		int numAssignments = 5;
		Course course = new Course(numAssignments);
		String student = "Brittany";
		course.addStudent(student);
		int grades = 75;
		int assignment = 1;
		int grades2 = 67;
		int assignment2 = 2;
		//Method Execution
		course.setStudentAssignmentGrade(assignment, grades, student);
		course.setStudentAssignmentGrade(assignment2, grades2, student);
		int assignmentresult = course.getStudentAssignmentGrade(assignment, student);
		System.out.println(course.getStudentAssignmentGrade(assignment, student));
		//Verification
		if(assignmentresult != grades) {
			fail("Assignments Did not Match");
		}
		
	}
}