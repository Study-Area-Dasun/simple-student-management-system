package lk.ijse.dep10.simplestudentmanagementsystem.dao.util;

import lk.ijse.dep10.simplestudentmanagementsystem.entity.Student;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class Mappers {
    public static final RowMapper<Student> STUDENT_ROW_MAPPER = ((rs, rowNum) -> {
        int id =rs.getInt("id");
        String name = rs.getString("name");
        String address = rs.getString("address");
        return  new Student(id,name,address);
    });
}

