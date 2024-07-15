package in.lalit.controller;

import in.lalit.dto.Student;
import in.lalit.factory.StudentControllerFactory;
import in.lalit.factory.StudentServiceFactory;
import in.lalit.service.IStudentService;


public class StudentControllerImpl implements IStudentController{
	
	IStudentService stdService;

	@Override
	public String save(Student student) {
		stdService= StudentServiceFactory.getStudentService();
		 System.out.println("Implementation classname is :: "+stdService.getClass().getName());
		  return stdService.save(student);
		
	}

	@Override
	public Student findById(Integer sid) {
		stdService= StudentServiceFactory.getStudentService();
		
		return stdService.findById(sid);
	}

	@Override
	public String updateById(Student student) {
		stdService= StudentServiceFactory.getStudentService();
	    return stdService.updateById(student);	
	}

	@Override
	public String deleteById(Integer sid) {
		stdService= StudentServiceFactory.getStudentService();
		return stdService.deleteById(sid);

	}

}
