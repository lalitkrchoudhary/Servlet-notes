package in.lalit.factory;

import in.lalit.service.IStudentService;
import in.lalit.service.StudentServiceImpl;

public class StudentServiceFactory {
	
	private static IStudentService studentServiceImpl;
	
	// this is used for singleTon object means outside the world no one can create the object
	private StudentServiceFactory() {
		
	}
	
	public static IStudentService getStudentService() {
		if(studentServiceImpl==null)
			studentServiceImpl = new StudentServiceImpl();
		
		return studentServiceImpl;
	}

	
	
}
