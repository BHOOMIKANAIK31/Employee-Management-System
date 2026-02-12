package emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import emp.entity.Employee;
import emp.repository.EmployeeRespositoy;

@Controller
public class MyController {
	
	@Autowired
	EmployeeRespositoy repository;
	
@GetMapping	({"/","/main"})
public String  main() {
return "main";

}
@GetMapping	("/add")
public String  add() {
return "add";

}

@PostMapping	("/add")
public String  loadaddpage(Employee emp,RedirectAttributes attributes) {
	repository.save(emp);
	attributes.addFlashAttribute("message","records added successfully");
return "redirect:/main";

}
@GetMapping	("/manage")
public String  manage(ModelMap map,RedirectAttributes attributes) {
	List<Employee> list=repository.findAll();
	if (list.isEmpty()) {
		attributes.addFlashAttribute("message","no records present");
		return "redirect:/main";
	}
	map.put("list", list);
return "view";

}
@GetMapping	("/delete/{id}")
public String  delete(@PathVariable  Integer id,RedirectAttributes attributes) {
	repository.deleteById(id);
	attributes.addFlashAttribute("message","record deleted succesfully");
return "redirect:/manage";

}

@GetMapping	("/update/{id}")
public String  edit(@PathVariable  Integer id,ModelMap map) {
	Employee emp=repository.findById(id).get();
	map.put("emp", emp);
return "edit";
}

@PostMapping("/update")

public String update(@ModelAttribute Employee emp,RedirectAttributes attributes) {
	repository.save(emp);
	attributes.addFlashAttribute("message", "records update successfully");
	return "redirect:/manage";
}
}