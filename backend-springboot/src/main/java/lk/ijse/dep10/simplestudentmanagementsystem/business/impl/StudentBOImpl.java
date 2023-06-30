package lk.ijse.dep10.simplestudentmanagementsystem.business.impl;

import lk.ijse.dep10.simplestudentmanagementsystem.business.StudentBO;
import lk.ijse.dep10.simplestudentmanagementsystem.business.util.Transformer;
import lk.ijse.dep10.simplestudentmanagementsystem.dao.custom.StudentDAO;
import lk.ijse.dep10.simplestudentmanagementsystem.dto.StudentDTO;
import lk.ijse.dep10.simplestudentmanagementsystem.entity.Student;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class StudentBOImpl implements StudentBO {

    private final StudentDAO studentDAO;
    private final Transformer transformer;

    public StudentBOImpl(StudentDAO studentDAO, Transformer transformer) {
        this.studentDAO = studentDAO;
        this.transformer = transformer;
    }

    @Override
    public StudentDTO saveStudent(StudentDTO studentDTO) throws Exception {
        return transformer.fromStudentEntity(studentDAO.save(transformer.toStudentEntity(studentDTO)));
    }

    @Override
    public void deleteStudentById(int studentId) throws Exception {
        studentDAO.deleteById(studentId);
    }

    @Override
    public List<StudentDTO> findStudents() throws Exception {
        return studentDAO.findAll().stream().map(transformer::fromStudentEntity).collect(Collectors.toList());
    }
}
