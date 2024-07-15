package in.lalit.factory;

import in.lalit.controller.IStudentController;
import in.lalit.controller.StudentControllerImpl;

public class StudentControllerFactory {

	private static IStudentController studentController = null;
	
	//one one object will create by doing private 
	private StudentControllerFactory() {
		
	}
	
	public static IStudentController getStudentController() {
		
		if(studentController == null)
		studentController = new StudentControllerImpl();
		
		return studentController;
	}
}
