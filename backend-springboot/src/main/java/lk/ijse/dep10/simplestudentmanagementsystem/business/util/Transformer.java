package lk.ijse.dep10.simplestudentmanagementsystem.business.util;

import lk.ijse.dep10.simplestudentmanagementsystem.dto.StudentDTO;
import lk.ijse.dep10.simplestudentmanagementsystem.entity.Student;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Transformer {

    private final ModelMapper mapper;

    public Transformer(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public Student toStudentEntity(StudentDTO studentDTO) {
        return mapper.map(studentDTO, Student.class);
    }

    public StudentDTO fromStudentEntity(Student studentEntity) {
        return mapper.map(studentEntity, StudentDTO.class);
    }
}
