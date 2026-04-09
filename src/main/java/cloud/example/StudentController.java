package cloud.example;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    // List all students
    @GetMapping
    public String getAllStudents(Model model) {
        List<Student> students = repository.findAll();
        model.addAttribute("students", students);
        return "students"; // Thymeleaf template
    }

    // Show form to add student
    @GetMapping("/add")
    public String addStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "add-student";
    }

    // Save new student
    @PostMapping("/add")
    public String saveStudent(@ModelAttribute Student student) {
        repository.save(student);
        return "redirect:/students";
    }

     @GetMapping("/")
    public String hello() {
        return "Hello from Azure!";
    }
}
