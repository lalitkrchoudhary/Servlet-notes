package in.lalit.service;

import in.lalit.dao.IStudentDao;
import in.lalit.dto.Student;
import in.lalit.factory.StudentDaoFactory;
import in.lalit.factory.StudentServiceFactory;

public class StudentServiceImpl implements IStudentService {
	
	IStudentDao studentDao;

	@Override
	public String save(Student student) {
        studentDao =StudentDaoFactory.getStudentDao();
        System.out.println("Implementation classname is ::"+ studentDao.getClass().getName());
        return studentDao.save(student);
				
	}

	@Override
	public Student findById(Integer sid) {
	  studentDao=	StudentDaoFactory.getStudentDao();
	  
	  return studentDao.findById(sid);
	}

	@Override
	public String updateById(Student student) {
		studentDao= StudentDaoFactory.getStudentDao();
			return studentDao.updateById(student);
	}

	@Override
	public String deleteById(Integer sid) {
		studentDao= StudentDaoFactory.getStudentDao();
		return studentDao.deleteById(sid);

	}

}
