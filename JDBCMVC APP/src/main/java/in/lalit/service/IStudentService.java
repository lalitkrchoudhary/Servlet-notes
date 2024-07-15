package in.lalit.service;

import in.lalit.dto.Student;

public interface IStudentService {
	
    String save(Student student); //Creating a record
	
	Student findById(Integer sid); // For reading record
	
	String updateById(Student student); //Update a record
	
	String deleteById(Integer sid); // Delete a record

}
