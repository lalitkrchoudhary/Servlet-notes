package in.lalit.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import in.lalit.controller.IStudentController;
import in.lalit.dto.Student;
import in.lalit.factory.StudentControllerFactory;

public class TestApp {

	public static void main(String[] args) {
		
		IStudentController studentController=null;
		String status = null, name=null, country= null, city=null, email=null;
		Integer id=null;
		Student studentRecord=null;
		
	try {
		while(true) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("1. CREATE");
			System.out.println("2. READ");
			System.out.println("3. UPDATE");
			System.out.println("4. DELETE");
			System.out.println("5. EXIT");
			System.out.println("Your Option :: [1,2,3,4,5]");
			Integer option = Integer.parseInt(br.readLine());
			
			studentController= StudentControllerFactory.getStudentController();
			switch (option) {
			case 1:
			System.out.println("Enter the name");
			 name = br.readLine();
			System.out.println("Enter the country");
			 country = br.readLine();
			System.out.println("Enter the city");
			 city = br.readLine();
			System.out.println("Enter the email");
			 email = br.readLine();
			
				
			Student student = new Student();
			student.setName(name);
			student.setCountry(country);
			student.setCity(city);
			student.setEmail(email);
			
			 status= studentController.save(student);
			if(status.equalsIgnoreCase("success")) {
				System.out.println("Record inserted successfully");
			} else if(status.equalsIgnoreCase("failure")) {
				System.out.println("Record insetion failed");
			}else {
				System.out.println("some problem occured");
			}
			   break;
			   
			   
			case 2:
				System.out.println("Enter the id :: ");
				id = Integer.parseInt(br.readLine());
				studentRecord= studentController.findById(id);
				if (studentRecord !=null) {
					
					System.out.println(studentRecord);
				}
				else {
					System.out.println("Record is not available for the given id to delete::"+ id);
				}
				
				break;
				
				
			case 3:
				
				System.out.println("Enter the id to update the record :: ");
				id = Integer.parseInt(br.readLine());
				studentRecord= studentController.findById(id);
				
				if (studentRecord !=null) {
					Student newStudent = new Student();
					newStudent.setId(id);
					System.out.println("StudentName :: [Old name is :: "+studentRecord.getName()+"]");
					String newName= br.readLine();
					if(newName == null || newName.equals("")) {
						newStudent.setName(studentRecord.getName());
					}else {
						newStudent.setName(newName);
					}
					
					//
					System.out.println("StudentName :: [Old name is :: "+studentRecord.getCountry()+"]");
					String newCountry= br.readLine();
					if(newCountry == null || newCountry.equals("")) {
						newStudent.setCountry(studentRecord.getCountry());
					}else {
						newStudent.setCountry(newCountry);
					}
					
					//
					System.out.println("StudentCity :: [Old name is :: "+studentRecord.getCity()+"]");
					String newCity= br.readLine();
					if(newCity == null || newCity.equals("")) {
						newStudent.setCity(studentRecord.getCity());
					}else {
						newStudent.setCity(newCity);
					}
					
					//
					System.out.println("StudentEmail :: [Old name is :: "+studentRecord.getEmail()+"]");
					String newEmail= br.readLine();
					if(newEmail == null || newEmail.equals("")) {
						newStudent.setEmail(studentRecord.getEmail());
					}else {
						newStudent.setEmail(newEmail);
					}
					
					status =studentController.updateById(newStudent);
					if(status.equalsIgnoreCase("success")) {
						System.out.println("Record update successfully");
					} else if(status.equalsIgnoreCase("failure")) {
						System.out.println("Record update failed");
					}else {
						System.out.println("some problem occured");
					}
				}
				else {
					System.out.println("Record is not available for the given id to delete::"+ id);
				}
	        
				
				
				break;
			case 4:
				
				System.out.println("Enter the id ::");
				id =Integer.parseInt(br.readLine());
				status= studentController.deleteById(id);
				
				if(status.equalsIgnoreCase("success")) {
					System.out.println("Record delted successfully");
				} else if(status.equalsIgnoreCase("failure")) {
					System.out.println("Record deleted failed");
				}else {
					System.out.println("some problem occured");
				}
				
				
				break;
			case 5: System.out.println("Thanks for using the application");
			        System.exit(0);
				
			


			default: System.out.println("Plz enter form the option only");
				break;
			}
		}
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
		
		
		
		 
		
	}

}
