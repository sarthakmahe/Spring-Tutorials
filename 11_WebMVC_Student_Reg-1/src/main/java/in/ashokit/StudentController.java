package in.ashokit;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import in.ashokit.binding.Student;
import in.ashokit.entity.StudentEntity;
import in.ashokit.repo.StudentRepository;

@Controller
public class StudentController {
	
	
	@Autowired
	private StudentRepository repo;
	
	  
	//method to load student form
	@GetMapping("/")
	public String loadForm(Model model) {
		
		loadFormData(model);	
        
		return "index";
		
		
		
	}

	private void loadFormData(Model model) {
		List<String> coursesList =new ArrayList<>();
		coursesList.add("Java");
		coursesList.add("AWS");
		coursesList.add("Python");
		
		List<String> timingsList =new ArrayList<>();
		timingsList.add("morning");
		timingsList.add("evening");
		timingsList.add("Afternoon");
		
		model.addAttribute("courses",coursesList);
		model.addAttribute("timings",timingsList);
		
		
		Student student=new Student();
		model.addAttribute("courses",coursesList);
		model.addAttribute("timings",timingsList);
        model.addAttribute("student",student);
	}
	
	   //method to load  student form data
	
	@PostMapping("/Save")
	public String handleSubmit(Student s, Model model) {

	    System.out.println(s);

	    // save logic
        // repo.saveAll(s);
        
	    StudentEntity entity=new StudentEntity();
	    //copy data from binding obj to entity
	    
	    BeanUtils.copyProperties(s, entity);
	    entity.setTimings(Arrays.toString(s.getTimings()));
	    
	    repo.save(entity);
	    model.addAttribute("msg", "Student saved");

	    loadFormData(model);

	    return "index";
	   }
	   	   
	   // method to display save data
}
