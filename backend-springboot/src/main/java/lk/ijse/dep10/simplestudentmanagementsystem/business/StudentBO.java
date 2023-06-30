package lk.ijse.dep10.simplestudentmanagementsystem.business;

import lk.ijse.dep10.simplestudentmanagementsystem.dto.StudentDTO;

import java.util.List;

public interface StudentBO {
    StudentDTO saveStudent(StudentDTO studentDTO) throws Exception;

    void deleteStudentById(int studentId) throws Exception;

    List<StudentDTO> findStudents() throws Exception;
}
