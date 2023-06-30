package lk.ijse.dep10.simplestudentmanagementsystem.api;

import lk.ijse.dep10.simplestudentmanagementsystem.business.StudentBO;
import lk.ijse.dep10.simplestudentmanagementsystem.dto.StudentDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentBO studentBO;

    public StudentController(StudentBO studentBO) {
        this.studentBO = studentBO;
    }

    @GetMapping
    public List<StudentDTO> getStudents() throws Exception {
        return studentBO.findStudents();
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public StudentDTO saveStudent(@RequestBody StudentDTO studentDTO) throws Exception {
        return studentBO.saveStudent(studentDTO);
    }

    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable("customerId") Integer studentId) throws Exception {
        studentBO.deleteStudentById(studentId);
    }

}
