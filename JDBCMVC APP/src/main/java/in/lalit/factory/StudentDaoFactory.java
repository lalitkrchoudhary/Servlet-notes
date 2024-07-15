package in.lalit.factory;

import in.lalit.dao.IStudentDao;
import in.lalit.dao.StudentDaoImpl;

public class StudentDaoFactory {
	
	private static IStudentDao studentDao= null;
	private StudentDaoFactory() {
		
	}
	
	public static IStudentDao getStudentDao() {
		if(studentDao==null)
		studentDao=	new StudentDaoImpl();
		
		return studentDao;
	}

}
